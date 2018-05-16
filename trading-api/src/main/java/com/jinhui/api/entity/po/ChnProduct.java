package com.jinhui.api.entity.po;

import java.math.BigDecimal;
import java.util.Date;

public class ChnProduct {
    /**
     * 表主键
     */
    private Integer id;

    /**
     * 渠道代码，渠道在平台中的代码标识
     */
    private String chnCode;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 金飞镖产品代码
     */
    private String productNo;

    /**
     * 收益率
     */
    private BigDecimal incomeRate;

    /**
     * 万元收益
     */
    private BigDecimal percentIncomeRate;

    /**
     * 客户当日申购金额上限
     */
    private BigDecimal clientSubsToplimit;

    /**
     * 客户当日赎回金额上限
     */
    private BigDecimal clientRedeemToplimit;

    /**
     * 客户持仓限额
     */
    private BigDecimal clientPositionLimit;

    /**
     * 产品当日申购金额上限
     */
    private BigDecimal productSubsToplimit;

    /**
     * 产品当日赎回金额上限
     */
    private BigDecimal productRedeemToplimit;

    /**
     * 产品总额度
     */
    private BigDecimal totalLimit;

    /**
     * 产品剩余购买额度，ps:可理解为库存
     */
    private BigDecimal purchaseLimit;

    /**
     * 上架时间
     */
    private Date saleTime;

    /**
     * 录入日期
     */
    private Date createDate;

    /**
     * 获取表主键
     *
     * @return id - 表主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置表主键
     *
     * @param id 表主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取渠道代码，渠道在平台中的代码标识
     *
     * @return chn_code - 渠道代码，渠道在平台中的代码标识
     */
    public String getChnCode() {
        return chnCode;
    }

    /**
     * 设置渠道代码，渠道在平台中的代码标识
     *
     * @param chnCode 渠道代码，渠道在平台中的代码标识
     */
    public void setChnCode(String chnCode) {
        this.chnCode = chnCode == null ? null : chnCode.trim();
    }

    /**
     * 获取产品名称
     *
     * @return product_name - 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 获取金飞镖产品代码
     *
     * @return product_no - 金飞镖产品代码
     */
    public String getProductNo() {
        return productNo;
    }

    /**
     * 设置金飞镖产品代码
     *
     * @param productNo 金飞镖产品代码
     */
    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    /**
     * 获取收益率
     *
     * @return income_rate - 收益率
     */
    public BigDecimal getIncomeRate() {
        return incomeRate;
    }

    /**
     * 设置收益率
     *
     * @param incomeRate 收益率
     */
    public void setIncomeRate(BigDecimal incomeRate) {
        this.incomeRate = incomeRate;
    }

    /**
     * 获取万元收益
     *
     * @return percent_income_rate - 万元收益
     */
    public BigDecimal getPercentIncomeRate() {
        return percentIncomeRate;
    }

    /**
     * 设置万元收益
     *
     * @param percentIncomeRate 万元收益
     */
    public void setPercentIncomeRate(BigDecimal percentIncomeRate) {
        this.percentIncomeRate = percentIncomeRate;
    }

    /**
     * 获取客户当日申购金额上限
     *
     * @return client_subs_toplimit - 客户当日申购金额上限
     */
    public BigDecimal getClientSubsToplimit() {
        return clientSubsToplimit;
    }

    /**
     * 设置客户当日申购金额上限
     *
     * @param clientSubsToplimit 客户当日申购金额上限
     */
    public void setClientSubsToplimit(BigDecimal clientSubsToplimit) {
        this.clientSubsToplimit = clientSubsToplimit;
    }

    /**
     * 获取客户当日赎回金额上限
     *
     * @return client_redeem_toplimit - 客户当日赎回金额上限
     */
    public BigDecimal getClientRedeemToplimit() {
        return clientRedeemToplimit;
    }

    /**
     * 设置客户当日赎回金额上限
     *
     * @param clientRedeemToplimit 客户当日赎回金额上限
     */
    public void setClientRedeemToplimit(BigDecimal clientRedeemToplimit) {
        this.clientRedeemToplimit = clientRedeemToplimit;
    }

    /**
     * 获取客户持仓限额
     *
     * @return client_position_limit - 客户持仓限额
     */
    public BigDecimal getClientPositionLimit() {
        return clientPositionLimit;
    }

    /**
     * 设置客户持仓限额
     *
     * @param clientPositionLimit 客户持仓限额
     */
    public void setClientPositionLimit(BigDecimal clientPositionLimit) {
        this.clientPositionLimit = clientPositionLimit;
    }

    /**
     * 获取产品当日申购金额上限
     *
     * @return product_subs_toplimit - 产品当日申购金额上限
     */
    public BigDecimal getProductSubsToplimit() {
        return productSubsToplimit;
    }

    /**
     * 设置产品当日申购金额上限
     *
     * @param productSubsToplimit 产品当日申购金额上限
     */
    public void setProductSubsToplimit(BigDecimal productSubsToplimit) {
        this.productSubsToplimit = productSubsToplimit;
    }

    /**
     * 获取产品当日赎回金额上限
     *
     * @return product_redeem_toplimit - 产品当日赎回金额上限
     */
    public BigDecimal getProductRedeemToplimit() {
        return productRedeemToplimit;
    }

    /**
     * 设置产品当日赎回金额上限
     *
     * @param productRedeemToplimit 产品当日赎回金额上限
     */
    public void setProductRedeemToplimit(BigDecimal productRedeemToplimit) {
        this.productRedeemToplimit = productRedeemToplimit;
    }

    /**
     * 获取产品总额度
     *
     * @return total_limit - 产品总额度
     */
    public BigDecimal getTotalLimit() {
        return totalLimit;
    }

    /**
     * 设置产品总额度
     *
     * @param totalLimit 产品总额度
     */
    public void setTotalLimit(BigDecimal totalLimit) {
        this.totalLimit = totalLimit;
    }

    /**
     * 获取产品剩余购买额度，ps:可理解为库存
     *
     * @return purchase_limit - 产品剩余购买额度，ps:可理解为库存
     */
    public BigDecimal getPurchaseLimit() {
        return purchaseLimit;
    }

    /**
     * 设置产品剩余购买额度，ps:可理解为库存
     *
     * @param purchaseLimit 产品剩余购买额度，ps:可理解为库存
     */
    public void setPurchaseLimit(BigDecimal purchaseLimit) {
        this.purchaseLimit = purchaseLimit;
    }

    /**
     * 获取上架时间
     *
     * @return sale_time - 上架时间
     */
    public Date getSaleTime() {
        return saleTime;
    }

    /**
     * 设置上架时间
     *
     * @param saleTime 上架时间
     */
    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    /**
     * 获取录入日期
     *
     * @return create_date - 录入日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置录入日期
     *
     * @param createDate 录入日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}