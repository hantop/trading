package com.jinhui.zlrt.entity.dto;

import javax.validation.constraints.NotNull;

/**
 * 交易状态查询请求参数
 *
 * @autor wsc
 * @create 2018-01-30 10:37
 **/
public class TradeStatusSearchRequest {

    //证联支付分配给商户的机构代码
    @NotNull(message = "证联支付分配给商户的机构代码不能为空")
    private String instuId;
    //所查交易流水的系统日期
    @NotNull(message = "系统日期不能为空")
    private String orgFundDate;
    //流水号
    @NotNull(message = "流水号不能为空")
    private String orgFundSeqId;
    //业务类型
    @NotNull(message = "业务类型不能为空")
    private String busiType;

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

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }
}
