package com.jinhui.api.entity.dto;

import javax.validation.constraints.NotNull;

/**
 * 产品参数查询接口
 * Created by Administrator on 2018/2/2 0002.
 */
public class QueryProduct {


    /**
     * 接口请求信息
     **/
    //渠道代码
    @NotNull(message = "渠道代码不能为空")
    private String channelCode;


    /**
     * 接口应答信息
     **/

    //产品名称
    private String productName;

    //产品代码
    private String productCode;

    //交易所代码
    private String exchangeCode;

    //产品类型
    private String productType;

    //收益计算类型
    private String calIncomeWay;

    //产品计息方式
    private String calRateWay;

    //产品成立日
    private String setupDate;

    //产品收益率
    private String incomeRate;

    //募集起始时间
    private String ipoStartDate;

    //产品总额度
    private String totalLimit;

    //产品每份金额
    private String productVol;

    //购买起始金额
    private String subsStartAmount;

    //增减份数
    private String subsRange;

    //是否需要风险测评
    private String riskAssess;

    //风险级别
    private String riskLevel;

    //客户当日申购金额上限
    private String clientSubsToplimit;

    //客户当日赎回金额上限
    private String clientRedeemToplimit;

    //客户持仓限额
    private String clientPositionLimit;

    //产品当日申购金额上限
    private String productSubsToplimit;

    //产品当日赎回金额上限
    private String productRedeemToplimit;

    //产品万份收益
    private String percentIncomeRate;

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCalIncomeWay() {
        return calIncomeWay;
    }

    public void setCalIncomeWay(String calIncomeWay) {
        this.calIncomeWay = calIncomeWay;
    }

    public String getCalRateWay() {
        return calRateWay;
    }

    public void setCalRateWay(String calRateWay) {
        this.calRateWay = calRateWay;
    }

    public String getSetupDate() {
        return setupDate;
    }

    public void setSetupDate(String setupDate) {
        this.setupDate = setupDate;
    }

    public String getIncomeRate() {
        return incomeRate;
    }

    public void setIncomeRate(String incomeRate) {
        this.incomeRate = incomeRate;
    }

    public String getIpoStartDate() {
        return ipoStartDate;
    }

    public void setIpoStartDate(String ipoStartDate) {
        this.ipoStartDate = ipoStartDate;
    }

    public String getTotalLimit() {
        return totalLimit;
    }

    public void setTotalLimit(String totalLimit) {
        this.totalLimit = totalLimit;
    }

    public String getProductVol() {
        return productVol;
    }

    public void setProductVol(String productVol) {
        this.productVol = productVol;
    }

    public String getSubsStartAmount() {
        return subsStartAmount;
    }

    public void setSubsStartAmount(String subsStartAmount) {
        this.subsStartAmount = subsStartAmount;
    }

    public String getSubsRange() {
        return subsRange;
    }

    public void setSubsRange(String subsRange) {
        this.subsRange = subsRange;
    }

    public String getRiskAssess() {
        return riskAssess;
    }

    public void setRiskAssess(String riskAssess) {
        this.riskAssess = riskAssess;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getClientSubsToplimit() {
        return clientSubsToplimit;
    }

    public void setClientSubsToplimit(String clientSubsToplimit) {
        this.clientSubsToplimit = clientSubsToplimit;
    }

    public String getClientRedeemToplimit() {
        return clientRedeemToplimit;
    }

    public void setClientRedeemToplimit(String clientRedeemToplimit) {
        this.clientRedeemToplimit = clientRedeemToplimit;
    }

    public String getClientPositionLimit() {
        return clientPositionLimit;
    }

    public void setClientPositionLimit(String clientPositionLimit) {
        this.clientPositionLimit = clientPositionLimit;
    }

    public String getProductSubsToplimit() {
        return productSubsToplimit;
    }

    public void setProductSubsToplimit(String productSubsToplimit) {
        this.productSubsToplimit = productSubsToplimit;
    }

    public String getProductRedeemToplimit() {
        return productRedeemToplimit;
    }

    public void setProductRedeemToplimit(String productRedeemToplimit) {
        this.productRedeemToplimit = productRedeemToplimit;
    }

    public String getPercentIncomeRate() {
        return percentIncomeRate;
    }

    public void setPercentIncomeRate(String percentIncomeRate) {
        this.percentIncomeRate = percentIncomeRate;
    }
}
