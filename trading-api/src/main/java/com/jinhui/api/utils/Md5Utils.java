package com.jinhui.api.utils;

import com.jinhui.common.exception.BizException;
import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;


/**
 * Created by Administrator on 2018/1/25 0025.
 */
public class Md5Utils {


    /**
     * 对数据进行md5签名,返回base64格式字符串
     */
    public static String sign(byte[] data) throws Exception {

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        Base64 base64=new Base64();
        byte[] digest = md5.digest(data);
        return base64.encodeToString(digest);

    }


    /**
     * 对数据验证签名
     */
    public static boolean vedify(byte[] data, String sign) {
        try {
            Base64 base64=new Base64();
            byte[] signDigest = base64.decode(sign);
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(data);
            return md5.isEqual(digest, signDigest);
        } catch (Exception e) {
            throw new BizException("验签失败");
        }

    }


    public static void main(String[] args) throws Exception {

        String message = "hello world!{\n" +
                "  \"address\": \"string\",\n" +
                "  \"bankCode\": \"0308\",\n" +
                "  \"businessCode\": \"002\",\n" +
                "  \"cardNo\": \"6214836552335322\",\n" +
                "  \"certId\": \"362401138010244811\",\n" +
                "  \"certType\": \"00\",\n" +
                "  \"channelCode\": \"1003\",\n" +
                "  \"channelUserId\": \"123456\",\n" +
                "  \"clientRiskRate\": \"1\",\n" +
                "  \"fundDate\": \"20180226\",\n" +
                "  \"fundSeqId\": \"8113343330503342\",\n" +
                "  \"fundTime\": \"20180225183031\",\n" +
                "  \"identifyingCode\": \"000603\",\n" +
                "  \"phoneNo\": \"13530797716\",\n" +
                "  \"sex\": \"1\",\n" +
                "  \"userNameText\": \"测试用户\",\n" +
                "  \"userType\": \"00\"\n" +
                "}{\n" +
                "  \"address\": \"string\",\n" +
                "  \"bankCode\": \"0308\",\n" +
                "  \"businessCode\": \"002\",\n" +
                "  \"cardNo\": \"6214836552335322\",\n" +
                "  \"certId\": \"362401138010244811\",\n" +
                "  \"certType\": \"00\",\n" +
                "  \"channelCode\": \"1003\",\n" +
                "  \"channelUserId\": \"123456\",\n" +
                "  \"clientRiskRate\": \"1\",\n" +
                "  \"fundDate\": \"20180226\",\n" +
                "  \"fundSeqId\": \"8113343330503342\",\n" +
                "  \"fundTime\": \"20180225183031\",\n" +
                "  \"identifyingCode\": \"000603\",\n" +
                "  \"phoneNo\": \"13530797716\",\n" +
                "  \"sex\": \"1\",\n" +
                "  \"userNameText\": \"测试用户\",\n" +
                "  \"userType\": \"00\"\n" +
                "}{\n" +
                "  \"address\": \"string\",\n" +
                "  \"bankCode\": \"0308\",\n" +
                "  \"businessCode\": \"002\",\n" +
                "  \"cardNo\": \"6214836552335322\",\n" +
                "  \"certId\": \"362401138010244811\",\n" +
                "  \"certType\": \"00\",\n" +
                "  \"channelCode\": \"1003\",\n" +
                "  \"channelUserId\": \"123456\",\n" +
                "  \"clientRiskRate\": \"1\",\n" +
                "  \"fundDate\": \"20180226\",\n" +
                "  \"fundSeqId\": \"8113343330503342\",\n" +
                "  \"fundTime\": \"20180225183031\",\n" +
                "  \"identifyingCode\": \"000603\",\n" +
                "  \"phoneNo\": \"13530797716\",\n" +
                "  \"sex\": \"1\",\n" +
                "  \"userNameText\": \"测试用户\",\n" +
                "  \"userType\": \"00\"\n" +
                "}";
        String sign = sign(message.getBytes("UTF-8"));
        boolean vedify = vedify(message.getBytes("UTF-8"), sign);
        System.out.println(sign);

    }


}
