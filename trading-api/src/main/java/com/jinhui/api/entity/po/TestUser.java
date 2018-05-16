package com.jinhui.api.entity.po;

import java.util.Date;

public class TestUser {
    /**
     * 表主键
     */
    private Integer id;

    /**
     * 登录用户ID
     */
    private String loginId;

    /**
     * 渠道方代码(渠道在平台中的代码标识)
     */
    private String channelCode;

    /**
     * 渠道用户ID
     */
    private String channelUserId;

    /**
     * 投资人姓名
     */
    private String userNameText;

    /**
     * 客户类别:0-机构,1-个人,2-自营
     */
    private String userType;

    /**
     * 个人证件类型:00-身份证，01-护照 02-军官证，03-士兵证 04-港澳居民来往内地通行证，05-户口本 06-外国护照， 08-文职证，09-警官证 0A-台胞证 机构证件类型:10-组织机构代码证 11-营业执照，12-行政机关 13-社会团体，14-军队 15-武警 16-下属机构（具有主管单位批文号）17-基金会，18-其它 19-统一社会信用代码 07-其它
     */
    private String certType;

    /**
     * 证件号码
     */
    private String certId;

    /**
     * 性别，0-男，1-女,0-非自然人
     */
    private String sex;

    /**
     * 联系电话
     */
    private String phoneNo;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 开户行
     */
    private String bankCode;

    /**
     * 银行账号
     */
    private String cardNo;

    /**
     * 客户风险级别:0-默认型 1-保守型 2-稳健型 3-积极型 4-激进型
     */
    private String clientRiskRate;

    /**
     * 法人代表姓名
     */
    private String instReprName;

    /**
     * 法人代表证件类型 0-身份证 1-护照
     */
    private String instReprIdType;

    /**
     * 法人代表证件号码
     */
    private String instReprIdCode;

    /**
     * 法人代表证件有效期
     */
    private Date instReprCertValidDate;

    /**
     * 法人代表联系电话
     */
    private String instReprphoneNo;

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
     * 获取登录用户ID
     *
     * @return login_id - 登录用户ID
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * 设置登录用户ID
     *
     * @param loginId 登录用户ID
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId == null ? null : loginId.trim();
    }

    /**
     * 获取渠道方代码(渠道在平台中的代码标识)
     *
     * @return channel_code - 渠道方代码(渠道在平台中的代码标识)
     */
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * 设置渠道方代码(渠道在平台中的代码标识)
     *
     * @param channelCode 渠道方代码(渠道在平台中的代码标识)
     */
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    /**
     * 获取渠道用户ID
     *
     * @return channel_user_id - 渠道用户ID
     */
    public String getChannelUserId() {
        return channelUserId;
    }

    /**
     * 设置渠道用户ID
     *
     * @param channelUserId 渠道用户ID
     */
    public void setChannelUserId(String channelUserId) {
        this.channelUserId = channelUserId == null ? null : channelUserId.trim();
    }

    /**
     * 获取投资人姓名
     *
     * @return user_name_text - 投资人姓名
     */
    public String getUserNameText() {
        return userNameText;
    }

    /**
     * 设置投资人姓名
     *
     * @param userNameText 投资人姓名
     */
    public void setUserNameText(String userNameText) {
        this.userNameText = userNameText == null ? null : userNameText.trim();
    }

    /**
     * 获取客户类别:0-机构,1-个人,2-自营
     *
     * @return user_type - 客户类别:0-机构,1-个人,2-自营
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置客户类别:0-机构,1-个人,2-自营
     *
     * @param userType 客户类别:0-机构,1-个人,2-自营
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * 获取个人证件类型:00-身份证，01-护照 02-军官证，03-士兵证 04-港澳居民来往内地通行证，05-户口本 06-外国护照， 08-文职证，09-警官证 0A-台胞证 机构证件类型:10-组织机构代码证 11-营业执照，12-行政机关 13-社会团体，14-军队 15-武警 16-下属机构（具有主管单位批文号）17-基金会，18-其它 19-统一社会信用代码 07-其它
     *
     * @return cert_type - 个人证件类型:00-身份证，01-护照 02-军官证，03-士兵证 04-港澳居民来往内地通行证，05-户口本 06-外国护照， 08-文职证，09-警官证 0A-台胞证 机构证件类型:10-组织机构代码证 11-营业执照，12-行政机关 13-社会团体，14-军队 15-武警 16-下属机构（具有主管单位批文号）17-基金会，18-其它 19-统一社会信用代码 07-其它
     */
    public String getCertType() {
        return certType;
    }

    /**
     * 设置个人证件类型:00-身份证，01-护照 02-军官证，03-士兵证 04-港澳居民来往内地通行证，05-户口本 06-外国护照， 08-文职证，09-警官证 0A-台胞证 机构证件类型:10-组织机构代码证 11-营业执照，12-行政机关 13-社会团体，14-军队 15-武警 16-下属机构（具有主管单位批文号）17-基金会，18-其它 19-统一社会信用代码 07-其它
     *
     * @param certType 个人证件类型:00-身份证，01-护照 02-军官证，03-士兵证 04-港澳居民来往内地通行证，05-户口本 06-外国护照， 08-文职证，09-警官证 0A-台胞证 机构证件类型:10-组织机构代码证 11-营业执照，12-行政机关 13-社会团体，14-军队 15-武警 16-下属机构（具有主管单位批文号）17-基金会，18-其它 19-统一社会信用代码 07-其它
     */
    public void setCertType(String certType) {
        this.certType = certType == null ? null : certType.trim();
    }

    /**
     * 获取证件号码
     *
     * @return cert_id - 证件号码
     */
    public String getCertId() {
        return certId;
    }

    /**
     * 设置证件号码
     *
     * @param certId 证件号码
     */
    public void setCertId(String certId) {
        this.certId = certId == null ? null : certId.trim();
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
     * @return phone_no - 联系电话
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * 设置联系电话
     *
     * @param phoneNo 联系电话
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
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
     * @return bank_code - 开户行
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * 设置开户行
     *
     * @param bankCode 开户行
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    /**
     * 获取银行账号
     *
     * @return card_no - 银行账号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置银行账号
     *
     * @param cardNo 银行账号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 获取客户风险级别:0-默认型 1-保守型 2-稳健型 3-积极型 4-激进型
     *
     * @return client_risk_rate - 客户风险级别:0-默认型 1-保守型 2-稳健型 3-积极型 4-激进型
     */
    public String getClientRiskRate() {
        return clientRiskRate;
    }

    /**
     * 设置客户风险级别:0-默认型 1-保守型 2-稳健型 3-积极型 4-激进型
     *
     * @param clientRiskRate 客户风险级别:0-默认型 1-保守型 2-稳健型 3-积极型 4-激进型
     */
    public void setClientRiskRate(String clientRiskRate) {
        this.clientRiskRate = clientRiskRate == null ? null : clientRiskRate.trim();
    }

    /**
     * 获取法人代表姓名
     *
     * @return inst_repr_name - 法人代表姓名
     */
    public String getInstReprName() {
        return instReprName;
    }

    /**
     * 设置法人代表姓名
     *
     * @param instReprName 法人代表姓名
     */
    public void setInstReprName(String instReprName) {
        this.instReprName = instReprName == null ? null : instReprName.trim();
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
     * @return inst_repr_id_code - 法人代表证件号码
     */
    public String getInstReprIdCode() {
        return instReprIdCode;
    }

    /**
     * 设置法人代表证件号码
     *
     * @param instReprIdCode 法人代表证件号码
     */
    public void setInstReprIdCode(String instReprIdCode) {
        this.instReprIdCode = instReprIdCode == null ? null : instReprIdCode.trim();
    }

    /**
     * 获取法人代表证件有效期
     *
     * @return inst_repr_cert_valid_date - 法人代表证件有效期
     */
    public Date getInstReprCertValidDate() {
        return instReprCertValidDate;
    }

    /**
     * 设置法人代表证件有效期
     *
     * @param instReprCertValidDate 法人代表证件有效期
     */
    public void setInstReprCertValidDate(Date instReprCertValidDate) {
        this.instReprCertValidDate = instReprCertValidDate;
    }

    /**
     * 获取法人代表联系电话
     *
     * @return inst_reprphone_no - 法人代表联系电话
     */
    public String getInstReprphoneNo() {
        return instReprphoneNo;
    }

    /**
     * 设置法人代表联系电话
     *
     * @param instReprphoneNo 法人代表联系电话
     */
    public void setInstReprphoneNo(String instReprphoneNo) {
        this.instReprphoneNo = instReprphoneNo == null ? null : instReprphoneNo.trim();
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