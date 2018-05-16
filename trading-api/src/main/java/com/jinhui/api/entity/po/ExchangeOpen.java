package com.jinhui.api.entity.po;

import java.util.Date;

public class ExchangeOpen {
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
     * 开户申请单号
     */
    private String applyNo;

    /**
     * 交易所返回的确认日期
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
     * 交易所ID
     */
    private String exchangeCode;

    /**
     * 上报状态：0-未上报，1-已上报
     */
    private String state;

    /**
     * 业务代码: 001-开户
     */
    private String bussCode;

    /**
     * 业务返回码: 0000-成功  0001-失败  0411-已开户
     */
    private String returnCode;

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
     * 获取开户申请单号
     *
     * @return apply_no - 开户申请单号
     */
    public String getApplyNo() {
        return applyNo;
    }

    /**
     * 设置开户申请单号
     *
     * @param applyNo 开户申请单号
     */
    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo == null ? null : applyNo.trim();
    }

    /**
     * 获取交易所返回的确认日期
     *
     * @return confirm_date - 交易所返回的确认日期
     */
    public Date getConfirmDate() {
        return confirmDate;
    }

    /**
     * 设置交易所返回的确认日期
     *
     * @param confirmDate 交易所返回的确认日期
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
     * 获取交易所ID
     *
     * @return exchange_code - 交易所ID
     */
    public String getExchangeCode() {
        return exchangeCode;
    }

    /**
     * 设置交易所ID
     *
     * @param exchangeCode 交易所ID
     */
    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode == null ? null : exchangeCode.trim();
    }

    /**
     * 获取上报状态：0-未上报，1-已上报
     *
     * @return state - 上报状态：0-未上报，1-已上报
     */
    public String getState() {
        return state;
    }

    /**
     * 设置上报状态：0-未上报，1-已上报
     *
     * @param state 上报状态：0-未上报，1-已上报
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取业务代码: 001-开户
     *
     * @return buss_code - 业务代码: 001-开户
     */
    public String getBussCode() {
        return bussCode;
    }

    /**
     * 设置业务代码: 001-开户
     *
     * @param bussCode 业务代码: 001-开户
     */
    public void setBussCode(String bussCode) {
        this.bussCode = bussCode == null ? null : bussCode.trim();
    }

    /**
     * 获取业务返回码: 0000-成功  0001-失败  0411-已开户
     *
     * @return return_code - 业务返回码: 0000-成功  0001-失败  0411-已开户
     */
    public String getReturnCode() {
        return returnCode;
    }

    /**
     * 设置业务返回码: 0000-成功  0001-失败  0411-已开户
     *
     * @param returnCode 业务返回码: 0000-成功  0001-失败  0411-已开户
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode == null ? null : returnCode.trim();
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