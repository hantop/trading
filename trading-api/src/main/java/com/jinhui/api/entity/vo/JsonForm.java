package com.jinhui.api.entity.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 与渠道通讯的json表单
 * Created by Administrator on 2018/1/25 0025.
 */
public class JsonForm {

    /**
     * 版本号
     */
    @NotNull(message = "版本号不能为空")
    private String verNum;

    /**
     * 14位，日期时间戳，其格式为yyyyMMddHHmmss
     */
    @NotNull(message = "日期时间戳不能为空")
    @Size(min =14  ,max=14, message = "申请时间格式不正确")
    private String sysDateTime;

    /**
     * 9位，渠道代码，由系统分配的9位定长的唯一代号
     */
    @NotNull(message = "渠道代码不能为空")
    private String chnCode;

    /**
     * 交易类型
     */
//    @NotNull(message = "交易类型不能为空")
    private String transType;

    /**
     * 数字密文包，调用方使用对方公钥加密产生
     */
    @NotNull(message = "数字密文包不能为空")
    private String encMsg;

    /**
     * 数字签名, sysDateTime拼接chnCode,再拼接encMsg,然后生成Md5签名
     */
    @NotNull(message = "数字签名不能为空")
    private String checkValue;


    /**
     * 请求返回码，成功为00,失败99
     */
    private String respCode;

    /**
     * 错误信息
     */
    private String errorMessage;


    public String getVerNum() {
        return verNum;
    }

    public void setVerNum(String verNum) {
        this.verNum = verNum;
    }

    public String getSysDateTime() {
        return sysDateTime;
    }

    public void setSysDateTime(String sysDateTime) {
        this.sysDateTime = sysDateTime;
    }

    public String getChnCode() {
        return chnCode;
    }

    public void setChnCode(String chnCode) {
        this.chnCode = chnCode;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getEncMsg() {
        return encMsg;
    }

    public void setEncMsg(String encMsg) {
        this.encMsg = encMsg;
    }

    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    @Override
    public String toString() {
        return "JsonForm{" +
                "verNum='" + verNum + '\'' +
                ", sysDateTime='" + sysDateTime + '\'' +
                ", chnCode='" + chnCode + '\'' +
                ", transType='" + transType + '\'' +
                ", encMsg='" + encMsg + '\'' +
                ", checkValue='" + checkValue + '\'' +
                ", respCode='" + respCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
