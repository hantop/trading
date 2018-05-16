package com.jinhui.zlrt.entity.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 后台申购请求参数
 *
 * @autor wsc
 * @create 2018-01-30 10:23
 **/
public class PurchaseRequest {
    //证联支付分配给商户的机构代码
    @NotNull(message = "证联支付分配给商户的机构代码不能为空")
    private String instuId;
    //商户的系统日期(YYYYMMDD)
    @NotNull(message = "商户的系统日期不能为空")
    private String fundDate;
    //商户的时间戳(HHMMSS)
    @NotNull(message = "商户的时间戳不能为空")
    private String fundTime;
    //商户系统流水号
    @NotNull(message = "商户系统流水号不能为空")
    private String fundSeqId;
    //用户在证联支付平台里的客户号
    @NotNull(message = "用户在证联支付平台里的客户号不能为空")
    private String userId;
    //客户的姓名
    @NotNull(message = "客户的姓名不能为空")
    private String userNameText;
    //证件类型
    @NotNull(message = "证件类型不能为空")
    private String certType;
    //证件号码
    @NotNull(message = "证件号码不能为空")
    private String certId;
    //银行代码
    private String bankCode;
    //银行卡号
    private String cardNo;
    //申购方式
    @NotNull(message = "申购方式不能为空")
    private String flag;
    //基金交易金额
    @NotNull(message = "基金交易金额不能为空")
    private String transAmt;
    //交易结算日期
    @NotNull(message = "交易结算日期不能为空")
    private String liqDate;
    //基金代码
    @NotNull(message = "基金代码不能为空")
    private String fundCode;
    //基金类型
    @NotNull(message = "基金类型不能为空")
    private String fundType;
    //业务类型
    @NotNull(message = "业务类型不能为空")
    private String busiType;
    //客户手机号
    private String phoneNo;
    //手机短信验证码
    private String identifyCode;
    //保留域
    private String resv;

    public String getInstuId() {
        return instuId;
    }

    public void setInstuId(String instuId) {
        this.instuId = instuId;
    }

    public String getFundDate() {
        return fundDate;
    }

    public void setFundDate(String fundDate) {
        this.fundDate = fundDate;
    }

    public String getFundTime() {
        return fundTime;
    }

    public void setFundTime(String fundTime) {
        this.fundTime = fundTime;
    }

    public String getFundSeqId() {
        return fundSeqId;
    }

    public void setFundSeqId(String fundSeqId) {
        this.fundSeqId = fundSeqId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNameText() {
        return userNameText;
    }

    public void setUserNameText(String userNameText) {
        this.userNameText = userNameText;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(String transAmt) {
        this.transAmt = transAmt;
    }

    public String getLiqDate() {
        return liqDate;
    }

    public void setLiqDate(String liqDate) {
        this.liqDate = liqDate;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getIdentifyCode() {
        return identifyCode;
    }

    public void setIdentifyCode(String identifyCode) {
        this.identifyCode = identifyCode;
    }

    public String getResv() {
        return resv;
    }

    public void setResv(String resv) {
        this.resv = resv;
    }
}
