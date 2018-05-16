package com.jinhui.zlrt.entity.dto;

import javax.validation.constraints.NotNull;

/**
 * 发送验证码请求参数
 *
 * @autor wsc
 * @create 2018-01-30 9:18
 **/
public class SendCodeRequest {

    //证联支付分配给商户的机构代码
    @NotNull(message = "证联支付分配给商户的机构代码不能为空")
    private String instuId;
    //商户的系统日期(YYYYMMDD)
    @NotNull(message = "商户的系统日期不能为空")
    private String merchantDate;
    //商户的时间戳(HHMMSS)
    @NotNull(message = "商户的时间戳不能为空")
    private String merchantTime;
    //商户系统流水号
    @NotNull(message = "商户系统流水号不能为空")
    private String merchantSeqId;
    //柜台号
    @NotNull(message = "柜台号不能为空")
    private String tradeType;
    //用户在证联平台的客户号
    @NotNull(message = "用户在证联平台的客户号不能为空")
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
    @NotNull(message = "银行代码不能为空")
    private String bankCode;
    //银行卡号
    @NotNull(message = "银行卡号不能为空")
    private String cardNo;
    //客户手机号
    private String mobile;
    //金额
    private String amt;
    //商户保留域，接收方必须原样返回该数据
    private String resv;

    public String getInstuId() {
        return instuId;
    }

    public void setInstuId(String instuId) {
        this.instuId = instuId;
    }

    public String getMerchantDate() {
        return merchantDate;
    }

    public void setMerchantDate(String merchantDate) {
        this.merchantDate = merchantDate;
    }

    public String getMerchantTime() {
        return merchantTime;
    }

    public void setMerchantTime(String merchantTime) {
        this.merchantTime = merchantTime;
    }

    public String getMerchantSeqId() {
        return merchantSeqId;
    }

    public void setMerchantSeqId(String merchantSeqId) {
        this.merchantSeqId = merchantSeqId;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getResv() {
        return resv;
    }

    public void setResv(String resv) {
        this.resv = resv;
    }

    @Override
    public String toString() {
        return "SendCodeRequest{" +
                "instuId='" + instuId + '\'' +
                ", merchantDate='" + merchantDate + '\'' +
                ", merchantTime='" + merchantTime + '\'' +
                ", merchantSeqId='" + merchantSeqId + '\'' +
                ", tradeType='" + tradeType + '\'' +
                ", userId='" + userId + '\'' +
                ", userNameText='" + userNameText + '\'' +
                ", certType='" + certType + '\'' +
                ", certId='" + certId + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", mobile='" + mobile + '\'' +
                ", amt='" + amt + '\'' +
                ", resv='" + resv + '\'' +
                '}';
    }
}
