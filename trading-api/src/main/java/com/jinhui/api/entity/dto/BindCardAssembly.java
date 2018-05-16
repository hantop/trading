package com.jinhui.api.entity.dto;

import com.jinhui.api.constants.BussStatus;
import com.jinhui.api.constants.ChannelCode;
import com.jinhui.api.constants.IDType;
import com.jinhui.api.constants.ZlrtInstCode;
import com.jinhui.api.entity.po.BindCardInfo;
import com.jinhui.api.entity.po.BussSerialRecord;
import com.jinhui.api.utils.DateUtils;
import com.jinhui.zlrt.entity.dto.AddBankCardRequest;
import com.jinhui.zlrt.entity.dto.CancelBankCardRequest;

import java.util.Date;

/**
 * Created by Administrator on 2018/1/26 0026.
 */
public class BindCardAssembly {


    /**
     * 构造业务流水记录
     */
    public static BussSerialRecord toBussSerialRecord(BindCard bindCard, String businessCode) {

        BussSerialRecord record = new BussSerialRecord();
        record.setName(bindCard.getUserNameText());//投资人姓名
        record.setApplyDate(DateUtils.toDate(bindCard.getFundDate()));//申请日期
        record.setApplyTime(DateUtils.toTime(bindCard.getFundTime()));//申请时间
        record.setApplyNo(bindCard.getFundSeqId());//申请单号
        record.setBussFlag(businessCode);//业务标识
        record.setChnCode(bindCard.getChannelCode());//渠道方代码
        record.setBussStatus(BussStatus.CONFIRM);//业务状态
        record.setChnId(bindCard.getChannelUserId());//渠道用户ID
        record.setCreateTime(new Date());
        return record;
    }

    /**
     * 构造用户绑卡信息
     */
    public static BindCardInfo toBindCardInfo(BindCard bindCard) {
        System.out.println();
        BindCardInfo info = new BindCardInfo();
        info.setName(bindCard.getUserNameText());//投资人姓名
        info.setChnId(bindCard.getChannelUserId());//渠道用户ID
        info.setChnCode(bindCard.getChannelCode());//渠道方代码
        info.setOpenBank(bindCard.getBankCode());//开户行
        info.setBankAccount(bindCard.getCardNo());//银行账号
        info.setProvince(bindCard.getBankProvinceCode());//银行所属省份
        info.setCity(bindCard.getBankRegionCode());//银行所属地区
        info.setMobileNo(bindCard.getPhoneNo());//手机号
        info.setCounterNo(ChannelCode.getCounterNoByCode(bindCard.getChannelCode()));//柜台号
        info.setCreateTime(new Date());
        return info;
    }

    /**
     * 构建绑卡证联请求
     */
    public static AddBankCardRequest toAddBankCardRequest(BindCard bindCard, String transferNo,String userId) {

        AddBankCardRequest request = new AddBankCardRequest();

        request.setInstuId(ZlrtInstCode.JINHUI.getCode()); //证联支付分配给商户的机构代码
        request.setFundDate(bindCard.getFundDate());   //商户的系统日期(YYYYMMDD)
        request.setFundTime(bindCard.getFundTime().substring(8)); //商户的时间戳(HHMMSS)
        request.setFundSeqId(transferNo); //商户系统流水号
        request.setUserNameText(bindCard.getUserNameText()); //客户的姓名
        request.setCertType(IDType.transform(bindCard.getCertType()));  //证件类型要转换
        request.setCertId(bindCard.getCertId()); //证件号码
        request.setBankCode(bindCard.getBankCode());//银行代码
        request.setBankProvinceCode(bindCard.getBankProvinceCode());//省份代码
        request.setBankRegionCode(bindCard.getBankRegionCode());  //地区代码
        request.setCardNo(bindCard.getCardNo());//银行卡号
        request.setPhoneNo(bindCard.getPhoneNo()); //客户手机号
        request.setIdentifyingCode(bindCard.getIdentifyingCode());  //手机验证码
        request.setUserId(userId);//用户在证联支付平台里的客户号
        return request;

    }


    /**
     * 构建解绑卡证联请求
     */
    public static CancelBankCardRequest toCancelBankCardRequest(BindCard bindCard, String transferNo,String userId) {

        CancelBankCardRequest request = new CancelBankCardRequest();
        request.setInstuId(ZlrtInstCode.JINHUI.getCode()); //证联支付分配给商户的机构代码
        request.setFundDate(bindCard.getFundDate());   //商户的系统日期(YYYYMMDD)
        request.setFundTime(bindCard.getFundTime().substring(8)); //商户的时间戳(HHMMSS)
        request.setFundSeqId(transferNo); //商户系统流水号
        request.setUserNameText(bindCard.getUserNameText()); //客户的姓名
        request.setCertType(bindCard.getCertType());  //证件类型
        request.setCertId(bindCard.getCertId()); //证件号码
        request.setBankCode(bindCard.getBankCode());//银行代码
        request.setBankProvinceCode(bindCard.getBankProvinceCode());//省份代码
        request.setBankRegionCode(bindCard.getBankRegionCode());  //地区代码
        request.setCardNo(bindCard.getCardNo());//银行卡号
        request.setUserId(userId);//用户在证联支付平台里的客户号
        return request;

    }

}
