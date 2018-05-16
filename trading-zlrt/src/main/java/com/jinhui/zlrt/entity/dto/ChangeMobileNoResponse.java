package com.jinhui.zlrt.entity.dto;

/**
 * 客户手机号变更响应结果
 *
 * @autor wsc
 * @create 2018-01-30 10:14
 **/
public class ChangeMobileNoResponse {
    //证联支付分配给商户的机构代码
    public String instuId;
    //商户系统流水号
    public String fundSeqId;
    //用户在证联支付平台里的客户号
    public String userId;
    //客户的姓名
    public String userNameText;
    //证件类型
    public String certType;
    //证件号码
    public String certId;
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
        return "ChangeMobileNoResponse{" +
                "instuId='" + instuId + '\'' +
                ", fundSeqId='" + fundSeqId + '\'' +
                ", userId='" + userId + '\'' +
                ", userNameText='" + userNameText + '\'' +
                ", certType='" + certType + '\'' +
                ", certId='" + certId + '\'' +
                ", respCode='" + respCode + '\'' +
                ", respDesc='" + respDesc + '\'' +
                ", resv='" + resv + '\'' +
                '}';
    }
}
