package com.jinhui.api.entity.dto;

import javax.validation.constraints.NotNull;

/** 用户持仓查询接口
 * Created by Administrator on 2018/2/2 0002.
 */
public class QueryPosition {

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

    //金飞镖产品代码
    private String productCode;

    //产品名称
    private String productName;

    //产品每份金额
    private String productVol;

    //持有金额
    private String positionAmount;

    //持有份额
    private String positionVol;

    //单个产品的累计收益
    private String totalIncome;

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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductVol() {
        return productVol;
    }

    public void setProductVol(String productVol) {
        this.productVol = productVol;
    }

    public String getPositionAmount() {
        return positionAmount;
    }

    public void setPositionAmount(String positionAmount) {
        this.positionAmount = positionAmount;
    }

    public String getPositionVol() {
        return positionVol;
    }

    public void setPositionVol(String positionVol) {
        this.positionVol = positionVol;
    }

    public String getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(String totalIncome) {
        this.totalIncome = totalIncome;
    }
}
