package com.jinhui.api.service.trans.impl;

import com.jinhui.api.constants.BussStatus;
import com.jinhui.api.constants.PayState;
import com.jinhui.api.constants.RespCode;
import com.jinhui.api.constants.TransState;
import com.jinhui.api.entity.dto.Purchasing;
import com.jinhui.api.entity.dto.PurchasingAssembly;
import com.jinhui.api.entity.po.BussSerialRecord;
import com.jinhui.api.entity.po.ExchangeOpen;
import com.jinhui.api.entity.po.TradeConsign;
import com.jinhui.api.entity.po.TradeFundTransfer;
import com.jinhui.api.mapper.trade.*;
import com.jinhui.api.service.trans.ChnProductService;
import com.jinhui.api.service.trans.PurchaseService;
import com.jinhui.api.utils.DateUtils;
import com.jinhui.common.service.IdService;
import com.jinhui.common.utils.ResultResp;
import com.jinhui.zlrt.entity.dto.ChangeMobileNoResponse;
import com.jinhui.zlrt.entity.dto.PurchaseRequest;
import com.jinhui.zlrt.entity.dto.PurchaseResponse;
import com.jinhui.zlrt.service.ZlrtBussService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/1/30 0030.
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

    private static Logger logger = LoggerFactory.getLogger(PurchaseServiceImpl.class);

    @Autowired
    private BussSerialRecordDao bussSerialRecordDao;

    @Autowired
    private ZlrtBussService zlrtBussService;

    @Autowired
    private TradeConsignDao tradeConsignDao;

    @Autowired
    private TradeFundTransferDao tradeFundTransferDao;

    @Autowired
    private IdService idService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ChnProductService chnProductService;

    @Autowired
    private ExchangeOpenDao exchangeOpenDao;


    @Override
//    @Transactional(rollbackFor = Exception.class, value = "tradeTransactionManager")
    public Purchasing purchaseFunds(Purchasing purchasing) {

        //申购前，先减去产品的库存
        chnProductService.subtractProductLimit(purchasing.getChannelCode(), purchasing.getProductCode(), purchasing.getAmount());

        //记录交易流水
        BussSerialRecord serialRecord = PurchasingAssembly.toBussSerialRecord(purchasing);
        bussSerialRecordDao.insert(serialRecord);

        //保存交易委托记录
        TradeConsign tradeConsign = PurchasingAssembly.toTradeConsign(purchasing);
        tradeConsignDao.insert(tradeConsign);

        //生成资金划转流水号
        String transferNo = idService.generateTransferNo();

        //保存资金划转记录
        TradeFundTransfer fundTransfer = PurchasingAssembly.toTradeFundTransfer(purchasing, transferNo);
        tradeFundTransferDao.insert(fundTransfer);

        //查询用户证联客户号
        String zlrtUserId = userDao.selectZlrtUserIdByChnId(purchasing.getChannelUserId());

        //向证联发起支付请求
        PurchaseRequest purchaseRequest = PurchasingAssembly.toPurchaseRequest(purchasing, transferNo, zlrtUserId);
        ResultResp<PurchaseResponse> resultResp = zlrtBussService.purchase(purchaseRequest);

        if (resultResp.isException()) {//异常
            logger.info("申购失败");

            //更新流水状态,改为"失败"
            serialRecord.setBussStatus(BussStatus.FAIL);
            serialRecord.setZlRespMsg(resultResp.getMsg());
            bussSerialRecordDao.updateStateByApplyNo(serialRecord);

            //更新交易委托表，改为"失败"
            tradeConsignDao.updateStateByApplyNo(purchasing.getFundSeqId(), TransState.FAIL);

            //更新资金划转状态,改为"失败"
            tradeFundTransferDao.updateStateByPayStatus(purchasing.getFundSeqId(), PayState.FAIL);

            //支付失败把库存返回
            chnProductService.increaseProductLimit(purchasing.getChannelCode(), purchasing.getProductCode(), purchasing.getAmount());

            purchasing.setRespCode(RespCode.SYSTEM_ERROR);
            purchasing.setErrorMsg(resultResp.getMsg());
            return purchasing;
        }


        PurchaseResponse response = resultResp.getData();

        if (resultResp.isHanding()) {//交易确认中

            //更新资金划转状态,改为"已报"
            tradeFundTransferDao.updateStateByPayStatus(purchasing.getFundSeqId(), PayState.SUBMIT);

            //流水状态和交易委托状态不变，还是确认中
            serialRecord.setBussStatus(BussStatus.CONFIRM);
            serialRecord.setZlUserId(response.getUserId());
            serialRecord.setZlHandelDate(DateUtils.toDate(response.getPnrDate()));
            serialRecord.setZlHandleTime(DateUtils.toTime(response.getPnrDate() + response.getPnrTime()));
            serialRecord.setZlSerialNo(response.getPnrSeqId());
            bussSerialRecordDao.updateStateByApplyNo(serialRecord);
            purchasing.setTransState(TransState.CONFIRM);
            purchasing.setRespCode(response.getRespCode());
            purchasing.setErrorMsg("已付款");
            return purchasing;
        }


        if (resultResp.isSuccess()) {//成功

            //更新流水状态,改为"成功"
            updateSerialRecord(BussStatus.SUCCESS, serialRecord, response);

            //更新资金划转状态,改为"成功"
            tradeFundTransferDao.updateStateByPayStatus(purchasing.getFundSeqId(), PayState.SUCCESS);

            // 更新交易委托表的状态要等到清算结束才能更新为成功
            purchasing.setTransState(TransState.CONFIRM);

            //如果该客户是第一次购买某个交易所的产品，需要在交易所开户，在exchange_open表中插入一条记录
            int i = exchangeOpenDao.selectIsOpen(purchasing.getChannelUserId(), purchasing.getProductCode());
            if (i == 0) {
                String exchangeNo = productDao.selectByCode(purchasing.getProductCode()).getExchangeNo();
                String applyNo = userDao.selectByChnId(purchasing.getChannelUserId()).getApplyNo();
                ExchangeOpen exchangeOpen = PurchasingAssembly.toExchangeOpen(purchasing, exchangeNo, applyNo);
                exchangeOpenDao.insert(exchangeOpen);
            }

        }

        if (resultResp.isFail()) {//失败
            //更新流水状态,改为"失败"
            updateSerialRecord(BussStatus.FAIL, serialRecord, response);

            //更新交易委托表，改为"失败"
            tradeConsignDao.updateStateByApplyNo(purchasing.getFundSeqId(), TransState.FAIL);

            //更新资金划转状态,改为"失败"
            tradeFundTransferDao.updateStateByPayStatus(purchasing.getFundSeqId(), PayState.FAIL);

            purchasing.setTransState(TransState.FAIL);

            //支付失败把库存返回
            chnProductService.increaseProductLimit(purchasing.getChannelCode(), purchasing.getProductCode(), purchasing.getAmount());
        }
        purchasing.setRespCode(response.getRespCode());
        purchasing.setErrorMsg(response.getRespDesc());

        return purchasing;
    }


    /**
     * 更新流水状态
     */
    private void updateSerialRecord(String bussStatus, BussSerialRecord record, PurchaseResponse response) {

        if (StringUtils.isNotEmpty(response.getUserId())) {
            record.setZlUserId(response.getUserId());
        }
        if (StringUtils.isNotEmpty(response.getPnrDate())) {
            record.setZlHandelDate(DateUtils.toDate(response.getPnrDate()));
        }
        if (StringUtils.isNotEmpty(response.getPnrDate())) {
            record.setZlHandleTime(DateUtils.toTime(response.getPnrDate() + response.getPnrTime()));
        }
        if (StringUtils.isNotEmpty(response.getFundSeqId())) {
            record.setZlSerialNo(response.getPnrSeqId());
        }

        record.setTransferNo(response.getFundSeqId());
        record.setZlRespCode(response.getRespCode());
        record.setZlRespMsg(response.getRespDesc());
        record.setBussStatus(bussStatus);
        bussSerialRecordDao.updateStateByApplyNo(record);
    }


}
