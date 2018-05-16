package com.jinhui.api.entity.dto;

import javax.validation.constraints.NotNull;

/**
 * 用户资产汇总查询接口
 * Created by Administrator on 2018/2/2 0002.
 */
public class QueryAssetSummary {

    /**
     * 接口请求信息
     **/
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

    //汇总日期
    private String gatherDate;

    //账户总额
    private String totalAmount;

    //持有金额
    private String positionAmount;

    //累计收益
    private String totalIncome;

    //在途金额
    private String transitionalFund;

    //账户余额
    private String accountBalance;


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

    public String getGatherDate() {
        return gatherDate;
    }

    public void setGatherDate(String gatherDate) {
        this.gatherDate = gatherDate;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPositionAmount() {
        return positionAmount;
    }

    public void setPositionAmount(String positionAmount) {
        this.positionAmount = positionAmount;
    }

    public String getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(String totalIncome) {
        this.totalIncome = totalIncome;
    }

    public String getTransitionalFund() {
        return transitionalFund;
    }

    public void setTransitionalFund(String transitionalFund) {
        this.transitionalFund = transitionalFund;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }
}
