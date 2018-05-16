package com.jinhui.api.entity.po;

import java.util.Date;

public class User {
    /**
     * 表主键
     */
    private Integer id;

    private Date applyDate;

    private Date applyTime;

    /**
     * 申请单编号
     */
    private String applyNo;

    /**
     * 渠道方代码(渠道在平台中的代码标识)
     */
    private String chnCode;

    /**
     * 渠道用户ID
     */
    private String chnId;

    /**
     * 用户证联客户号
     */
    private String zlUserId;

    /**
     * 投资人ID
     */
    private String investorId;

    /**
     * 投资人姓名
     */
    private String name;

    /**
     * 客户类别:1-机构,1-个人,2-自营
     */
    private String userFlag;

    /**
     * 证件类型: 机构: 0-组织机构代码证,1-营业执照  个人: 0-身份证,1-护照
     */
    private String idType;

    /**
     * 证件号码
     */
    private String idNo;

    /**
     * 性别，0-男，1-女,0-非自然人
     */
    private String sex;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 开户行
     */
    private String openBank;

    /**
     * 银行账号
     */
    private String bankAccount;

    /**
     * 客户风险级别:0-默认型 1-保守型 2-稳健型 3-积极型 4-激进型
     */
    private String riskLevel;

    /**
     * 法人代表姓名
     */
    private String instReprIdName;

    /**
     * 法人代表证件类型 0-身份证 1-护照
     */
    private String instReprIdType;

    /**
     * 法人代表证件号码
     */
    private String instReprIdNo;

    /**
     * 法人代表证件有效期
     */
    private Date instReprExpdate;

    /**
     * 法人代表联系电话
     */
    private String instReprPhone;

    /**
     * 银行省份
     */
    private String bankProvinceCode;

    /**
     * 银行所属地区
     */
    private String bankRegionCode;

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
     * @return apply_date
     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * @param applyDate
     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * @return apply_time
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * @param applyTime
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 获取申请单编号
     *
     * @return apply_no - 申请单编号
     */
    public String getApplyNo() {
        return applyNo;
    }

    /**
     * 设置申请单编号
     *
     * @param applyNo 申请单编号
     */
    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo == null ? null : applyNo.trim();
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
     * 获取投资人ID
     *
     * @return investor_id - 投资人ID
     */
    public String getInvestorId() {
        return investorId;
    }

    /**
     * 设置投资人ID
     *
     * @param investorId 投资人ID
     */
    public void setInvestorId(String investorId) {
        this.investorId = investorId == null ? null : investorId.trim();
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
     * 获取客户类别:1-机构,1-个人,2-自营
     *
     * @return user_flag - 客户类别:1-机构,1-个人,2-自营
     */
    public String getUserFlag() {
        return userFlag;
    }

    /**
     * 设置客户类别:1-机构,1-个人,2-自营
     *
     * @param userFlag 客户类别:1-机构,1-个人,2-自营
     */
    public void setUserFlag(String userFlag) {
        this.userFlag = userFlag == null ? null : userFlag.trim();
    }

    /**
     * 获取证件类型: 机构: 0-组织机构代码证,1-营业执照  个人: 0-身份证,1-护照
     *
     * @return id_type - 证件类型: 机构: 0-组织机构代码证,1-营业执照  个人: 0-身份证,1-护照
     */
    public String getIdType() {
        return idType;
    }

    /**
     * 设置证件类型: 机构: 0-组织机构代码证,1-营业执照  个人: 0-身份证,1-护照
     *
     * @param idType 证件类型: 机构: 0-组织机构代码证,1-营业执照  个人: 0-身份证,1-护照
     */
    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    /**
     * 获取证件号码
     *
     * @return id_no - 证件号码
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * 设置证件号码
     *
     * @param idNo 证件号码
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    /**
     * 获取性别，0-男，1-女,0-非自然人
     *
     * @return sex - 性别，0-男，1-女,0-非自然人
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别，0-男，1-女,0-非自然人
     *
     * @param sex 性别，0-男，1-女,0-非自然人
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取联系地址
     *
     * @return address - 联系地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置联系地址
     *
     * @param address 联系地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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
     * 获取客户风险级别:0-默认型 1-保守型 2-稳健型 3-积极型 4-激进型
     *
     * @return risk_level - 客户风险级别:0-默认型 1-保守型 2-稳健型 3-积极型 4-激进型
     */
    public String getRiskLevel() {
        return riskLevel;
    }

    /**
     * 设置客户风险级别:0-默认型 1-保守型 2-稳健型 3-积极型 4-激进型
     *
     * @param riskLevel 客户风险级别:0-默认型 1-保守型 2-稳健型 3-积极型 4-激进型
     */
    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel == null ? null : riskLevel.trim();
    }

    /**
     * 获取法人代表姓名
     *
     * @return inst_repr_id_name - 法人代表姓名
     */
    public String getInstReprIdName() {
        return instReprIdName;
    }

    /**
     * 设置法人代表姓名
     *
     * @param instReprIdName 法人代表姓名
     */
    public void setInstReprIdName(String instReprIdName) {
        this.instReprIdName = instReprIdName == null ? null : instReprIdName.trim();
    }

    /**
     * 获取法人代表证件类型 0-身份证 1-护照
     *
     * @return inst_repr_id_type - 法人代表证件类型 0-身份证 1-护照
     */
    public String getInstReprIdType() {
        return instReprIdType;
    }

    /**
     * 设置法人代表证件类型 0-身份证 1-护照
     *
     * @param instReprIdType 法人代表证件类型 0-身份证 1-护照
     */
    public void setInstReprIdType(String instReprIdType) {
        this.instReprIdType = instReprIdType == null ? null : instReprIdType.trim();
    }

    /**
     * 获取法人代表证件号码
     *
     * @return inst_repr_id_no - 法人代表证件号码
     */
    public String getInstReprIdNo() {
        return instReprIdNo;
    }

    /**
     * 设置法人代表证件号码
     *
     * @param instReprIdNo 法人代表证件号码
     */
    public void setInstReprIdNo(String instReprIdNo) {
        this.instReprIdNo = instReprIdNo == null ? null : instReprIdNo.trim();
    }

    /**
     * 获取法人代表证件有效期
     *
     * @return inst_repr_expdate - 法人代表证件有效期
     */
    public Date getInstReprExpdate() {
        return instReprExpdate;
    }

    /**
     * 设置法人代表证件有效期
     *
     * @param instReprExpdate 法人代表证件有效期
     */
    public void setInstReprExpdate(Date instReprExpdate) {
        this.instReprExpdate = instReprExpdate;
    }

    /**
     * 获取法人代表联系电话
     *
     * @return inst_repr_phone - 法人代表联系电话
     */
    public String getInstReprPhone() {
        return instReprPhone;
    }

    /**
     * 设置法人代表联系电话
     *
     * @param instReprPhone 法人代表联系电话
     */
    public void setInstReprPhone(String instReprPhone) {
        this.instReprPhone = instReprPhone == null ? null : instReprPhone.trim();
    }

    /**
     * 获取银行省份
     *
     * @return bank_province_code - 银行省份
     */
    public String getBankProvinceCode() {
        return bankProvinceCode;
    }

    /**
     * 设置银行省份
     *
     * @param bankProvinceCode 银行省份
     */
    public void setBankProvinceCode(String bankProvinceCode) {
        this.bankProvinceCode = bankProvinceCode == null ? null : bankProvinceCode.trim();
    }

    /**
     * 获取银行所属地区
     *
     * @return bank_region_code - 银行所属地区
     */
    public String getBankRegionCode() {
        return bankRegionCode;
    }

    /**
     * 设置银行所属地区
     *
     * @param bankRegionCode 银行所属地区
     */
    public void setBankRegionCode(String bankRegionCode) {
        this.bankRegionCode = bankRegionCode == null ? null : bankRegionCode.trim();
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