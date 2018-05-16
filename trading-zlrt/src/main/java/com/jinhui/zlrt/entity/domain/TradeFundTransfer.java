package com.jinhui.zlrt.entity.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TradeFundTransfer {
    private Integer id;

    private Date applyDate;

    private Date applyTime;

    private String applyNo;

    private String transferNo;

    private String name;

    private String chnId;

    private String chnCode;

    private String productNo;

    private String productName;

    private String bussCode;

    private BigDecimal transVol;

    private BigDecimal transAmount;

    private BigDecimal benefitAmount;

    private BigDecimal payAmount;

    private String payFlag;

    private String payWay;

    private String payStatus;

    private String transBankCode;

    private String transBankAct;

    private BigDecimal transFix;

    private String chargeType;

    private String chargeWay;

    private BigDecimal chargeRate;

    private BigDecimal specifyFee;

    private String zlPnrDate;

    private String zlPnrTime;

    private String zlPnrSeqid;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo == null ? null : applyNo.trim();
    }

    public String getTransferNo() {
        return transferNo;
    }

    public void setTransferNo(String transferNo) {
        this.transferNo = transferNo == null ? null : transferNo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getChnId() {
        return chnId;
    }

    public void setChnId(String chnId) {
        this.chnId = chnId == null ? null : chnId.trim();
    }

    public String getChnCode() {
        return chnCode;
    }

    public void setChnCode(String chnCode) {
        this.chnCode = chnCode == null ? null : chnCode.trim();
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getBussCode() {
        return bussCode;
    }

    public void setBussCode(String bussCode) {
        this.bussCode = bussCode == null ? null : bussCode.trim();
    }

    public BigDecimal getTransVol() {
        return transVol;
    }

    public void setTransVol(BigDecimal transVol) {
        this.transVol = transVol;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public BigDecimal getBenefitAmount() {
        return benefitAmount;
    }

    public void setBenefitAmount(BigDecimal benefitAmount) {
        this.benefitAmount = benefitAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayFlag() {
        return payFlag;
    }

    public void setPayFlag(String payFlag) {
        this.payFlag = payFlag == null ? null : payFlag.trim();
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public String getTransBankCode() {
        return transBankCode;
    }

    public void setTransBankCode(String transBankCode) {
        this.transBankCode = transBankCode == null ? null : transBankCode.trim();
    }

    public String getTransBankAct() {
        return transBankAct;
    }

    public void setTransBankAct(String transBankAct) {
        this.transBankAct = transBankAct == null ? null : transBankAct.trim();
    }

    public BigDecimal getTransFix() {
        return transFix;
    }

    public void setTransFix(BigDecimal transFix) {
        this.transFix = transFix;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public String getChargeWay() {
        return chargeWay;
    }

    public void setChargeWay(String chargeWay) {
        this.chargeWay = chargeWay == null ? null : chargeWay.trim();
    }

    public BigDecimal getChargeRate() {
        return chargeRate;
    }

    public void setChargeRate(BigDecimal chargeRate) {
        this.chargeRate = chargeRate;
    }

    public BigDecimal getSpecifyFee() {
        return specifyFee;
    }

    public void setSpecifyFee(BigDecimal specifyFee) {
        this.specifyFee = specifyFee;
    }

    public String getZlPnrDate() {
        return zlPnrDate;
    }

    public void setZlPnrDate(String zlPnrDate) {
        this.zlPnrDate = zlPnrDate == null ? null : zlPnrDate.trim();
    }

    public String getZlPnrTime() {
        return zlPnrTime;
    }

    public void setZlPnrTime(String zlPnrTime) {
        this.zlPnrTime = zlPnrTime == null ? null : zlPnrTime.trim();
    }

    public String getZlPnrSeqid() {
        return zlPnrSeqid;
    }

    public void setZlPnrSeqid(String zlPnrSeqid) {
        this.zlPnrSeqid = zlPnrSeqid == null ? null : zlPnrSeqid.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}