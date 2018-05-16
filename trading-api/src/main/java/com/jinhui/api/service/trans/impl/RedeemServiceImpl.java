package com.jinhui.api.service.trans.impl;

import com.jinhui.api.constants.BussStatus;
import com.jinhui.api.constants.PayState;
import com.jinhui.api.constants.RespCode;
import com.jinhui.api.constants.TransState;
import com.jinhui.api.entity.dto.Redeeming;
import com.jinhui.api.entity.dto.RedeemingAssembly;
import com.jinhui.api.entity.po.BussSerialRecord;
import com.jinhui.api.entity.po.InvestorPosition;
import com.jinhui.api.entity.po.TradeConsign;
import com.jinhui.api.entity.po.TradeFundTransfer;
import com.jinhui.api.mapper.trade.BussSerialRecordDao;
import com.jinhui.api.mapper.trade.InvestorPositionDao;
import com.jinhui.api.mapper.trade.TradeConsignDao;
import com.jinhui.api.mapper.trade.TradeFundTransferDao;
import com.jinhui.api.service.trans.RedeemService;
import com.jinhui.common.exception.BizException;
import com.jinhui.common.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018/1/30 0030.
 */
@Service
public class RedeemServiceImpl implements RedeemService {


    @Autowired
    private BussSerialRecordDao bussSerialRecordDao;

    @Autowired
    private TradeConsignDao tradeConsignDao;

    @Autowired
    private TradeFundTransferDao tradeFundTransferDao;

    @Autowired
    private IdService idService;

    @Autowired
    private InvestorPositionDao investorPositionDao;


    @Override
    public Redeeming redeemFunds(Redeeming redeeming) {

        //有持仓并且持仓余额足够才能赎回
        InvestorPosition position = investorPositionDao.selectByChnIdAndProduct(redeeming.getChannelUserId(), redeeming.getProductCode());
        if (position == null) {
            throw new BizException("该用户的持仓金额不足");
        }
        if (position.getTotalPostionAmount().compareTo(new BigDecimal(redeeming.getAmount())) < 0) {
            throw new BizException("该用户的持仓金额不足");
        }

        //记录交易流水
        BussSerialRecord bussSerialRecord = RedeemingAssembly.toBussSerialRecord(redeeming);
        bussSerialRecordDao.insert(bussSerialRecord);

        //保存交易委托记录
        TradeConsign tradeConsign = RedeemingAssembly.toTradeConsign(redeeming);
        tradeConsignDao.insert(tradeConsign);

        //生成资金划转流水号
        String transferNo = idService.generateTransferNo();

        //保存资金划转记录
        TradeFundTransfer tradeFundTransfer = RedeemingAssembly.toTradeFundTransfer(redeeming, transferNo);
        tradeFundTransferDao.insert(tradeFundTransfer);

        //减去用户的持仓
        int i = investorPositionDao.subtractPosition(redeeming.getChannelUserId(), redeeming.getProductCode(), new BigDecimal(redeeming.getAmount()));

        if (i == 0) {//失败

            //更新交易流水
            bussSerialRecord.setBussStatus(BussStatus.FAIL);
            redeeming.setTransState(TransState.FAIL);
            redeeming.setRespCode(RespCode.TRANS_FAIL);
            bussSerialRecordDao.updateStateByApplyNo(bussSerialRecord);

            //更新交易委托表，改为"失败"
            tradeConsignDao.updateStateByApplyNo(redeeming.getFundSeqId(), TransState.FAIL);
            //更新资金划转状态,改为"失败"
            tradeFundTransferDao.updateStateByPayStatus(redeeming.getFundSeqId(), PayState.FAIL);

        } else {//
            //更新交易流水
            bussSerialRecord.setBussStatus(BussStatus.SUCCESS);
            redeeming.setTransState(TransState.SUCCESS);
            redeeming.setRespCode(RespCode.TRANS_SUCCESS);
            bussSerialRecordDao.updateStateByApplyNo(bussSerialRecord);
        }


        return redeeming;


    }
}
