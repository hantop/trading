package com.jinhui.api.entity.dto;

import javax.validation.constraints.NotNull;

/**
 * 查询客户交易额度接口 交互类
 * Created by Administrator on 2018/1/30 0030.
 */
public class QueryLimit {


    /**
     * 接口请求信息
     **/

    //渠道代码
    @NotNull(message = "渠道代码不能为空")
    private String channelCode;

    //产品名称
    @NotNull(message = "产品名称不能为空")
    private String productName;

    //产品代码
    @NotNull(message = "产品代码不能为空")
    private String productCode;

    //渠道用户ID
    @NotNull(message = "渠道用户ID不能为空")
    private String channelUserId;

    //投资人姓名
    @NotNull(message = "投资人姓名不能为空")
    private String userNameText;

    /**
     * 接口应答信息
     **/

    //已持仓金额
    private String positionAmount;


    //可申购金额
    private String purchaseAmount;


    //可赎回金额
    private String redeemAmount;


    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getChannelUserId() {
        return channelUserId;
    }

    public void setChannelUserId(String channelUserId) {
        this.channelUserId = channelUserId;
    }

    public String getPositionAmount() {
        return positionAmount;
    }

    public void setPositionAmount(String positionAmount) {
        this.positionAmount = positionAmount;
    }

    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public String getRedeemAmount() {
        return redeemAmount;
    }

    public void setRedeemAmount(String redeemAmount) {
        this.redeemAmount = redeemAmount;
    }


    public String getUserNameText() {
        return userNameText;
    }

    public void setUserNameText(String userNameText) {
        this.userNameText = userNameText;
    }

    @Override
    public String toString() {
        return "QueryLimit{" +
                "channelCode='" + channelCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", channelUserId='" + channelUserId + '\'' +
                ", positionAmount='" + positionAmount + '\'' +
                ", purchaseAmount='" + purchaseAmount + '\'' +
                ", redeemAmount='" + redeemAmount + '\'' +
                '}';
    }
}
