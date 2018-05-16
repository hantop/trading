package com.jinhui.api.constants;

/**
 * 交易平台的证件类型枚举类(和清算平台保持一致)
 * <p>
 * Created by Administrator on 2018/2/28 0028.
 */
public enum IDType {

    identity_card("身份证", "00", "00"),
    passport("护照", "01", "01"),
    officers_cert("军官证", "02", "02"),
    soldiers_cert("士兵证", "03", "03"),
    hk_pass("港澳通行证", "04", "07"),
    household_Register("户口本", "05", "05"),
    foreign_passport("外国护照", "06", "06"),
    other("其他", "07", "07"),
    civilian_cadres_card("文职证", "08", "10"),
    police_card("警官证", "09", "09"),
    taiwan_card("台胞证", "0A", "07"),
    organization_code("组织机构代码证", "10", "61"),
    business_license("营业执照", "11", "62"),
    foundation_card("基金会", "17", "07"),
    unified_social_credit_code("统一社会信用代码", "19", "65");

    private String name;
    private String code;//交易后台定义的证件类型
    private String zlrtCode;//对应证联支付的证件类型


    /**
     * 根据交易后台定义的证件类型，得到对应证联支付的证件类型
     */
    public static String transform(String code) {
        IDType[] values = IDType.values();
        for (IDType value : values) {
            if (value.getCode().equals(code)) {
                return value.getZlrtCode();
            }
        }
        throw new RuntimeException("不支持的证件类型");
    }


    IDType(String name, String code, String zlrtCode) {
        this.name = name;
        this.code = code;
        this.zlrtCode = zlrtCode;
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

    public String getZlrtCode() {
        return zlrtCode;
    }

    public void setZlrtCode(String zlrtCode) {
        this.zlrtCode = zlrtCode;
    }

    @Override
    public String toString() {
        return "IDType{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", zlrtCode='" + zlrtCode + '\'' +
                '}';
    }
}
