package com.jinhui;

import com.alibaba.fastjson.JSON;
import com.jinhui.api.constants.BusinessCode;

import com.jinhui.api.entity.dto.BindCard;
import com.jinhui.api.entity.dto.ModifyPhone;
import com.jinhui.api.entity.dto.OpenAccount;
import com.jinhui.api.entity.dto.Purchasing;
import com.jinhui.api.entity.vo.JsonForm;
import com.jinhui.api.utils.Md5Utils;
import com.jinhui.api.utils.RSAUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by Administrator on 2018/1/26 0026.
 */
public class DateTest {

    /**
     * 生成申购的接口测试数据
     *
     * @throws Exception
     */
    @Test
    public void test0() throws Exception {

        //生成一个JsonForm的请求类
        JsonForm form = new JsonForm();
        form.setVerNum("1.0");
        form.setTransType("001");
        form.setChnCode("1008");
        form.setSysDateTime("20170126120000");

        Purchasing o = createData(Purchasing.class);
        o.setFundDate("20180126");
        o.setFundTime("20180126120000");

        String string = JSON.toJSONString(o);
        form.setEncMsg(string);
        System.out.println(string);
//        //加密
//        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCRedpkh4+tSziuerUK7OcZrO8ipJ0cBx1Y/Vpbd2Tup+n5C76ZjcxvrbMO5aQB/OPGlR8fkvZzKxLYnTH1I5JkTRNt9Swh+XQvaBM50hTO5+cw/UpbQKZKK5d/HlgzK0BtUJH6JkKMomAxZ+xOgCfEmAPKBCAzxgUUNYzpBl0MXQIDAQAB";
//        byte[] bytes = RSAUtils.encryptByPublicKey(string.getBytes("UTF-8"), publicKey);
//        String base64 = RSAUtils.encryptBASE64(bytes);
//        form.setEncMsg(base64);


        //加签
        StringBuilder sb2 = new StringBuilder();
        sb2.append(form.getChnCode());
        sb2.append(form.getSysDateTime());
        sb2.append(form.getEncMsg());
        String sign = Md5Utils.sign(sb2.toString().getBytes("UTF-8"));
        form.setCheckValue(sign);

        System.out.println(JSON.toJSONString(form));

    }






    /**
     * 生成ModifyPhone的接口测试数据
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {

        //生成一个JsonForm的请求类
        JsonForm form = new JsonForm();
        form.setVerNum("1.0");
        form.setTransType("001");
        form.setChnCode("1008");
        form.setSysDateTime("20170126120000");

        ModifyPhone o = createData(ModifyPhone.class);
        o.setFundDate("20180126");
        o.setFundTime("20180126120000");
        o.setModifyPhoneNo("13530797716");
        String string = JSON.toJSONString(o);
        //加密
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCRedpkh4+tSziuerUK7OcZrO8ipJ0cBx1Y/Vpbd2Tup+n5C76ZjcxvrbMO5aQB/OPGlR8fkvZzKxLYnTH1I5JkTRNt9Swh+XQvaBM50hTO5+cw/UpbQKZKK5d/HlgzK0BtUJH6JkKMomAxZ+xOgCfEmAPKBCAzxgUUNYzpBl0MXQIDAQAB";
        byte[] bytes = RSAUtils.encryptByPublicKey(string.getBytes("UTF-8"), publicKey);
        String base64 = RSAUtils.encryptBASE64(bytes);
        form.setEncMsg(base64);


        //加签
        StringBuilder sb2 = new StringBuilder();
        sb2.append(form.getChnCode());
        sb2.append(form.getSysDateTime());
        sb2.append(form.getEncMsg());
        String sign = Md5Utils.sign(sb2.toString().getBytes("UTF-8"));
        form.setCheckValue(sign);

        System.out.println(JSON.toJSONString(form));

    }


    /**
     * 生成OpenAccount的接口测试数据
     *
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {

        //生成一个JsonForm的请求类
        JsonForm form = new JsonForm();
        form.setVerNum("1.0");
        form.setTransType("001");
        form.setChnCode("1008");
        form.setSysDateTime("20170126120000");

        OpenAccount o = createData(OpenAccount.class);
        o.setFundDate("20180126");
        o.setFundTime("20180126120000");
        o.setSex("1");
        o.setClientRiskRate("1");
        o.setInstReprIDType("0");
        o.setInstReprCertValidDate("20180126");
        String string = JSON.toJSONString(o);
        //加密
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCRedpkh4+tSziuerUK7OcZrO8ipJ0cBx1Y/Vpbd2Tup+n5C76ZjcxvrbMO5aQB/OPGlR8fkvZzKxLYnTH1I5JkTRNt9Swh+XQvaBM50hTO5+cw/UpbQKZKK5d/HlgzK0BtUJH6JkKMomAxZ+xOgCfEmAPKBCAzxgUUNYzpBl0MXQIDAQAB";
        byte[] bytes = RSAUtils.encryptByPublicKey(string.getBytes("UTF-8"), publicKey);
        String base64 = RSAUtils.encryptBASE64(bytes);
        form.setEncMsg(base64);


        //加签
        StringBuilder sb2 = new StringBuilder();
        sb2.append(form.getChnCode());
        sb2.append(form.getSysDateTime());
        sb2.append(form.getEncMsg());
        String sign = Md5Utils.sign(sb2.toString().getBytes("UTF-8"));
        form.setCheckValue(sign);


        System.out.println(JSON.toJSONString(form));

    }




    /**
     * 生成BindCard的接口测试数据
     *
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {

        //生成一个JsonForm的请求类
        JsonForm form = new JsonForm();
        form.setVerNum("1.0");
        form.setTransType("001");
        form.setChnCode("1008");
        form.setSysDateTime("20170126120000");

        BindCard o = createData(BindCard.class);
        o.setFundDate("20180126");
        o.setFundTime("20180126120000");
        o.setCardNo("abc123123123");
        o.setBusinessCode(BusinessCode.ADD_BANK_CARD);
        String string = JSON.toJSONString(o);
        //加密
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCRedpkh4+tSziuerUK7OcZrO8ipJ0cBx1Y/Vpbd2Tup+n5C76ZjcxvrbMO5aQB/OPGlR8fkvZzKxLYnTH1I5JkTRNt9Swh+XQvaBM50hTO5+cw/UpbQKZKK5d/HlgzK0BtUJH6JkKMomAxZ+xOgCfEmAPKBCAzxgUUNYzpBl0MXQIDAQAB";
        byte[] bytes = RSAUtils.encryptByPublicKey(string.getBytes("UTF-8"), publicKey);
        String base64 = RSAUtils.encryptBASE64(bytes);
        form.setEncMsg(base64);


        //加签
        StringBuilder sb2 = new StringBuilder();
        sb2.append(form.getChnCode());
        sb2.append(form.getSysDateTime());
        sb2.append(form.getEncMsg());
        sb2.append("12345678");
        String sign = Md5Utils.sign(sb2.toString().getBytes("UTF-8"));
        form.setCheckValue(sign);

        System.out.println(JSON.toJSONString(form));

    }



    //对一个class对象，自动set数据进去
    private <T> T createData(Class clazz) throws Exception {

        Object o = clazz.newInstance();

        Field[] fieldsArr = clazz.getDeclaredFields();
        for (Field field : fieldsArr) {
            Class<?> type = field.getType();
            String methodName = initSetMethod(field.getName());
            Method method = clazz.getMethod(methodName, type);
            loadValue(method, o, type);
        }
        return (T) o;

    }


    private <T> T createMethods(Class clazz) throws Exception {

        Object o = clazz.newInstance();

        Field[] fieldsArr = clazz.getDeclaredFields();
        for (Field field : fieldsArr) {

            String methodName = initSetMethod(field.getName());
            System.out.println("o." + methodName + "();");

        }
        return (T) o;

    }


    private String initSetMethod(String field) {
        return "set" + field.substring(0, 1).toUpperCase() + field.substring(1);
    }


    /**
     * 注入属性值,先构造set与get方法，再通过反射调用
     */
    private <T> void loadValue(Method method, T instance, Class type) throws InvocationTargetException, IllegalAccessException, ParseException {


        if (type == String.class) {

            method.invoke(instance, "abcd");
        } else if (type == int.class || type == Integer.class) {
            method.invoke(instance, Integer.parseInt("1"));

        } else if (type == long.class || type == Long.class) {
            method.invoke(instance, Long.parseLong("100"));

        } else if (type == float.class || type == Float.class) {
            method.invoke(instance, Float.parseFloat("0.01"));

        } else if (type == double.class || type == Double.class) {
            method.invoke(instance, Double.parseDouble("0.01"));

        } else if (type == Date.class) {

            method.invoke(instance, new Date());
        } else if (type == BigDecimal.class) {

            method.invoke(instance, new BigDecimal("100"));
        } else if (type == Object.class) {
            method.invoke(instance, null);
        }

    }

}
