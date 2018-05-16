package com.jinhui.api.entity.po;

import java.math.BigDecimal;
import java.util.Date;

public class TradeFundTransfer {
    /**
     * 表主键
     */
    private Integer id;

    /**
     * 申请日期
     */
    private Date applyDate;

    /**
     * 申请时间
     */
    private Date applyTime;

    /**
     * 申请单号
     */
    private String applyNo;

    /**
     * 资金划转流水号
     */
    private String transferNo;

    /**
     * 投资人姓名
     */
    private String name;

    /**
     * 渠道用户ID
     */
    private String chnId;

    /**
     * 渠道方代码(渠道在平台中的代码标识)
     */
    private String chnCode;

    /**
     * 金飞镖产品代码
     */
    private String productNo;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 业务代码: 022-申购 024-赎回
     */
    private String bussCode;

    /**
     * 交易份额
     */
    private BigDecimal transVol;

    /**
     * 交易金额，用于平台内部统计使用
     */
    private BigDecimal transAmount;

    /**
     * 优惠金额
     */
    private BigDecimal benefitAmount;

    /**
     * 支付金额
     */
    private BigDecimal payAmount;

    /**
     * 业务标志: 173-资金拨出 174-资金拨入
     */
    private String payFlag;

    /**
     * 支付方式: 0-余额支付 1-银行卡支付 2-余额+银行卡 3-余额+红包 4-银行卡+红包
     */
    private String payWay;

    /**
     * 支付状态: 0-成功 1-已报 2-未报 3-失败
     */
    private String payStatus;

    /**
     * 交易银行名称
     */
    private String transBankCode;

    /**
     * 交易银行账号
     */
    private String transBankAct;

    /**
     * 手续费
     */
    private BigDecimal transFix;

    /**
     * 收费方式：0-前端收费，1-后端收费，2-混合收费
     */
    private String chargeType;

    /**
     * 收费类型：1-指定费率，2-指定费用
     */
    private String chargeWay;

    /**
     * 指定费率
     */
    private BigDecimal chargeRate;

    /**
     * 指定费用
     */
    private BigDecimal specifyFee;

    /**
     * 证联交易日期
     */
    private String zlPnrDate;

    /**
     * 证联交易时间戳
     */
    private String zlPnrTime;

    /**
     * 证联支付流水号
     */
    private String zlPnrSeqid;

    /**
     * 创建时间
     */
    private Date createTime;

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
     * 获取申请日期
     *
     * @return apply_date - 申请日期
     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * 设置申请日期
     *
     * @param applyDate 申请日期
     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * 获取申请时间
     *
     * @return apply_time - 申请时间
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * 设置申请时间
     *
     * @param applyTime 申请时间
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 获取申请单号
     *
     * @return apply_no - 申请单号
     */
    public String getApplyNo() {
        return applyNo;
    }

    /**
     * 设置申请单号
     *
     * @param applyNo 申请单号
     */
    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo == null ? null : applyNo.trim();
    }

    /**
     * 获取资金划转流水号
     *
     * @return transfer_no - 资金划转流水号
     */
    public String getTransferNo() {
        return transferNo;
    }

    /**
     * 设置资金划转流水号
     *
     * @param transferNo 资金划转流水号
     */
    public void setTransferNo(String transferNo) {
        this.transferNo = transferNo == null ? null : transferNo.trim();
    }

    /**
     * 获取投资人姓名
     *
     * @return name - 投资人姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置投资人姓名
     *
     * @param name 投资人姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取渠道用户ID
     *
     * @return chn_id - 渠道用户ID
     */
    public String getChnId() {
        return chnId;
    }

    /**
     * 设置渠道用户ID
     *
     * @param chnId 渠道用户ID
     */
    public void setChnId(String chnId) {
        this.chnId = chnId == null ? null : chnId.trim();
    }

    /**
     * 获取渠道方代码(渠道在平台中的代码标识)
     *
     * @return chn_code - 渠道方代码(渠道在平台中的代码标识)
     */
    public String getChnCode() {
        return chnCode;
    }

    /**
     * 设置渠道方代码(渠道在平台中的代码标识)
     *
     * @param chnCode 渠道方代码(渠道在平台中的代码标识)
     */
    public void setChnCode(String chnCode) {
        this.chnCode = chnCode == null ? null : chnCode.trim();
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
     * 获取业务代码: 022-申购 024-赎回
     *
     * @return buss_code - 业务代码: 022-申购 024-赎回
     */
    public String getBussCode() {
        return bussCode;
    }

    /**
     * 设置业务代码: 022-申购 024-赎回
     *
     * @param bussCode 业务代码: 022-申购 024-赎回
     */
    public void setBussCode(String bussCode) {
        this.bussCode = bussCode == null ? null : bussCode.trim();
    }

    /**
     * 获取交易份额
     *
     * @return trans_vol - 交易份额
     */
    public BigDecimal getTransVol() {
        return transVol;
    }

    /**
     * 设置交易份额
     *
     * @param transVol 交易份额
     */
    public void setTransVol(BigDecimal transVol) {
        this.transVol = transVol;
    }

    /**
     * 获取交易金额，用于平台内部统计使用
     *
     * @return trans_amount - 交易金额，用于平台内部统计使用
     */
    public BigDecimal getTransAmount() {
        return transAmount;
    }

    /**
     * 设置交易金额，用于平台内部统计使用
     *
     * @param transAmount 交易金额，用于平台内部统计使用
     */
    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    /**
     * 获取优惠金额
     *
     * @return benefit_amount - 优惠金额
     */
    public BigDecimal getBenefitAmount() {
        return benefitAmount;
    }

    /**
     * 设置优惠金额
     *
     * @param benefitAmount 优惠金额
     */
    public void setBenefitAmount(BigDecimal benefitAmount) {
        this.benefitAmount = benefitAmount;
    }

    /**
     * 获取支付金额
     *
     * @return pay_amount - 支付金额
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * 设置支付金额
     *
     * @param payAmount 支付金额
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 获取业务标志: 173-资金拨出 174-资金拨入
     *
     * @return pay_flag - 业务标志: 173-资金拨出 174-资金拨入
     */
    public String getPayFlag() {
        return payFlag;
    }

    /**
     * 设置业务标志: 173-资金拨出 174-资金拨入
     *
     * @param payFlag 业务标志: 173-资金拨出 174-资金拨入
     */
    public void setPayFlag(String payFlag) {
        this.payFlag = payFlag == null ? null : payFlag.trim();
    }

    /**
     * 获取支付方式: 0-余额支付 1-银行卡支付 2-余额+银行卡 3-余额+红包 4-银行卡+红包
     *
     * @return pay_way - 支付方式: 0-余额支付 1-银行卡支付 2-余额+银行卡 3-余额+红包 4-银行卡+红包
     */
    public String getPayWay() {
        return payWay;
    }

    /**
     * 设置支付方式: 0-余额支付 1-银行卡支付 2-余额+银行卡 3-余额+红包 4-银行卡+红包
     *
     * @param payWay 支付方式: 0-余额支付 1-银行卡支付 2-余额+银行卡 3-余额+红包 4-银行卡+红包
     */
    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    /**
     * 获取支付状态: 0-成功 1-已报 2-未报 3-失败
     *
     * @return pay_status - 支付状态: 0-成功 1-已报 2-未报 3-失败
     */
    public String getPayStatus() {
        return payStatus;
    }

    /**
     * 设置支付状态: 0-成功 1-已报 2-未报 3-失败
     *
     * @param payStatus 支付状态: 0-成功 1-已报 2-未报 3-失败
     */
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    /**
     * 获取交易银行名称
     *
     * @return trans_bank_code - 交易银行名称
     */
    public String getTransBankCode() {
        return transBankCode;
    }

    /**
     * 设置交易银行名称
     *
     * @param transBankCode 交易银行名称
     */
    public void setTransBankCode(String transBankCode) {
        this.transBankCode = transBankCode == null ? null : transBankCode.trim();
    }

    /**
     * 获取交易银行账号
     *
     * @return trans_bank_act - 交易银行账号
     */
    public String getTransBankAct() {
        return transBankAct;
    }

    /**
     * 设置交易银行账号
     *
     * @param transBankAct 交易银行账号
     */
    public void setTransBankAct(String transBankAct) {
        this.transBankAct = transBankAct == null ? null : transBankAct.trim();
    }

    /**
     * 获取手续费
     *
     * @return trans_fix - 手续费
     */
    public BigDecimal getTransFix() {
        return transFix;
    }

    /**
     * 设置手续费
     *
     * @param transFix 手续费
     */
    public void setTransFix(BigDecimal transFix) {
        this.transFix = transFix;
    }

    /**
     * 获取收费方式：0-前端收费，1-后端收费，2-混合收费
     *
     * @return charge_type - 收费方式：0-前端收费，1-后端收费，2-混合收费
     */
    public String getChargeType() {
        return chargeType;
    }

    /**
     * 设置收费方式：0-前端收费，1-后端收费，2-混合收费
     *
     * @param chargeType 收费方式：0-前端收费，1-后端收费，2-混合收费
     */
    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    /**
     * 获取收费类型：1-指定费率，2-指定费用
     *
     * @return charge_way - 收费类型：1-指定费率，2-指定费用
     */
    public String getChargeWay() {
        return chargeWay;
    }

    /**
     * 设置收费类型：1-指定费率，2-指定费用
     *
     * @param chargeWay 收费类型：1-指定费率，2-指定费用
     */
    public void setChargeWay(String chargeWay) {
        this.chargeWay = chargeWay == null ? null : chargeWay.trim();
    }

    /**
     * 获取指定费率
     *
     * @return charge_rate - 指定费率
     */
    public BigDecimal getChargeRate() {
        return chargeRate;
    }

    /**
     * 设置指定费率
     *
     * @param chargeRate 指定费率
     */
    public void setChargeRate(BigDecimal chargeRate) {
        this.chargeRate = chargeRate;
    }

    /**
     * 获取指定费用
     *
     * @return specify_fee - 指定费用
     */
    public BigDecimal getSpecifyFee() {
        return specifyFee;
    }

    /**
     * 设置指定费用
     *
     * @param specifyFee 指定费用
     */
    public void setSpecifyFee(BigDecimal specifyFee) {
        this.specifyFee = specifyFee;
    }

    /**
     * 获取证联交易日期
     *
     * @return zl_pnr_date - 证联交易日期
     */
    public String getZlPnrDate() {
        return zlPnrDate;
    }

    /**
     * 设置证联交易日期
     *
     * @param zlPnrDate 证联交易日期
     */
    public void setZlPnrDate(String zlPnrDate) {
        this.zlPnrDate = zlPnrDate == null ? null : zlPnrDate.trim();
    }

    /**
     * 获取证联交易时间戳
     *
     * @return zl_pnr_time - 证联交易时间戳
     */
    public String getZlPnrTime() {
        return zlPnrTime;
    }

    /**
     * 设置证联交易时间戳
     *
     * @param zlPnrTime 证联交易时间戳
     */
    public void setZlPnrTime(String zlPnrTime) {
        this.zlPnrTime = zlPnrTime == null ? null : zlPnrTime.trim();
    }

    /**
     * 获取证联支付流水号
     *
     * @return zl_pnr_seqid - 证联支付流水号
     */
    public String getZlPnrSeqid() {
        return zlPnrSeqid;
    }

    /**
     * 设置证联支付流水号
     *
     * @param zlPnrSeqid 证联支付流水号
     */
    public void setZlPnrSeqid(String zlPnrSeqid) {
        this.zlPnrSeqid = zlPnrSeqid == null ? null : zlPnrSeqid.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}