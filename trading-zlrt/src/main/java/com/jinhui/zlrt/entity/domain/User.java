package com.jinhui.zlrt.entity.domain;

import java.util.Date;

public class User {
    private Integer id;

    private String chnCode;

    private String applyNo;

    private String chnId;

    private String zlUserId;

    private String name;

    private String userFlag;

    private String idType;

    private String idNo;

    private String sex;

    private String phone;

    private String address;

    private String openBank;

    private String bankAccount;

    private String riskLevel;

    private String instReprIdName;

    private String instReprIdType;

    private String instReprIdNo;

    private Date instReprExpdate;

    private String instReprPhone;

    private String bankProvinceCode;

    private String bankRegionCode;

    private Date createTime;

    private String busCode;

    private String transDate;

    private String transTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChnCode() {
        return chnCode;
    }

    public void setChnCode(String chnCode) {
        this.chnCode = chnCode;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getChnId() {
        return chnId;
    }

    public void setChnId(String chnId) {
        this.chnId = chnId;
    }

    public String getZlUserId() {
        return zlUserId;
    }

    public void setZlUserId(String zlUserId) {
        this.zlUserId = zlUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(String userFlag) {
        this.userFlag = userFlag;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getInstReprIdName() {
        return instReprIdName;
    }

    public void setInstReprIdName(String instReprIdName) {
        this.instReprIdName = instReprIdName;
    }

    public String getInstReprIdType() {
        return instReprIdType;
    }

    public void setInstReprIdType(String instReprIdType) {
        this.instReprIdType = instReprIdType;
    }

    public String getInstReprIdNo() {
        return instReprIdNo;
    }

    public void setInstReprIdNo(String instReprIdNo) {
        this.instReprIdNo = instReprIdNo;
    }

    public Date getInstReprExpdate() {
        return instReprExpdate;
    }

    public void setInstReprExpdate(Date instReprExpdate) {
        this.instReprExpdate = instReprExpdate;
    }

    public String getInstReprPhone() {
        return instReprPhone;
    }

    public void setInstReprPhone(String instReprPhone) {
        this.instReprPhone = instReprPhone;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBusCode() {
        return busCode;
    }

    public void setBusCode(String busCode) {
        this.busCode = busCode;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", chnCode='" + chnCode + '\'' +
                ", applyNo='" + applyNo + '\'' +
                ", chnId='" + chnId + '\'' +
                ", zlUserId='" + zlUserId + '\'' +
                ", name='" + name + '\'' +
                ", userFlag='" + userFlag + '\'' +
                ", idType='" + idType + '\'' +
                ", idNo='" + idNo + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", openBank='" + openBank + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", riskLevel='" + riskLevel + '\'' +
                ", instReprIdName='" + instReprIdName + '\'' +
                ", instReprIdType='" + instReprIdType + '\'' +
                ", instReprIdNo='" + instReprIdNo + '\'' +
                ", instReprExpdate=" + instReprExpdate +
                ", instReprPhone='" + instReprPhone + '\'' +
                ", bankProvinceCode='" + bankProvinceCode + '\'' +
                ", bankRegionCode='" + bankRegionCode + '\'' +
                ", createTime=" + createTime +
                ", busCode='" + busCode + '\'' +
                ", transDate='" + transDate + '\'' +
                ", transTime='" + transTime + '\'' +
                '}';
    }
}