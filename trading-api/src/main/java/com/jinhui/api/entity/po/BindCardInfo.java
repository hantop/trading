package com.jinhui.api.entity.po;

import java.util.Date;

public class BindCardInfo {
    /**
     * 表主键
     */
    private Integer id;

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
     * 柜台号
     */
    private String counterNo;

    /**
     * 用户证联客户号
     */
    private String zlUserId;

    /**
     * 开户行
     */
    private String openBank;

    /**
     * 银行账号
     */
    private String bankAccount;

    /**
     * 银行所属省份
     */
    private String province;

    /**
     * 银行所属区域
     */
    private String city;

    /**
     * 手机号码
     */
    private String mobileNo;

    /**
     * 卡状态: 0-正常 1-已解绑
     */
    private String status;

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
     * 获取柜台号
     *
     * @return counter_no - 柜台号
     */
    public String getCounterNo() {
        return counterNo;
    }

    /**
     * 设置柜台号
     *
     * @param counterNo 柜台号
     */
    public void setCounterNo(String counterNo) {
        this.counterNo = counterNo == null ? null : counterNo.trim();
    }

    /**
     * 获取用户证联客户号
     *
     * @return zl_user_id - 用户证联客户号
     */
    public String getZlUserId() {
        return zlUserId;
    }

    /**
     * 设置用户证联客户号
     *
     * @param zlUserId 用户证联客户号
     */
    public void setZlUserId(String zlUserId) {
        this.zlUserId = zlUserId == null ? null : zlUserId.trim();
    }

    /**
     * 获取开户行
     *
     * @return open_bank - 开户行
     */
    public String getOpenBank() {
        return openBank;
    }

    /**
     * 设置开户行
     *
     * @param openBank 开户行
     */
    public void setOpenBank(String openBank) {
        this.openBank = openBank == null ? null : openBank.trim();
    }

    /**
     * 获取银行账号
     *
     * @return bank_account - 银行账号
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * 设置银行账号
     *
     * @param bankAccount 银行账号
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    /**
     * 获取银行所属省份
     *
     * @return province - 银行所属省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置银行所属省份
     *
     * @param province 银行所属省份
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取银行所属区域
     *
     * @return city - 银行所属区域
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置银行所属区域
     *
     * @param city 银行所属区域
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取手机号码
     *
     * @return mobile_no - 手机号码
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * 设置手机号码
     *
     * @param mobileNo 手机号码
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    /**
     * 获取卡状态: 0-正常 1-已解绑
     *
     * @return status - 卡状态: 0-正常 1-已解绑
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置卡状态: 0-正常 1-已解绑
     *
     * @param status 卡状态: 0-正常 1-已解绑
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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