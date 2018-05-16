package com.jinhui.api.entity.po;

import java.math.BigDecimal;
import java.util.Date;

public class TradeConsign {
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
     * 确认日期
     */
    private Date confirmDate;

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
     * 委托状态: 0-确认中 1-成功 2-失败 (ps:1或者2的状态要等清算结束后才更改)
     */
    private String consignStatus;

    /**
     * 交易份额
     */
    private BigDecimal transVol;

    /**
     * 交易金额，用于平台内部统计使用
     */
    private BigDecimal transAmount;

    /**
     * 手续费
     */
    private BigDecimal transFix;

    /**
     * 带走收益标志：0-不带走,1-带走
     */
    private String takeIncomeFlag;

    /**
     * 巨额购买处理标志:0-取消，1-顺延
     */
    private String hugeSubsFlag;

    /**
     * 巨额赎回处理标志:0-取消，1-顺延
     */
    private String hugeRedemFlag;

    /**
     * 用户是否签署风险揭示书：0-已签署，1-未签署
     */
    private String riskDisclosure;

    /**
     * 交易银行代码
     */
    private String transBankCode;

    /**
     * 交易银行账号
     */
    private String transBankAct;

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
     * 滚存标志：0-关闭，1-开启
     */
    private String rollingFlag;

    /**
     * 强行赎回原因：0-小于最低持有数，1-司法执行，2-政策原因
     */
    private String forceRedemReason;

    /**
     * 强制赎回类型：0-强制赎回，1-违约赎回，2-到期
     */
    private String forceRedemType;

    /**
     * 赎回方式 0 赎回到用户银行卡  1 赎回到用户虚户
     */
    private String redeemFlag;

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
     * 获取确认日期
     *
     * @return confirm_date - 确认日期
     */
    public Date getConfirmDate() {
        return confirmDate;
    }

    /**
     * 设置确认日期
     *
     * @param confirmDate 确认日期
     */
    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
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
     * 获取委托状态: 0-确认中 1-成功 2-失败 (ps:1或者2的状态要等清算结束后才更改)
     *
     * @return consign_status - 委托状态: 0-确认中 1-成功 2-失败 (ps:1或者2的状态要等清算结束后才更改)
     */
    public String getConsignStatus() {
        return consignStatus;
    }

    /**
     * 设置委托状态: 0-确认中 1-成功 2-失败 (ps:1或者2的状态要等清算结束后才更改)
     *
     * @param consignStatus 委托状态: 0-确认中 1-成功 2-失败 (ps:1或者2的状态要等清算结束后才更改)
     */
    public void setConsignStatus(String consignStatus) {
        this.consignStatus = consignStatus == null ? null : consignStatus.trim();
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
     * 获取带走收益标志：0-不带走,1-带走
     *
     * @return take_income_flag - 带走收益标志：0-不带走,1-带走
     */
    public String getTakeIncomeFlag() {
        return takeIncomeFlag;
    }

    /**
     * 设置带走收益标志：0-不带走,1-带走
     *
     * @param takeIncomeFlag 带走收益标志：0-不带走,1-带走
     */
    public void setTakeIncomeFlag(String takeIncomeFlag) {
        this.takeIncomeFlag = takeIncomeFlag == null ? null : takeIncomeFlag.trim();
    }

    /**
     * 获取巨额购买处理标志:0-取消，1-顺延
     *
     * @return huge_subs_flag - 巨额购买处理标志:0-取消，1-顺延
     */
    public String getHugeSubsFlag() {
        return hugeSubsFlag;
    }

    /**
     * 设置巨额购买处理标志:0-取消，1-顺延
     *
     * @param hugeSubsFlag 巨额购买处理标志:0-取消，1-顺延
     */
    public void setHugeSubsFlag(String hugeSubsFlag) {
        this.hugeSubsFlag = hugeSubsFlag == null ? null : hugeSubsFlag.trim();
    }

    /**
     * 获取巨额赎回处理标志:0-取消，1-顺延
     *
     * @return huge_redem_flag - 巨额赎回处理标志:0-取消，1-顺延
     */
    public String getHugeRedemFlag() {
        return hugeRedemFlag;
    }

    /**
     * 设置巨额赎回处理标志:0-取消，1-顺延
     *
     * @param hugeRedemFlag 巨额赎回处理标志:0-取消，1-顺延
     */
    public void setHugeRedemFlag(String hugeRedemFlag) {
        this.hugeRedemFlag = hugeRedemFlag == null ? null : hugeRedemFlag.trim();
    }

    /**
     * 获取用户是否签署风险揭示书：0-已签署，1-未签署
     *
     * @return risk_disclosure - 用户是否签署风险揭示书：0-已签署，1-未签署
     */
    public String getRiskDisclosure() {
        return riskDisclosure;
    }

    /**
     * 设置用户是否签署风险揭示书：0-已签署，1-未签署
     *
     * @param riskDisclosure 用户是否签署风险揭示书：0-已签署，1-未签署
     */
    public void setRiskDisclosure(String riskDisclosure) {
        this.riskDisclosure = riskDisclosure == null ? null : riskDisclosure.trim();
    }

    /**
     * 获取交易银行代码
     *
     * @return trans_bank_code - 交易银行代码
     */
    public String getTransBankCode() {
        return transBankCode;
    }

    /**
     * 设置交易银行代码
     *
     * @param transBankCode 交易银行代码
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
     * 获取滚存标志：0-关闭，1-开启
     *
     * @return rolling_flag - 滚存标志：0-关闭，1-开启
     */
    public String getRollingFlag() {
        return rollingFlag;
    }

    /**
     * 设置滚存标志：0-关闭，1-开启
     *
     * @param rollingFlag 滚存标志：0-关闭，1-开启
     */
    public void setRollingFlag(String rollingFlag) {
        this.rollingFlag = rollingFlag == null ? null : rollingFlag.trim();
    }

    /**
     * 获取强行赎回原因：0-小于最低持有数，1-司法执行，2-政策原因
     *
     * @return force_redem_reason - 强行赎回原因：0-小于最低持有数，1-司法执行，2-政策原因
     */
    public String getForceRedemReason() {
        return forceRedemReason;
    }

    /**
     * 设置强行赎回原因：0-小于最低持有数，1-司法执行，2-政策原因
     *
     * @param forceRedemReason 强行赎回原因：0-小于最低持有数，1-司法执行，2-政策原因
     */
    public void setForceRedemReason(String forceRedemReason) {
        this.forceRedemReason = forceRedemReason == null ? null : forceRedemReason.trim();
    }

    /**
     * 获取强制赎回类型：0-强制赎回，1-违约赎回，2-到期
     *
     * @return force_redem_type - 强制赎回类型：0-强制赎回，1-违约赎回，2-到期
     */
    public String getForceRedemType() {
        return forceRedemType;
    }

    /**
     * 设置强制赎回类型：0-强制赎回，1-违约赎回，2-到期
     *
     * @param forceRedemType 强制赎回类型：0-强制赎回，1-违约赎回，2-到期
     */
    public void setForceRedemType(String forceRedemType) {
        this.forceRedemType = forceRedemType == null ? null : forceRedemType.trim();
    }

    /**
     * 获取赎回方式 0 赎回到用户银行卡  1 赎回到用户虚户
     *
     * @return redeem_flag - 赎回方式 0 赎回到用户银行卡  1 赎回到用户虚户
     */
    public String getRedeemFlag() {
        return redeemFlag;
    }

    /**
     * 设置赎回方式 0 赎回到用户银行卡  1 赎回到用户虚户
     *
     * @param redeemFlag 赎回方式 0 赎回到用户银行卡  1 赎回到用户虚户
     */
    public void setRedeemFlag(String redeemFlag) {
        this.redeemFlag = redeemFlag == null ? null : redeemFlag.trim();
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