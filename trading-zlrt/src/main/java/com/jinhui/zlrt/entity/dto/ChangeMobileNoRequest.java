package com.jinhui.zlrt.entity.dto;

import javax.validation.constraints.NotNull;

/**
 * 客户手机号变更请求参数
 *
 * @autor wsc
 * @create 2018-01-30 10:13
 **/
public class ChangeMobileNoRequest {
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
    //原始手机号
    private String prePhone;
    //变更之后的客户手机号
    @NotNull(message = "变更之后的客户手机号不能为空")
    private String newPhone;
    //商户保留域
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

    public String getPrePhone() {
        return prePhone;
    }

    public void setPrePhone(String prePhone) {
        this.prePhone = prePhone;
    }

    public String getNewPhone() {
        return newPhone;
    }

    public void setNewPhone(String newPhone) {
        this.newPhone = newPhone;
    }

    public String getResv() {
        return resv;
    }

    public void setResv(String resv) {
        this.resv = resv;
    }
}
