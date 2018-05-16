package com.jinhui.zlrt.entity.dto;

import java.math.BigDecimal;

/**
 * 交易状态查询响应结果
 *
 * @autor wsc
 * @create 2018-01-30 10:43
 **/
public class TradeStatusSearchResponse {

    public String instuId;
    //证联支付分配给商户的机构代码
    public String orgFundDate;
    //所查交易流水的系统日期
    public String orgFundSeqId;
    //用户在证联支付平台里的客户号
    public String userId;
    //业务类型
    public String busiType;
    //基金交易金额
    public BigDecimal transAmt;
    //证联支付的流水号
    public String pnrSeqId;
    //证联支付发起交易的系统日期
    public String pnrDate;
    //证联支付发给基金的时间戳
    public String pnrTime;
    //交易明细应答码
    public String transRespCode;
    //交易明细应描述
    public String transRespDesc;
    //应答码
    public String respCode;
    //业务应答描述
    public String respDesc;

    public String getInstuId() {
        return instuId;
    }

    public void setInstuId(String instuId) {
        this.instuId = instuId;
    }

    public String getOrgFundDate() {
        return orgFundDate;
    }

    public void setOrgFundDate(String orgFundDate) {
        this.orgFundDate = orgFundDate;
    }

    public String getOrgFundSeqId() {
        return orgFundSeqId;
    }

    public void setOrgFundSeqId(String orgFundSeqId) {
        this.orgFundSeqId = orgFundSeqId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }

    public BigDecimal getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(BigDecimal transAmt) {
        this.transAmt = transAmt;
    }

    public String getPnrSeqId() {
        return pnrSeqId;
    }

    public void setPnrSeqId(String pnrSeqId) {
        this.pnrSeqId = pnrSeqId;
    }

    public String getPnrDate() {
        return pnrDate;
    }

    public void setPnrDate(String pnrDate) {
        this.pnrDate = pnrDate;
    }

    public String getPnrTime() {
        return pnrTime;
    }

    public void setPnrTime(String pnrTime) {
        this.pnrTime = pnrTime;
    }

    public String getTransRespCode() {
        return transRespCode;
    }

    public void setTransRespCode(String transRespCode) {
        this.transRespCode = transRespCode;
    }

    public String getTransRespDesc() {
        return transRespDesc;
    }

    public void setTransRespDesc(String transRespDesc) {
        this.transRespDesc = transRespDesc;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    @Override
    public String toString() {
        return "TradeStatusSearchResponse{" +
                "instuId='" + instuId + '\'' +
                ", orgFundDate='" + orgFundDate + '\'' +
                ", orgFundSeqId='" + orgFundSeqId + '\'' +
                ", userId='" + userId + '\'' +
                ", busiType='" + busiType + '\'' +
                ", transAmt=" + transAmt +
                ", pnrSeqId='" + pnrSeqId + '\'' +
                ", pnrDate='" + pnrDate + '\'' +
                ", pnrTime='" + pnrTime + '\'' +
                ", transRespCode='" + transRespCode + '\'' +
                ", transRespDesc='" + transRespDesc + '\'' +
                ", respCode='" + respCode + '\'' +
                ", respDesc='" + respDesc + '\'' +
                '}';
    }
}
