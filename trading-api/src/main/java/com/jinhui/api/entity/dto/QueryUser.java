package com.jinhui.api.entity.dto;

import javax.validation.constraints.NotNull;

/**
 * 用户查询接口
 * Created by Administrator on 2018/2/2 0002.
 */
public class QueryUser {



    /**
     * 接口请求信息
     **/

    //投资人姓名
    @NotNull(message = "投资人姓名不能为空")
    private String userNameText;

    //渠道用户ID
    @NotNull(message = "渠道用户ID不能为空")
    private String channelUserId;

    //渠道代码
    @NotNull(message = "渠道代码不能为空")
    private String channelCode;


    /**
     * 接口返回信息
     */

    //客户类别
    private String userType;

    //证件类型
    private String certType;

    //证件号码
    private String certId;

    //手机号
    private String phoneNo;

    //性别
    private String sex;

    //联系地址
    private String address;

    //客户风险级别
    private String clientRiskRate;

    //法人代表姓名
    private String instReprName;

    //法人代表证件类型
    private String instReprIDType;

    //法人代表证件号码
    private String instReprIDCode;

    //法人代表证件有效期
    private String instReprCertValidDate;

    //法人联系电话
    private String instReprphoneNo;

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

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
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
}
