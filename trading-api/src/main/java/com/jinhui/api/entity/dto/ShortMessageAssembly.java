package com.jinhui.api.entity.dto;

import com.jinhui.api.constants.BussStatus;
import com.jinhui.api.constants.IDType;
import com.jinhui.api.constants.ZlrtInstCode;
import com.jinhui.api.entity.po.BussSerialRecord;
import com.jinhui.api.utils.DateUtils;
import com.jinhui.zlrt.entity.dto.SendCodeRequest;

import java.util.Date;

/**
 * Created by Administrator on 2018/2/27 0027.
 */
public class ShortMessageAssembly {


    /**
     * 构造发短信业务流水记录
     */
    public static BussSerialRecord toBussSerialRecord(ShortMessage shortMessage,String bussFlag) {
        System.out.println();
        BussSerialRecord record1 = new BussSerialRecord();
        record1.setName(shortMessage.getUserNameText());//投资人姓名
        record1.setApplyDate(DateUtils.toDate(shortMessage.getFundDate()));//申请日期
        record1.setApplyTime(DateUtils.toTime(shortMessage.getFundTime()));//申请时间
        record1.setApplyNo(shortMessage.getFundSeqId());//申请单号
        record1.setBussFlag(bussFlag);//业务标识
        record1.setChnCode(shortMessage.getChannelCode());//渠道方代码
        record1.setBussStatus(BussStatus.CONFIRM);//业务状态
        record1.setChnId(shortMessage.getChannelUserId());//渠道用户ID
        record1.setCreateTime(new Date());
        return record1;
    }




    /**
     * 构造证联的发送短信请求
     */
    public static SendCodeRequest toSendCodeRequest(ShortMessage shortMessage) {

        SendCodeRequest request = new SendCodeRequest();

        request.setInstuId(ZlrtInstCode.JINHUI.getCode());//证联支付分配给商户的机构代码
        request.setMerchantDate(shortMessage.getFundDate());//商户的系统日期(YYYYMMDD)
        request.setMerchantTime(shortMessage.getFundTime().substring(8));//商户的时间戳(HHMMSS)
        request.setMerchantSeqId(shortMessage.getFundSeqId());//交易流水
        request.setUserNameText(shortMessage.getUserNameText());//客户的姓名
        request.setCertType(IDType.transform(shortMessage.getCertType()));//证件类型
        request.setCertId(shortMessage.getCertId());//证件号码
        request.setBankCode(shortMessage.getBankCode()); //银行代码
        request.setCardNo(shortMessage.getCardNo());//银行卡号
        request.setAmt(shortMessage.getAmount());//金额
        request.setTradeType(shortMessage.getTradeCode());//短信验证业务类型
        request.setMobile(shortMessage.getPhoneNo());



        return request;
    }

}
