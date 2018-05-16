package com.jinhui.zlrt.controller;

import com.jinhui.common.utils.ResultResp;
import com.jinhui.zlrt.entity.dto.TradeStatusSearchRequest;
import com.jinhui.zlrt.service.SyncDataServcie;
import com.jinhui.zlrt.utils.ZlrtHttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 从清算系统同步数据到交易系统
 *
 * @autor wsc
 * @create 2018-02-08 13:51
 **/
@Controller
@RequestMapping("syncData")
public class SyncDataController {
    private static Logger logger = LoggerFactory.getLogger(SyncDataController.class);

    @Autowired
    private SyncDataServcie syncDataServcie;

    @RequestMapping(value="/syncAllData",method = RequestMethod.GET)
    @ResponseBody
    public ResultResp syncProduct(){
        syncDataServcie.syncBatchDate();
        syncDataServcie.syncProduct();
        syncDataServcie.syncChnProduct();
        syncDataServcie.syncChnInfo();
        syncDataServcie.syncExchangeInfo();
        //syncDataServcie.syncBussGather();
        syncDataServcie.syncIncome();
        syncDataServcie.syncPosition();

        return ResultResp.success("同步数据成功！");
    }

    @RequestMapping(value="/syncStatus",method = RequestMethod.GET)
    @ResponseBody
    public ResultResp syncTradeStatus(){
        syncDataServcie.syncUserState();
        syncDataServcie.syncTransState();

        return ResultResp.success("同步客户和交易状态成功！");
    }

    @RequestMapping(value="/syncChnProduct",method = RequestMethod.GET)
    @ResponseBody
    public ResultResp syncChnProduct(){
        syncDataServcie.syncChnProduct();

        return ResultResp.success("同步渠道产品成功！");
    }

    @RequestMapping(value="/testZlRT",method = RequestMethod.GET)
    @ResponseBody
    public void testZlRT(){
        TradeStatusSearchRequest tradeStatusSearchRequest = new TradeStatusSearchRequest();
        tradeStatusSearchRequest.setInstuId("B00000603");
        tradeStatusSearchRequest.setOrgFundDate("20180226");
        tradeStatusSearchRequest.setOrgFundSeqId("7013333330303342");
        tradeStatusSearchRequest.setBusiType("0002");

        try {
            System.out.println(ZlrtHttpUtils.tradeStatusSeach(tradeStatusSearchRequest).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
