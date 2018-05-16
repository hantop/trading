package com.jinhui.zlrt.entity.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TradeConsign {
    private Integer id;

    private Date applyDate;

    private Date applyTime;

    private String applyNo;

    private Date confirmDate;

    private String name;

    private String chnId;

    private String chnCode;

    private String productNo;

    private String productName;

    private String bussCode;

    private String consignStatus;

    private BigDecimal transVol;

    private BigDecimal transAmount;

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

    private String investorId;

    private String branchCode;

    private String transDate;

    private String transTime;

    private String transferNo;

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

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
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

    public String getConsignStatus() {
        return consignStatus;
    }

    public void setConsignStatus(String consignStatus) {
        this.consignStatus = consignStatus == null ? null : consignStatus.trim();
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

    public String getInvestorId() {
        return investorId;
    }

    public void setInvestorId(String investorId) {
        this.investorId = investorId;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
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

    public String getTransferNo() {
        return transferNo;
    }

    public void setTransferNo(String transferNo) {
        this.transferNo = transferNo;
    }

    @Override
    public String toString() {
        return "TradeConsign{" +
                "id=" + id +
                ", applyDate=" + applyDate +
                ", applyTime=" + applyTime +
                ", applyNo='" + applyNo + '\'' +
                ", confirmDate=" + confirmDate +
                ", name='" + name + '\'' +
                ", chnId='" + chnId + '\'' +
                ", chnCode='" + chnCode + '\'' +
                ", productNo='" + productNo + '\'' +
                ", productName='" + productName + '\'' +
                ", bussCode='" + bussCode + '\'' +
                ", consignStatus='" + consignStatus + '\'' +
                ", transVol=" + transVol +
                ", transAmount=" + transAmount +
                ", transFix=" + transFix +
                ", takeIncomeFlag='" + takeIncomeFlag + '\'' +
                ", hugeSubsFlag='" + hugeSubsFlag + '\'' +
                ", hugeRedemFlag='" + hugeRedemFlag + '\'' +
                ", riskDisclosure='" + riskDisclosure + '\'' +
                ", transBankCode='" + transBankCode + '\'' +
                ", transBankAct='" + transBankAct + '\'' +
                ", chargeType='" + chargeType + '\'' +
                ", chargeWay='" + chargeWay + '\'' +
                ", chargeRate=" + chargeRate +
                ", specifyFee=" + specifyFee +
                ", rollingFlag='" + rollingFlag + '\'' +
                ", forceRedemReason='" + forceRedemReason + '\'' +
                ", forceRedemType='" + forceRedemType + '\'' +
                ", redeemFlag='" + redeemFlag + '\'' +
                ", createTime=" + createTime +
                ", investorId='" + investorId + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", transDate='" + transDate + '\'' +
                ", transTime='" + transTime + '\'' +
                ", transferNo='" + transferNo + '\'' +
                '}';
    }
}