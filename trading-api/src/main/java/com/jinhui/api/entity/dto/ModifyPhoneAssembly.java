package com.jinhui.api.entity.dto;

import com.jinhui.api.constants.BusinessCode;
import com.jinhui.api.constants.BussStatus;
import com.jinhui.api.constants.IDType;
import com.jinhui.api.constants.ZlrtInstCode;
import com.jinhui.api.entity.po.BussSerialRecord;
import com.jinhui.api.utils.DateUtils;
import com.jinhui.zlrt.entity.dto.ChangeMobileNoRequest;

import java.util.Date;

/**
 * Created by Administrator on 2018/1/26 0026.
 */
public class ModifyPhoneAssembly {


    /**
     * 得到业务流水记录
     */
    public static BussSerialRecord toBussSerialRecord(ModifyPhone modifyPhone) {

        BussSerialRecord record = new BussSerialRecord();
        record.setName(modifyPhone.getUserNameText());//投资人姓名
        record.setApplyDate(DateUtils.toDate(modifyPhone.getFundDate()));//申请日期
        record.setApplyTime(DateUtils.toTime(modifyPhone.getFundTime()));//申请时间
        record.setApplyNo(modifyPhone.getFundSeqId());//申请单号
        record.setBussFlag(BusinessCode.CHANGE_USER_INFO);//业务标识
        record.setChnCode(modifyPhone.getChannelCode());//渠道方代码
        record.setBussStatus(BussStatus.CONFIRM);//业务状态
        record.setChnId(modifyPhone.getChannelUserId());//渠道用户ID
        record.setCreateTime(new Date());
        return record;
    }

    /**
     * 构建证联请求
     */
    public static ChangeMobileNoRequest toChangeMobileNoRequest(ModifyPhone modifyPhone, String transferNo, String userId) {

        ChangeMobileNoRequest request = new ChangeMobileNoRequest();
        request.setInstuId(ZlrtInstCode.JINHUI.getCode()); //证联支付分配给商户的机构代码
        request.setFundDate(modifyPhone.getFundDate());   //商户的系统日期(YYYYMMDD)
        request.setFundTime(modifyPhone.getFundTime().substring(8)); //商户的时间戳(HHMMSS)
        request.setFundSeqId(transferNo); //商户系统流水号
        request.setUserNameText(modifyPhone.getUserNameText()); //客户的姓名
        request.setCertType(IDType.transform(modifyPhone.getCertType()));  //证件类型
        request.setCertId(modifyPhone.getCertId()); //证件号码
        request.setPrePhone(modifyPhone.getOriginPhoneNo()); //原始手机号
        request.setNewPhone(modifyPhone.getModifyPhoneNo());  //变更之后的客户手机号
        request.setUserId(userId);//用户在证联支付平台里的客户号

        return request;

    }
}
