package com.jinhui.api.entity.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** 银行卡查询
 * Created by Administrator on 2018/2/2 0002.
 */
public class QueryCard {


    /**
     * 接口请求信息
     **/
//    //申请日期yyyyMMdd
//    @NotNull(message = "申请日期不能为空")
//    @Size(min =8 ,max=8, message = "申请日期格式不正确")
//    private String fundDate;
//
//    //申请时间yyyyMMddHHmmss
//    @NotNull(message = "申请时间不能为空")
//    @Size(min =14  ,max=14, message = "申请时间格式不正确")
//    private String fundTime;

    //投资人姓名
    @NotNull(message = "投资人姓名不能为空")
    private String userNameText;

    //渠道用户ID
    @NotNull(message = "渠道用户ID不能为空")
    private String channelUserId;

    //渠道代码
    @NotNull(message = "渠道代码不能为空")
    private String channelCode;


    /**
     * 接口应答信息
     **/

    //银行代码
    private String bankCode;

    //银行账号
    private String cardNo;

    //银行所属省市代码
    private String bankProvinceCode;

    //银行所属地区代码
    private String bankRegionCode;

    //卡状态
    private String cardDate;

    private String cardTime;

    private String status;

//    public String getFundDate() {
//        return fundDate;
//    }
//
//    public void setFundDate(String fundDate) {
//        this.fundDate = fundDate;
//    }
//
//    public String getFundTime() {
//        return fundTime;
//    }
//
//    public void setFundTime(String fundTime) {
//        this.fundTime = fundTime;
//    }

    public String getUserNameText() {
        return userNameText;
    }

    public void setUserNameText(String userNameText) {
        this.userNameText = userNameText;
    }

    public String getChannelUserId() {
        return channelUserId;
    }

    public void setChannelUserId(String channelUserId) {
        this.channelUserId = channelUserId;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getBankProvinceCode() {
        return bankProvinceCode;
    }

    public void setBankProvinceCode(String bankProvinceCode) {
        this.bankProvinceCode = bankProvinceCode;
    }

    public String getBankRegionCode() {
        return bankRegionCode;
    }

    public void setBankRegionCode(String bankRegionCode) {
        this.bankRegionCode = bankRegionCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCardDate() {
        return cardDate;
    }

    public void setCardDate(String cardDate) {
        this.cardDate = cardDate;
    }

    public String getCardTime() {
        return cardTime;
    }

    public void setCardTime(String cardTime) {
        this.cardTime = cardTime;
    }
}
