package com.jinhui.zlrt.service.impl;

import com.jinhui.common.utils.ResultResp;
import com.jinhui.zlrt.common.ZlrtTransCodeConstant;
import com.jinhui.zlrt.entity.dto.*;
import com.jinhui.zlrt.service.ZlrtBussService;
import com.jinhui.zlrt.utils.ZlrtHttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 证联支付相关业务服务层实现
 *
 * @autor wsc
 * @create 2018-01-30 15:24
 **/
@Service
public class ZlrtBussServiceImpl implements ZlrtBussService{
    private static Logger logger = LoggerFactory.getLogger(ZlrtBussServiceImpl.class);


    @Override
    public ResultResp sendCode(SendCodeRequest sendCodeRequest) {
        //发送验证码 2305
        try {
            SendCodeResponse resp = ZlrtHttpUtils.sendCode(sendCodeRequest);
            logger.info("返回： " + resp.toString());
            if(ZlrtTransCodeConstant.SUCCESS_CODE.equals(resp.getRespCode())){
                return ResultResp.successData(resp);
            }else{
                return ResultResp.failData(resp);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            return ResultResp.exceptionData(e.getMessage());
        }
    }

    public ResultResp openAccount(OpenAccountRequest openAccountRequest) {
        //证联保证金支付用户开户108
        try {
            OpenAccountResponse resp = ZlrtHttpUtils.openAccount(openAccountRequest);
            logger.info("返回： " + resp.toString());
            if(ZlrtTransCodeConstant.SUCCESS_CODE.equals(resp.getRespCode())){
                return ResultResp.successData(resp);
            }else{
                return ResultResp.failData(resp);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            return ResultResp.exceptionData(e.getMessage());
        }

    }

    public ResultResp addBankCard(AddBankCardRequest addBankCardRequest) {
        //证联保证金支付用户新增银行卡109
        try {
            AddBankCardResponse resp = ZlrtHttpUtils.addBankCard(addBankCardRequest);
            logger.info("返回： " + resp.toString());
            if("RC00".equals(resp.getRespCode())){
                return ResultResp.successData(resp);
            }else{
                return ResultResp.failData(resp);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            return ResultResp.exceptionData(e.getMessage());
        }

    }

    public ResultResp cancelBankCard(CancelBankCardRequest cancelBankCardRequest) {
        //证联取消银行卡103
        try {
            CancelBankCardResponse resp = ZlrtHttpUtils.cancelBankCard(cancelBankCardRequest);
            logger.info("返回： " + resp.toString());
            if(ZlrtTransCodeConstant.SUCCESS_CODE.equals(resp.getRespCode())){
                return ResultResp.successData(resp);
            }else{
                return ResultResp.failData(resp);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            return ResultResp.exceptionData(e.getMessage());
        }

    }

    public ResultResp changeMobileNo(ChangeMobileNoRequest changeMobileNoRequest) {
        //证联客户手机号变更117
        try {
            ChangeMobileNoResponse resp = ZlrtHttpUtils.changeMobileNo(changeMobileNoRequest);
            logger.info("返回： " + resp.toString());
            if(ZlrtTransCodeConstant.SUCCESS_CODE.equals(resp.getRespCode())){
                return ResultResp.successData(resp);
            }else{
                return ResultResp.failData(resp);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            return ResultResp.exceptionData(e.getMessage());
        }

    }

    public ResultResp purchase(PurchaseRequest purchaseRequest) {
        //证联后台申购302
        try {
            PurchaseResponse resp = ZlrtHttpUtils.purchase(purchaseRequest);
            logger.info("返回： " + resp.toString());
            if(ZlrtTransCodeConstant.SUCCESS_CODE.equals(resp.getRespCode())){
                return ResultResp.successData(resp);
            }else if(ZlrtTransCodeConstant.HANDING_CODE.equals(resp.getRespCode())){
                //申购返回处理中状态 再次发送5次交易状态查询
                TradeStatusSearchRequest tradeStatusSearchRequest = new TradeStatusSearchRequest();
                tradeStatusSearchRequest.setInstuId(purchaseRequest.getInstuId());
                tradeStatusSearchRequest.setOrgFundDate(purchaseRequest.getFundDate());
                tradeStatusSearchRequest.setOrgFundSeqId(purchaseRequest.getFundSeqId());
                tradeStatusSearchRequest.setBusiType(purchaseRequest.getBusiType());
                TradeStatusSearchResponse msg = new TradeStatusSearchResponse();
                for(int i=0; i<5;i++){
                    logger.info("交易处理中再次查询： " + i + "  "+ purchaseRequest.getFundSeqId());
                    msg = ZlrtHttpUtils.tradeStatusSeach(tradeStatusSearchRequest);
                    resp.setRespCode(msg.getRespCode());
                    resp.setRespDesc(msg.getRespDesc());
                    if(ZlrtTransCodeConstant.SUCCESS_CODE.equals(msg.getRespCode()) && ZlrtTransCodeConstant.PAY_SUCCESS_CODE.equals(msg.getTransRespCode())){
                        return ResultResp.successData(resp);
                    }else if(ZlrtTransCodeConstant.HANDING_CODE.equals(msg.getRespCode()) || ZlrtTransCodeConstant.WAIT_PAY_CODE.equals(msg.getTransRespCode())){
                        //继续查询
                    }else{
                        resp.setRespCode(msg.getTransRespCode());
                        resp.setRespDesc(msg.getTransRespDesc());
                        return ResultResp.failData(resp);
                    }
                }
                return ResultResp.handingData(resp);
            }else{
                return ResultResp.failData(resp);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            return ResultResp.exceptionData(e.getMessage());
        }
    }

    public ResultResp tradeStatusSeach(TradeStatusSearchRequest tradeStatusSearchRequest) {
        //证联交易状态查询501
        try {
            TradeStatusSearchResponse resp = ZlrtHttpUtils.tradeStatusSeach(tradeStatusSearchRequest);
            logger.info("返回： " + resp.toString());
            if(ZlrtTransCodeConstant.SUCCESS_CODE.equals(resp.getRespCode())){
                return ResultResp.successData(resp);
            }else{
                return ResultResp.failData(resp);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            return ResultResp.exceptionData(e.getMessage());
        }

    }
}
