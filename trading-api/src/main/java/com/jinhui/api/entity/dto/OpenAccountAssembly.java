package com.jinhui.api.entity.dto;

import com.jinhui.api.constants.*;
import com.jinhui.api.entity.po.BindCardInfo;
import com.jinhui.api.entity.po.BussSerialRecord;
import com.jinhui.api.entity.po.User;
import com.jinhui.api.utils.DateUtils;
import com.jinhui.zlrt.entity.dto.OpenAccountRequest;
import org.apache.commons.lang.StringUtils;

import java.util.Date;


/**
 * 开户接口交互类 的组装类
 * Created by Administrator on 2018/1/24 0024.
 */
public class OpenAccountAssembly {


    /**
     * 得到业务流水记录
     */
    public static BussSerialRecord toBussSerialRecord(OpenAccount openAccount) {

        BussSerialRecord record = new BussSerialRecord();
        record.setName(openAccount.getUserNameText());//投资人姓名
        record.setApplyDate(DateUtils.toDate(openAccount.getFundDate()));//申请日期
        record.setApplyTime(DateUtils.toTime(openAccount.getFundTime()));//申请时间
        record.setApplyNo(openAccount.getFundSeqId());//申请单号
        record.setBussFlag(BusinessCode.FIRST_OPEN);//业务标识
        record.setChnCode(openAccount.getChannelCode());//渠道方代码
        record.setBussStatus(BussStatus.CONFIRM);//业务状态
        record.setChnId(openAccount.getChannelUserId());//渠道用户ID
        record.setCreateTime(new Date());
        return record;
    }

    /**
     * 得到用户类
     */
    public static User toUser(OpenAccount openAccount) {

        User user = new User();
        user.setApplyNo(openAccount.getFundSeqId());//申请单号
        user.setApplyDate(DateUtils.toDate(openAccount.getFundDate()));//申请日期
        user.setApplyTime(DateUtils.toTime(openAccount.getFundTime()));//申请时间
        user.setChnCode(openAccount.getChannelCode());//渠道方代码
        user.setChnId(openAccount.getChannelUserId());//渠道用户ID
        user.setName(openAccount.getUserNameText());//投资人姓名
        user.setUserFlag(openAccount.getUserType());//客户类别
        user.setIdType(openAccount.getCertType());//证件类型
        user.setIdNo(openAccount.getCertId());//证件号码
        user.setSex(openAccount.getSex());//性别
        user.setPhone(openAccount.getPhoneNo());//联系电话
        user.setAddress(openAccount.getAddress());//联系地址
        user.setOpenBank(openAccount.getBankCode());//开户行
        user.setBankAccount(openAccount.getCardNo());//银行账号
        user.setRiskLevel(openAccount.getClientRiskRate());//客户风险级别
        user.setInstReprIdName(openAccount.getInstReprName());//法人代表姓名
        user.setInstReprIdType(openAccount.getInstReprIDType());//法人代表证件类型
        user.setInstReprIdNo(openAccount.getInstReprIDCode());//法人代表证件号码
        if (StringUtils.isNotBlank(openAccount.getInstReprCertValidDate())) {
            user.setInstReprExpdate(DateUtils.toDate(openAccount.getInstReprCertValidDate()));//法人代表证件有效期
        }
        user.setInstReprPhone(openAccount.getInstReprphoneNo());//法人代表联系电话
        user.setBankProvinceCode(openAccount.getBankProvinceCode());//银行省份
        user.setBankRegionCode(openAccount.getBankRegionCode());//银行所属地区
        user.setCreateTime(new Date());
        return user;
    }

    /**
     * 构建绑卡信息类
     */
    public static BindCardInfo toBindCardInfo(OpenAccount openAccount) {

        BindCardInfo cinfo = new BindCardInfo();
        cinfo.setName(openAccount.getUserNameText());//投资人姓名
        cinfo.setChnId(openAccount.getChannelUserId());//渠道用户ID
        cinfo.setChnCode(openAccount.getChannelCode());//渠道方代码
        cinfo.setOpenBank(openAccount.getBankCode());//开户行
        cinfo.setBankAccount(openAccount.getCardNo());//银行账号
        cinfo.setProvince(openAccount.getBankProvinceCode());//银行所属省份
        cinfo.setCity(openAccount.getBankRegionCode());//银行所属地区
        cinfo.setMobileNo(openAccount.getPhoneNo());//手机号
        cinfo.setStatus("0");//卡状态: 0-正常
        cinfo.setCounterNo(ChannelCode.getCounterNoByCode(openAccount.getChannelCode()));//柜台号
        cinfo.setCreateTime(new Date());
        return cinfo;
    }

    /**
     * 构建证联请求
     */
    public static OpenAccountRequest toOpenAccountRequest(OpenAccount openAccount, String transferNo) {
        OpenAccountRequest request = new OpenAccountRequest();

        request.setInstuId(ZlrtInstCode.JINHUI.getCode()); //证联支付分配给商户的机构代码
        request.setFundDate(openAccount.getFundDate());   //商户的系统日期(YYYYMMDD)
        request.setFundTime(openAccount.getFundTime().substring(8)); //商户的时间戳(HHMMSS)
        request.setFundSeqId(transferNo); //商户系统流水号

        ChannelCode channelCodeByCode = ChannelCode.getChannelCodeByCode(openAccount.getChannelCode());
        request.setCounterNo(channelCodeByCode.getCounterNo()); //柜台号

        request.setCustType(openAccount.getUserType());//客户类型：0：个人 1：企业
        request.setUserNameText(openAccount.getUserNameText()); //客户的姓名
        request.setCertType(IDType.transform(openAccount.getCertType()));  //证件类型
        request.setCertId(openAccount.getCertId()); //证件号码
        request.setBankCode(openAccount.getBankCode());//银行代码
        request.setBankProvinceCode(openAccount.getBankProvinceCode());//省份代码
        request.setBankRegionCode(openAccount.getBankRegionCode());  //地区代码
        request.setCardNo(openAccount.getCardNo());//银行卡号
//        request.setPayPassWord();   //支付密码
        request.setMobile(openAccount.getPhoneNo()); //客户手机号
        request.setIdentifyingCode(openAccount.getIdentifyingCode());  //手机验证码
        return request;
    }


}
