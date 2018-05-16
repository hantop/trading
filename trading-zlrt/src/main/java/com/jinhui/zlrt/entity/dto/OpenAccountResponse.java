package com.jinhui.zlrt.entity.dto;

/**
 * 开户响应参数
 *
 * @autor wsc
 * @create 2018-01-30 9:19
 **/
public class OpenAccountResponse {

    //证联支付分配给商户的机构代码
    public String instuId;
    //商户的系统日期(YYYYMMDD)
    public String fundDate;
    //商户的时间戳(HHMMSS)
    public String fundTime;
    //商户系统流水号
    public String fundSeqId;
    //柜台号
    public String counterNo;
    //用户在证联支付平台里的客户号
    public String userId;
    //客户的姓名
    public String userNameText;
    //证件类型
    public String certType;
    //证件号码
    public String certId;
    //银行代码
    public String bankCode;
    //省份代码
    public String bankProvinceCode;
    //地区代码
    public String bankRegionCode;
    //银行卡号
    public String cardNo;
    //证联支付发起交易的系统日期
    public String pnrDate;
    //证联支付发给基金的时间戳
    public String pnrTime;
    //证联支付的流水号
    public String pnrSeqId;
    //应答码
    public String respCode;
    //业务应答描述
    public String respDesc;
    //商户保留域
    public String resv;

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

    public String getCounterNo() {
        return counterNo;
    }

    public void setCounterNo(String counterNo) {
        this.counterNo = counterNo;
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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getPnrDate() {
        return pnrDate;
    }

    public void setPnrDate(String pnrDate) {
        this.pnrDate = pnrDate;
    }

    public String getPnrTime() {
        return pnrTime;
    }

    public void setPnrTime(String pnrTime) {
        this.pnrTime = pnrTime;
    }

    public String getPnrSeqId() {
        return pnrSeqId;
    }

    public void setPnrSeqId(String pnrSeqId) {
        this.pnrSeqId = pnrSeqId;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public String getResv() {
        return resv;
    }

    public void setResv(String resv) {
        this.resv = resv;
    }

    @Override
    public String toString() {
        return "OpenAccountResponse{" +
                "instuId='" + instuId + '\'' +
                ", fundDate='" + fundDate + '\'' +
                ", fundTime='" + fundTime + '\'' +
                ", fundSeqId='" + fundSeqId + '\'' +
                ", counterNo='" + counterNo + '\'' +
                ", userId='" + userId + '\'' +
                ", userNameText='" + userNameText + '\'' +
                ", certType='" + certType + '\'' +
                ", certId='" + certId + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", bankProvinceCode='" + bankProvinceCode + '\'' +
                ", bankRegionCode='" + bankRegionCode + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", pnrDate='" + pnrDate + '\'' +
                ", pnrTime='" + pnrTime + '\'' +
                ", pnrSeqId='" + pnrSeqId + '\'' +
                ", respCode='" + respCode + '\'' +
                ", respDesc='" + respDesc + '\'' +
                ", resv='" + resv + '\'' +
                '}';
    }
}
