package com.jinhui.api.entity.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 开户接口 交互类
 * Created by Administrator on 2018/1/24 0024.
 */
public class OpenAccount {


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

//    //柜台号
//    @NotNull(message = "柜台号不能为空")
//    private String counterNo;

    //投资人姓名
    @NotNull(message = "投资人姓名不能为空")
    private String userNameText;

    //渠道用户ID
    @NotNull(message = "渠道用户ID不能为空")
    private String channelUserId;

    //客户类别
    @NotNull(message = "客户类别不能为空")
    private String userType;

    //证件类型
    @NotNull(message = "证件类型不能为空")
    private String certType;

    //证件号码
    @NotNull(message = "证件号码不能为空")
    private String certId;

    //手机号
    @NotNull(message = "手机号不能为空")
    private String phoneNo;

    //短信验证码
    @NotNull(message = "短信验证码不能为空")
    private String identifyingCode;

    //开户行
    @NotNull(message = "开户行不能为空")
    private String bankCode;

    //银行账号
    @NotNull(message = "银行账号不能为空")
    private String cardNo;

    //银行所属省市代码
    private String bankProvinceCode;

    //银行所属地区代码
    private String bankRegionCode;

    //性别
    @Size(min =1  ,max=1, message = "性别格式不正确")
    private String sex;

    //联系地址
    private String address;

    //客户风险级别
    @Size(min =1  ,max=1, message = "客户风险级别格式不正确")
    private String clientRiskRate;

    //法人代表姓名
    private String instReprName;

    //法人代表证件类型
    @Size(min =1  ,max=1, message = "法人代表证件类型格式不正确")
    private String instReprIDType;

    //法人代表证件号码
    private String instReprIDCode;

    //法人代表证件有效期,如果不为空,格式要正确
    @Size(min =8  ,max=8, message = "法人代表证件有效期格式不正确")
    private String instReprCertValidDate;

    //法人联系电话
    private String instReprphoneNo;

    //业务代码
    @NotNull(message = "业务代码不能为空")
    private String businessCode;

    //渠道代码
    @NotNull(message = "渠道代码不能为空")
    private String channelCode;

    /**
     * 接口应答信息
     **/

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

    //开户状态
    private String tiedTypeFlag;

    public OpenAccount() {
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

//    public String getCounterNo() {
//        return counterNo;
//    }
//
//    public void setCounterNo(String counterNo) {
//        this.counterNo = counterNo;
//    }

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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    public String getBankProvinceCode() {
        return bankProvinceCode;
    }

    public void setBankProvinceCode(String bankProvinceCode) {
        this.bankProvinceCode = bankProvinceCode;
    }

    public String getBankRegionCode() {
        return bankRegionCode;
    }

    public void setBankRegionCode(String bankRegionCode) {
        this.bankRegionCode = bankRegionCode;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClientRiskRate() {
        return clientRiskRate;
    }

    public void setClientRiskRate(String clientRiskRate) {
        this.clientRiskRate = clientRiskRate;
    }

    public String getInstReprName() {
        return instReprName;
    }

    public void setInstReprName(String instReprName) {
        this.instReprName = instReprName;
    }

    public String getInstReprIDType() {
        return instReprIDType;
    }

    public void setInstReprIDType(String instReprIDType) {
        this.instReprIDType = instReprIDType;
    }

    public String getInstReprIDCode() {
        return instReprIDCode;
    }

    public void setInstReprIDCode(String instReprIDCode) {
        this.instReprIDCode = instReprIDCode;
    }

    public String getInstReprCertValidDate() {
        return instReprCertValidDate;
    }

    public void setInstReprCertValidDate(String instReprCertValidDate) {
        this.instReprCertValidDate = instReprCertValidDate;
    }

    public String getInstReprphoneNo() {
        return instReprphoneNo;
    }

    public void setInstReprphoneNo(String instReprphoneNo) {
        this.instReprphoneNo = instReprphoneNo;
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

    public String getTiedTypeFlag() {
        return tiedTypeFlag;
    }

    public void setTiedTypeFlag(String tiedTypeFlag) {
        this.tiedTypeFlag = tiedTypeFlag;
    }

    @Override
    public String toString() {
        return "OpenAccount{" +
                "fundDate='" + fundDate + '\'' +
                ", fundTime='" + fundTime + '\'' +
                ", fundSeqId='" + fundSeqId + '\'' +
                ", userNameText='" + userNameText + '\'' +
                ", channelUserId='" + channelUserId + '\'' +
                ", userType='" + userType + '\'' +
                ", certType='" + certType + '\'' +
                ", certId='" + certId + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", identifyingCode='" + identifyingCode + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", bankProvinceCode='" + bankProvinceCode + '\'' +
                ", bankRegionCode='" + bankRegionCode + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", clientRiskRate='" + clientRiskRate + '\'' +
                ", instReprName='" + instReprName + '\'' +
                ", instReprIDType='" + instReprIDType + '\'' +
                ", instReprIDCode='" + instReprIDCode + '\'' +
                ", instReprCertValidDate='" + instReprCertValidDate + '\'' +
                ", instReprphoneNo='" + instReprphoneNo + '\'' +
                ", businessCode='" + businessCode + '\'' +
                ", channelCode='" + channelCode + '\'' +
                ", respCode='" + respCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", tiedTypeFlag='" + tiedTypeFlag + '\'' +
                '}';
    }
}
