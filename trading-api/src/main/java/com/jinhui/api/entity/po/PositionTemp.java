package com.jinhui.api.entity.po;

import java.math.BigDecimal;
import java.util.Date;

public class PositionTemp {
    /**
     * 表主键
     */
    private Integer id;

    /**
     * 汇总日期
     */
    private Date gatherDate;

    /**
     * 渠道用户id
     */
    private String chnId;

    /**
     * 渠道代码(渠道在平台中的代码标识)
     */
    private String chnCode;

    /**
     * 投资人姓名
     */
    private String name;

    /**
     * 金飞镖产品代码
     */
    private String productNo;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 持有份额
     */
    private BigDecimal totalPostionVol;

    /**
     * 产品每份金额
     */
    private BigDecimal productVol;

    /**
     * 持有金额
     */
    private BigDecimal totalPostionAmount;

    /**
     * 总收益
     */
    private BigDecimal totalIncome;

    /**
     * 总赎回金额
     */
    private BigDecimal totalRedemedAmount;

    /**
     * 总申购金额
     */
    private BigDecimal totalSubsAmount;

    /**
     * 滚存份额
     */
    private BigDecimal rollingVol;

    /**
     * 滚存标志：0-关闭，1-开启
     */
    private String rollingFlag;

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
     * 获取汇总日期
     *
     * @return gather_date - 汇总日期
     */
    public Date getGatherDate() {
        return gatherDate;
    }

    /**
     * 设置汇总日期
     *
     * @param gatherDate 汇总日期
     */
    public void setGatherDate(Date gatherDate) {
        this.gatherDate = gatherDate;
    }

    /**
     * 获取渠道用户id
     *
     * @return chn_id - 渠道用户id
     */
    public String getChnId() {
        return chnId;
    }

    /**
     * 设置渠道用户id
     *
     * @param chnId 渠道用户id
     */
    public void setChnId(String chnId) {
        this.chnId = chnId == null ? null : chnId.trim();
    }

    /**
     * 获取渠道代码(渠道在平台中的代码标识)
     *
     * @return chn_code - 渠道代码(渠道在平台中的代码标识)
     */
    public String getChnCode() {
        return chnCode;
    }

    /**
     * 设置渠道代码(渠道在平台中的代码标识)
     *
     * @param chnCode 渠道代码(渠道在平台中的代码标识)
     */
    public void setChnCode(String chnCode) {
        this.chnCode = chnCode == null ? null : chnCode.trim();
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
     * 获取持有份额
     *
     * @return total_postion_vol - 持有份额
     */
    public BigDecimal getTotalPostionVol() {
        return totalPostionVol;
    }

    /**
     * 设置持有份额
     *
     * @param totalPostionVol 持有份额
     */
    public void setTotalPostionVol(BigDecimal totalPostionVol) {
        this.totalPostionVol = totalPostionVol;
    }

    /**
     * 获取产品每份金额
     *
     * @return product_vol - 产品每份金额
     */
    public BigDecimal getProductVol() {
        return productVol;
    }

    /**
     * 设置产品每份金额
     *
     * @param productVol 产品每份金额
     */
    public void setProductVol(BigDecimal productVol) {
        this.productVol = productVol;
    }

    /**
     * 获取持有金额
     *
     * @return total_postion_amount - 持有金额
     */
    public BigDecimal getTotalPostionAmount() {
        return totalPostionAmount;
    }

    /**
     * 设置持有金额
     *
     * @param totalPostionAmount 持有金额
     */
    public void setTotalPostionAmount(BigDecimal totalPostionAmount) {
        this.totalPostionAmount = totalPostionAmount;
    }

    /**
     * 获取总收益
     *
     * @return total_income - 总收益
     */
    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    /**
     * 设置总收益
     *
     * @param totalIncome 总收益
     */
    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    /**
     * 获取总赎回金额
     *
     * @return total_redemed_amount - 总赎回金额
     */
    public BigDecimal getTotalRedemedAmount() {
        return totalRedemedAmount;
    }

    /**
     * 设置总赎回金额
     *
     * @param totalRedemedAmount 总赎回金额
     */
    public void setTotalRedemedAmount(BigDecimal totalRedemedAmount) {
        this.totalRedemedAmount = totalRedemedAmount;
    }

    /**
     * 获取总申购金额
     *
     * @return total_subs_amount - 总申购金额
     */
    public BigDecimal getTotalSubsAmount() {
        return totalSubsAmount;
    }

    /**
     * 设置总申购金额
     *
     * @param totalSubsAmount 总申购金额
     */
    public void setTotalSubsAmount(BigDecimal totalSubsAmount) {
        this.totalSubsAmount = totalSubsAmount;
    }

    /**
     * 获取滚存份额
     *
     * @return rolling_vol - 滚存份额
     */
    public BigDecimal getRollingVol() {
        return rollingVol;
    }

    /**
     * 设置滚存份额
     *
     * @param rollingVol 滚存份额
     */
    public void setRollingVol(BigDecimal rollingVol) {
        this.rollingVol = rollingVol;
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
}