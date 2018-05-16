package com.jinhui.api.constants;

/**
 * Created by Administrator on 2018/1/29 0029.
 */
public enum ChannelCode {

    XINWANG("新网银行","9910","001");


    private String name;
    private String code;
    private String counterNo;//柜台号

    ChannelCode(String name, String code,String counterNo) {
        this.name = name;
        this.code = code;
        this.counterNo=counterNo;
    }

    public static String getCounterNoByCode(String code){
        ChannelCode[] values = ChannelCode.values();
        for (ChannelCode value : values) {
            if( value.getCode().equals(code)){
                return value.getCounterNo();
            }
        }
        throw new RuntimeException("没有该渠道信息");
    }


    public static ChannelCode getChannelCodeByCode(String code){
        ChannelCode[] values = ChannelCode.values();
        for (ChannelCode value : values) {
            if( value.getCode().equals(code)){
                return value;
            }
        }
        throw new RuntimeException("没有该渠道信息");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCounterNo() {
        return counterNo;
    }

    public void setCounterNo(String counterNo) {
        this.counterNo = counterNo;
    }
}
