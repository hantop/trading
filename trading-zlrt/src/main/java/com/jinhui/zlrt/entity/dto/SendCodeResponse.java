package com.jinhui.zlrt.entity.dto;

/**
 * 开户响应参数
 *
 * @autor wsc
 * @create 2018-01-30 9:19
 **/
public class SendCodeResponse {

    //证联支付分配给商户的机构代码
    public String instuId;
    //商户的系统日期(YYYYMMDD)
    public String merchantDate;
    //商户的时间戳(HHMMSS)
    public String merchantTime;
    //商户系统流水号
    public String merchantSeqId;
    //证联支付发起交易的系统日期
    public String pnrDate;
    //证联支付发给基金的时间戳
    public String pnrTime;
    //证联支付的流水号
    public String pnrSeqId;
    //应答码
    public String respCode;
    //业务应答描述
    public String respDesc;
    //商户保留域
    public String resv;

    public String msg1;

    public String msg2;

    public String getInstuId() {
        return instuId;
    }

    public void setInstuId(String instuId) {
        this.instuId = instuId;
    }

    public String getMerchantDate() {
        return merchantDate;
    }

    public void setMerchantDate(String merchantDate) {
        this.merchantDate = merchantDate;
    }

    public String getMerchantTime() {
        return merchantTime;
    }

    public void setMerchantTime(String merchantTime) {
        this.merchantTime = merchantTime;
    }

    public String getMerchantSeqId() {
        return merchantSeqId;
    }

    public void setMerchantSeqId(String merchantSeqId) {
        this.merchantSeqId = merchantSeqId;
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

    public String getPnrSeqId() {
        return pnrSeqId;
    }

    public void setPnrSeqId(String pnrSeqId) {
        this.pnrSeqId = pnrSeqId;
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

    public String getResv() {
        return resv;
    }

    public void setResv(String resv) {
        this.resv = resv;
    }

    public String getMsg1() {
        return msg1;
    }

    public void setMsg1(String msg1) {
        this.msg1 = msg1;
    }

    public String getMsg2() {
        return msg2;
    }

    public void setMsg2(String msg2) {
        this.msg2 = msg2;
    }

    @Override
    public String toString() {
        return "SendCodeResponse{" +
                "instuId='" + instuId + '\'' +
                ", merchantDate='" + merchantDate + '\'' +
                ", merchantTime='" + merchantTime + '\'' +
                ", merchantSeqId='" + merchantSeqId + '\'' +
                ", pnrDate='" + pnrDate + '\'' +
                ", pnrTime='" + pnrTime + '\'' +
                ", pnrSeqId='" + pnrSeqId + '\'' +
                ", respCode='" + respCode + '\'' +
                ", respDesc='" + respDesc + '\'' +
                ", resv='" + resv + '\'' +
                ", msg1='" + msg1 + '\'' +
                ", msg2='" + msg2 + '\'' +
                '}';
    }
}
