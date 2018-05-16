package com.jinhui.zlrt.entity.domain;

import java.math.BigDecimal;
import java.util.Date;

public class InvestorTrans {
    private Integer id;

    private String serialNumber;

    private String zlFundSeqid;

    private Integer batchCode;

    private String investorId;

    private String chnId;

    private String chnCode;

    private String name;

    private Date transTime;

    private Date confirmDate;

    private String transState;

    private String isExcess;

    private String appSheetSerialNo;

    private String productNo;

    private String childProductNo;

    private String productName;

    private String transType;

    private BigDecimal transVol;

    private BigDecimal transAmount;

    private BigDecimal productVol;

    private BigDecimal transFix;

    private String takeIncomeFlag;

    private String hugeSubsFlag;

    private String hugeRedemFlag;

    private String riskDisclosure;

    private String transBankCode;

    private String transBankAct;

    private String chargeType;

    private String chargeWay;

    private BigDecimal chargeRate;

    private BigDecimal specifyFee;

    private String rollingFlag;

    private String forceRedemReason;

    private String forceRedemType;

    private String redeemFlag;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getZlFundSeqid() {
        return zlFundSeqid;
    }

    public void setZlFundSeqid(String zlFundSeqid) {
        this.zlFundSeqid = zlFundSeqid == null ? null : zlFundSeqid.trim();
    }

    public Integer getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(Integer batchCode) {
        this.batchCode = batchCode;
    }

    public String getInvestorId() {
        return investorId;
    }

    public void setInvestorId(String investorId) {
        this.investorId = investorId == null ? null : investorId.trim();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public String getTransState() {
        return transState;
    }

    public void setTransState(String transState) {
        this.transState = transState == null ? null : transState.trim();
    }

    public String getIsExcess() {
        return isExcess;
    }

    public void setIsExcess(String isExcess) {
        this.isExcess = isExcess == null ? null : isExcess.trim();
    }

    public String getAppSheetSerialNo() {
        return appSheetSerialNo;
    }

    public void setAppSheetSerialNo(String appSheetSerialNo) {
        this.appSheetSerialNo = appSheetSerialNo == null ? null : appSheetSerialNo.trim();
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public String getChildProductNo() {
        return childProductNo;
    }

    public void setChildProductNo(String childProductNo) {
        this.childProductNo = childProductNo == null ? null : childProductNo.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType == null ? null : transType.trim();
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

    public BigDecimal getProductVol() {
        return productVol;
    }

    public void setProductVol(BigDecimal productVol) {
        this.productVol = productVol;
    }

    public BigDecimal getTransFix() {
        return transFix;
    }

    public void setTransFix(BigDecimal transFix) {
        this.transFix = transFix;
    }

    public String getTakeIncomeFlag() {
        return takeIncomeFlag;
    }

    public void setTakeIncomeFlag(String takeIncomeFlag) {
        this.takeIncomeFlag = takeIncomeFlag == null ? null : takeIncomeFlag.trim();
    }

    public String getHugeSubsFlag() {
        return hugeSubsFlag;
    }

    public void setHugeSubsFlag(String hugeSubsFlag) {
        this.hugeSubsFlag = hugeSubsFlag == null ? null : hugeSubsFlag.trim();
    }

    public String getHugeRedemFlag() {
        return hugeRedemFlag;
    }

    public void setHugeRedemFlag(String hugeRedemFlag) {
        this.hugeRedemFlag = hugeRedemFlag == null ? null : hugeRedemFlag.trim();
    }

    public String getRiskDisclosure() {
        return riskDisclosure;
    }

    public void setRiskDisclosure(String riskDisclosure) {
        this.riskDisclosure = riskDisclosure == null ? null : riskDisclosure.trim();
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

    public String getRollingFlag() {
        return rollingFlag;
    }

    public void setRollingFlag(String rollingFlag) {
        this.rollingFlag = rollingFlag == null ? null : rollingFlag.trim();
    }

    public String getForceRedemReason() {
        return forceRedemReason;
    }

    public void setForceRedemReason(String forceRedemReason) {
        this.forceRedemReason = forceRedemReason == null ? null : forceRedemReason.trim();
    }

    public String getForceRedemType() {
        return forceRedemType;
    }

    public void setForceRedemType(String forceRedemType) {
        this.forceRedemType = forceRedemType == null ? null : forceRedemType.trim();
    }

    public String getRedeemFlag() {
        return redeemFlag;
    }

    public void setRedeemFlag(String redeemFlag) {
        this.redeemFlag = redeemFlag == null ? null : redeemFlag.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}