package com.jinhui.api.entity.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** 申购接口 交互类
 * Created by Administrator on 2018/1/30 0030.
 */
public class Purchasing {

    /**
     * 接口请求信息
     **/

    //申请日期yyyyMMdd
    @NotNull(message = "申请日期不能为空")
    @Size(min =8 ,max=8, message = "申请日期格式不正确")
    private String fundDate;

    //申请时间yyyyMMddHHmmss
    @NotNull(message = "申请时间不能为空")
    @Size(min =14  ,max=14, message = "申请时间格式不正确")
    private String fundTime;

    //申请单号
    @NotNull(message = "申请单号不能为空")
    private String fundSeqId;

    //投资人姓名
    @NotNull(message = "投资人姓名不能为空")
    private String userNameText;

    //渠道用户ID
    @NotNull(message = "渠道用户ID不能为空")
    private String channelUserId;

    //证件类型
    @NotNull(message = "证件类型不能为空")
    private String certType;

    //证件号码
    @NotNull(message = "证件号码不能为空")
    private String certId;

    //手机号
//    @NotNull(message = "手机号不能为空")
    private String phoneNo;

    //短信验证码
//    @NotNull(message = "短信验证码不能为空")
    private String identifyingCode;

    //银行代码
    @NotNull(message = "银行代码不能为空")
    private String bankCode;

    //银行账号
    @NotNull(message = "银行账号不能为空")
    private String cardNo;

    //交易份额
    @NotNull(message = "交易金额不能为空")
    private String amount;

    //申购方式
    @NotNull(message = "申购方式不能为空")
    private String purchaseType;

    //产品名称
    @NotNull(message = "产品名称不能为空")
    private String productName;

    //产品代码
    @NotNull(message = "产品代码不能为空")
    private String productCode;

    //业务代码
    @NotNull(message = "业务代码不能为空")
    private String businessCode;

    //渠道代码
    @NotNull(message = "渠道代码不能为空")
    private String channelCode;

    /**
     * 接口应答信息
     **/

    //交易状态
    private String transState;

    //交易返回码
    private String respCode;

    //错误描述
    private String errorMsg;

//    //用户证联ID
//    private String pnrUserId;
//
//    //证联处理日期
//    private String pnrDate;
//
//    //证联处理时间
//    private String pnrTime;
//
//    //证联流水号
//    private String pnrSeqId;


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

    public String getUserNameText() {
        return userNameText;
    }

    public void setUserNameText(String userNameText) {
        this.userNameText = userNameText;
    }

    public String getChannelUserId() {
        return channelUserId;
    }

    public void setChannelUserId(String channelUserId) {
        this.channelUserId = channelUserId;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getIdentifyingCode() {
        return identifyingCode;
    }

    public void setIdentifyingCode(String identifyingCode) {
        this.identifyingCode = identifyingCode;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getTransState() {
        return transState;
    }

    public void setTransState(String transState) {
        this.transState = transState;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

//    public String getPnrUserId() {
//        return pnrUserId;
//    }
//
//    public void setPnrUserId(String pnrUserId) {
//        this.pnrUserId = pnrUserId;
//    }
//
//    public String getPnrDate() {
//        return pnrDate;
//    }
//
//    public void setPnrDate(String pnrDate) {
//        this.pnrDate = pnrDate;
//    }
//
//    public String getPnrTime() {
//        return pnrTime;
//    }
//
//    public void setPnrTime(String pnrTime) {
//        this.pnrTime = pnrTime;
//    }
//
//    public String getPnrSeqId() {
//        return pnrSeqId;
//    }
//
//    public void setPnrSeqId(String pnrSeqId) {
//        this.pnrSeqId = pnrSeqId;
//    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
