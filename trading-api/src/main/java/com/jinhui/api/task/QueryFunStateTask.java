package com.jinhui.api.task;

import com.jinhui.api.constants.PayState;
import com.jinhui.api.constants.TransState;
import com.jinhui.api.constants.ZlrtInstCode;
import com.jinhui.api.controller.AccountTest;
import com.jinhui.api.entity.po.TradeFundTransfer;
import com.jinhui.api.mapper.trade.TradeConsignDao;
import com.jinhui.api.mapper.trade.TradeFundTransferDao;
import com.jinhui.api.utils.DateUtils;
import com.jinhui.common.service.IdService;
import com.jinhui.common.utils.ResultResp;
import com.jinhui.zlrt.entity.dto.TradeStatusSearchRequest;
import com.jinhui.zlrt.entity.dto.TradeStatusSearchResponse;
import com.jinhui.zlrt.service.ZlrtBussService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 定时查询trade_fund_transfer中已报状态的申购交易是否已经成功了
 */
@Component
public class QueryFunStateTask {

    private static Logger logger = LoggerFactory.getLogger(QueryFunStateTask.class);

    @Autowired
    private TradeFundTransferDao fundTransferDao;


    @Autowired
    private ZlrtBussService zlrtBussService;

    @Autowired
    private TradeConsignDao tradeConsignDao;


    @Autowired
    private IdService idService;

    /**
     * 每5分钟查询一次
     */
    @Scheduled(cron = "0 */5 * * * ?")
    public void queryTradeFundTransfer() {

        //TODO 查询数据库中资金划转表的记录（写一个mysql的分页批次处理类，对数据库的数据进行分页处理）

        //查询“已报”的记录
        List<TradeFundTransfer> fundTransfers = fundTransferDao.selectByPayStatus(PayState.SUBMIT);

        for (TradeFundTransfer fundTransfer : fundTransfers) {
            //再去证联查询一遍
            TradeStatusSearchRequest request = new TradeStatusSearchRequest();

            request.setBusiType("0002");
            request.setInstuId(ZlrtInstCode.JINHUI.getCode());
            request.setOrgFundDate(DateUtils.toDateStr(fundTransfer.getApplyDate()));
            request.setOrgFundSeqId(fundTransfer.getTransferNo());
            ResultResp<TradeStatusSearchResponse> resultResp = zlrtBussService.tradeStatusSeach(request);
            TradeStatusSearchResponse response = resultResp.getData();

            if (resultResp.isSuccess()) {//成功
                if (response.getTransRespCode().equals("00")) {//等待付款
                    return;
                }
                if (response.getTransRespCode().equals("01")) {//付款成功
                    logger.debug("applyNo{}更新资金划转的状态为成功", fundTransfer.getApplyNo());
                    //更新资金划转表的状态
                    fundTransferDao.updateStateByPayStatus(fundTransfer.getApplyNo(), PayState.SUCCESS);
                    return;
                }

                //失败
                fundTransferDao.updateStateByPayStatus(fundTransfer.getApplyNo(), PayState.FAIL);
                tradeConsignDao.updateStateByApplyNo(fundTransfer.getApplyNo(), TransState.FAIL);

            }
            if (!resultResp.isSuccess()) {//失败
                //待处理
            }
        }

    }


}
