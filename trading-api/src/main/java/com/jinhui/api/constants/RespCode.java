package com.jinhui.api.constants;


public class RespCode {

    /**
     * 接口的成功或失败返回码
     */
    public final static String SUCCESS = "00";//接口返回成功

    public final static String ERROR = "99";//接口返回失败


    /**
     * 交易应答码
     */
    public final static String USER_NO_EXIST = "1001";//用户不存在

    public final static String CARD_NO_EXIST = "1002";//卡号不存在

    public final static String CARD_IS_BIND = "1003";//卡已经被绑定过

    public final static String USER_IS_OPEN_ACCOUNT = "1004";//用户已经在该渠道开过户

    public final static String CARD_NOT_UNBIND = "1005";//不能被解绑

    public final static String TRANS_SUCCESS  = "RC00";// 交易处理成功

    public final static String TRANS_FAIL  = "RC01";// 交易处理失败

    public final static String SYSTEM_ERROR="F099";//系统错误



}
