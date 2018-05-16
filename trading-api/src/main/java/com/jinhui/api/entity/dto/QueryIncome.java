package com.jinhui.api.entity.dto;

import javax.validation.constraints.NotNull;

/** 用户收益查询接口
 * Created by Administrator on 2018/2/2 0002.
 */
public class QueryIncome {



    /**
     * 接口请求信息
     **/

    //投资人姓名
    private String userNameText;

    //渠道用户ID
    @NotNull(message = "渠道用户ID不能为空")
    private String channelUserId;

    //渠道代码
    @NotNull(message = "渠道代码不能为空")
    private String channelCode;


    //金飞镖产品代码
    @NotNull(message = "产品代码不能为空")
    private String productNo;


    /**
     * 接口应答信息
     **/

    //收益日期
    private String incomeDate;

    //产品名称
    private String productName;

    //单个产品的累计收益
    private String totalIncome;

    //收益金额
    private String incomeAmount;


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

    public String getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(String incomeDate) {
        this.incomeDate = incomeDate;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(String totalIncome) {
        this.totalIncome = totalIncome;
    }

    public String getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(String incomeAmount) {
        this.incomeAmount = incomeAmount;
    }
}
