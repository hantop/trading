package com.jinhui.zlrt.utils;

import com.jinhui.zlrt.entity.dto.*;
import com.zlink.zlpay.commonofs.common.ZlpayUtil;
import com.zlink.zlpay.commonofs.common.exception.MsgException;
import com.zlink.zlpay.commonofs.common.util.Constants;
import demo.util.HttpRequestParam;
import demo.util.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContext;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 与证联http交互帮助类
 *
 * @autor wsc
 * @create 2018-01-31 14:28
 **/
@Component
public class ZlrtHttpUtils {
    private static Logger logger = LoggerFactory.getLogger(ZlrtHttpUtils.class);

    private static String root = RequestContext.class.getResource("/").getFile();
    private static String cerPath = root + "cert/zlzf_uat.cer";
    private static String pfxPath = root + "cert/通用商户私钥.pfx";
    private static String INSTU_ID;
    private static String keyPwd;
    private static String ZLRT_API_BACK_URI;

    @Value("${INSTU_ID}")
    public void setInstuId(String instuId) {
        INSTU_ID = instuId;
    }
    @Value("${keyPwd}")
    public void setKeyPwd(String keypwd) {
        keyPwd = keypwd;
    }
    //后台表单方式URL
    @Value("${ZLRT_API_BACK_URI}")
    public void setZlrtApiBackUri(String zlrtApiBackUri) {
        ZLRT_API_BACK_URI = zlrtApiBackUri;
    }

    public static String getKeyPwd() {
        return keyPwd;
    }

    //开户接口后缀
    private static String OPEN_ACCOUNT_BACK_URL = "/fundofs/bg/marginRegisterReq";
    //新增银行卡接口后缀
    private static String ADD_BANK_BACK_URL = "/fundofs/bg/marginNewCardReq";
    //取消银行卡接口后缀
    private static String CANCEL_BANK_BACK_URL = "/fundofs/bg/deletecard";
    //修改手机号接口后缀
    private static final String CHANGE_MOBILE_BACK_URL = "/fundofs/bg/modifymobile";
    //后台申购接口后缀
    private static final String PURCHASE_BACK_URL = "/fundofs/bg/subscribeback";
    //交易查询接口后缀
    private static final String TRADE_STATUS_SEARCH_BACK_URL = "/fundofs/bg/transactionstatus";

    //发送短信验证码接口后缀
    private static final String SEND_CODE_BACK_URL = "/fundofs/bg/sendMarginSms";

    private static String generateData(Object obj)  throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        String data = "";
        for(Field field:fields){
            String name = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            String type = field.getGenericType().toString();    //获取属性的类型
            String value = "";
            if (type.equals("class java.lang.String")) {
                Method m = obj.getClass().getMethod("get" + name);
                value = (String) m.invoke(obj);
            }
            if(value != null && !"".equals(value)){
                data = data + field.getName() + "="+value + "|";
            }
        }
        logger.info(data);
        return data;
    }

    private static Object generateObj(String msg,Object obj) throws IllegalAccessException {
        String[] params = msg.split("\\|");
        Field[] fields = obj.getClass().getDeclaredFields();
        for(String param:params){
            for(Field field:fields) {
                String type = field.getGenericType().toString();    //获取属性的类型
                if(param.contains(field.getName())){
                    if (type.equals("class java.lang.String")) {
                        field.set(obj,param.substring(param.indexOf("=")+1,param.length()));
                    }else if(type.equals("class java.math.BigDecimal")){
                        field.set(obj,new BigDecimal(param.substring(param.indexOf("=")+1,param.length())));
                    }
                }
            }
        }
        return obj;
    }

    private static String sendMsg(String instuId, String transType,
                                  String encMsg, String checkValue, String sendUrl) throws MsgException {
        try {
            List<HttpRequestParam> params = bulidParam(instuId, transType,  URLEncoder.encode(encMsg,"UTF-8"), URLEncoder.encode(checkValue,"UTF-8"));
            HttpUtils http = new HttpUtils();
            http.openConnection();
            String responseMsg = http.executeHttpPost(sendUrl, params, Constants.ENCODING);
            http.closeConnection();
            if("".equals(responseMsg)||responseMsg == null){
                throw new MsgException(Constants.ERROR_SENDFAIL);
            }
            return responseMsg;
        } catch (Exception e){
            throw new MsgException(e.getMessage());
        }
    }
    /**
     * @description 组装发送参数
     * @param instuId
     * @param transType
     * @param encMsg
     * @param checkValue
     * @return
     * @author ZhangDM(Mingly)
     * @date 2012-10-21
     */
    private static List<HttpRequestParam> bulidParam(String instuId, String transType,
                                                     String encMsg, String checkValue){

        HttpRequestParam verNumParam = new HttpRequestParam();
        verNumParam.setParaName(Constants.VERNUM);
        verNumParam.setParaValue(Constants.VERNUM_VALUE);
        HttpRequestParam sysDateTimeParam = new HttpRequestParam();
        sysDateTimeParam.setParaName(Constants.SYSDATETIME);
        sysDateTimeParam.setParaValue(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        HttpRequestParam instuIdParam = new HttpRequestParam();
        instuIdParam.setParaName(Constants.INSTUID);
        instuIdParam.setParaValue(instuId);
        HttpRequestParam transTypeParam = new HttpRequestParam();
        transTypeParam.setParaName(Constants.TRANSTYPE);
        transTypeParam.setParaValue(transType);
        HttpRequestParam encMsgParam = new HttpRequestParam();
        encMsgParam.setParaName(Constants.ENCMSG);
        encMsgParam.setParaValue(encMsg);
        HttpRequestParam checkValueParam = new HttpRequestParam();
        checkValueParam.setParaName(Constants.CHECKVALUE);
        checkValueParam.setParaValue(checkValue);

        List<HttpRequestParam> params=new ArrayList<HttpRequestParam>();
        params.add(verNumParam);
        params.add(sysDateTimeParam);
        params.add(instuIdParam);
        params.add(transTypeParam);
        params.add(encMsgParam);
        params.add(checkValueParam);

        return params;
    }

    private static String responseMsg(Object obj,String transType,String url) throws Exception{
        logger.info(ZLRT_API_BACK_URI + url);
        logger.info(cerPath);
        String responseMsg = sendMsg(INSTU_ID, transType,
                ZlpayUtil.encryptData(generateData(obj), cerPath),
                ZlpayUtil.signData(generateData(obj), pfxPath, keyPwd),
                ZLRT_API_BACK_URI + url);
        logger.info("证联返回： " + responseMsg);
        return ZlpayUtil.parseResponse(responseMsg, cerPath, pfxPath, keyPwd);
    }

    public static SendCodeResponse sendCode(SendCodeRequest sendCodeRequest) throws Exception {
        String msg = responseMsg(sendCodeRequest,"2305", SEND_CODE_BACK_URL);
        return (SendCodeResponse) generateObj(msg,new SendCodeResponse());
    }

    //开户
    public static OpenAccountResponse openAccount(OpenAccountRequest openAccountRequest) throws Exception {
        String msg = responseMsg(openAccountRequest,"108", OPEN_ACCOUNT_BACK_URL);
        return (OpenAccountResponse) generateObj(msg,new OpenAccountResponse());
    }
    //添加银行卡
    public static AddBankCardResponse addBankCard(AddBankCardRequest addBankCardRequest) throws Exception {
        String msg = responseMsg(addBankCardRequest,"109", ADD_BANK_BACK_URL);
        return (AddBankCardResponse) generateObj(msg,new AddBankCardResponse());
    }
    //取消银行卡
    public static CancelBankCardResponse cancelBankCard(CancelBankCardRequest cancelBankCardRequest) throws Exception {
        String msg = responseMsg(cancelBankCardRequest,"103", CANCEL_BANK_BACK_URL);
        return (CancelBankCardResponse) generateObj(msg,new CancelBankCardResponse());
    }
    //修改手机号
    public static ChangeMobileNoResponse changeMobileNo(ChangeMobileNoRequest changeMobileNoRequest) throws Exception {
        String msg = responseMsg(changeMobileNoRequest,"117", CHANGE_MOBILE_BACK_URL);
        return (ChangeMobileNoResponse) generateObj(msg,new ChangeMobileNoResponse());
    }
    //后台申购
    public static PurchaseResponse purchase(PurchaseRequest purchaseRequest) throws Exception {
        String msg = responseMsg(purchaseRequest,"302", PURCHASE_BACK_URL);
        return (PurchaseResponse) generateObj(msg,new PurchaseResponse());
    }
    //交易状态查询
    public static TradeStatusSearchResponse tradeStatusSeach(TradeStatusSearchRequest tradeStatusSearchRequest) throws Exception {
        String msg = responseMsg(tradeStatusSearchRequest,"501", TRADE_STATUS_SEARCH_BACK_URL);
        return (TradeStatusSearchResponse)generateObj(msg,new TradeStatusSearchResponse());
    }



    public static void main(String[] args) throws IOException {
        /*OpenAccountRequest openAccount = new OpenAccountRequest();
        openAccount.setInstuId("B00000603");
        openAccount.setFundDate("20180226");
        openAccount.setFundTime("163801");
        openAccount.setFundSeqId("7013333330303356");
        openAccount.setCounterNo("001");
        openAccount.setCustType("0");
        openAccount.setUserNameText("测试用户");
        openAccount.setCertType("00");
        openAccount.setCertId("362401199010274819");
        openAccount.setCardNo("6214836552045821");
        openAccount.setBankCode("0308");
        openAccount.setMobile("15820780930");
        openAccount.setIdentifyingCode("925697");
        try {
            System.out.println(ZlrtHttpUtils.openAccount(openAccount).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //CP0000041574

        SendCodeRequest sendCodeRequest = new SendCodeRequest();
        sendCodeRequest.setInstuId("B00000603");
        sendCodeRequest.setMerchantDate("20180226");
        sendCodeRequest.setMerchantTime("163801");
        sendCodeRequest.setMerchantSeqId("7013333330303374");
        sendCodeRequest.setTradeType("01");
        sendCodeRequest.setUserNameText("测试用户");
        sendCodeRequest.setCertType("00");
        sendCodeRequest.setCertId("362401199010274819");
        sendCodeRequest.setMobile("15820780930");
        sendCodeRequest.setBankCode("0308");
        sendCodeRequest.setCardNo("6214836552045821");

        sendCodeRequest.setUserId("CP0000041574");
        sendCodeRequest.setAmt("60050");
        try {
            System.out.println(ZlrtHttpUtils.sendCode(sendCodeRequest).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


       /* AddBankCardRequest addBankCardRequest = new AddBankCardRequest();
        addBankCardRequest.setInstuId("B00000603");
        addBankCardRequest.setFundDate("20180226");
        addBankCardRequest.setFundTime("163801");
        addBankCardRequest.setFundSeqId("7013333330303370");
        addBankCardRequest.setUserId("CP0000041574");
        addBankCardRequest.setCustType("0");
        addBankCardRequest.setUserNameText("测试用户");
        addBankCardRequest.setCertType("00");
        addBankCardRequest.setCertId("362401199010274819");
        addBankCardRequest.setCardNo("6214836552045823");
        addBankCardRequest.setBankCode("0308");
        addBankCardRequest.setPhoneNo("15820780930");
        addBankCardRequest.setIdentifyingCode("000603");
        try {
            System.out.println(ZlrtHttpUtils.addBankCard(addBankCardRequest).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequest.setInstuId("B00000603");
        purchaseRequest.setFundDate("20180228");
        purchaseRequest.setFundTime("163801");
        purchaseRequest.setFundSeqId("7013333330303377");
        purchaseRequest.setUserId("CP0000041574");
        purchaseRequest.setUserNameText("测试用户");
        purchaseRequest.setCertType("00");
        purchaseRequest.setCertId("362401199010274819");
        purchaseRequest.setCardNo("6214836552045823");
        purchaseRequest.setBankCode("0308");
        purchaseRequest.setFlag("0");
        purchaseRequest.setTransAmt("10000");
        purchaseRequest.setLiqDate("20180228");
        purchaseRequest.setBusiType("0002");
        purchaseRequest.setFundCode("GY0012");
        purchaseRequest.setFundType("10");
       *//* purchaseRequest.setPhoneNo("15820780930");
        purchaseRequest.setIdentifyCode("000603");*//*

        try {
            System.out.println(ZlrtHttpUtils.purchase(purchaseRequest).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*TradeStatusSearchRequest tradeStatusSearchRequest = new TradeStatusSearchRequest();
        tradeStatusSearchRequest.setInstuId("B00000603");
        tradeStatusSearchRequest.setOrgFundDate("20180226");
        tradeStatusSearchRequest.setOrgFundSeqId("7013333330303342");
        tradeStatusSearchRequest.setBusiType("0002");

        try {
            System.out.println(ZlrtHttpUtils.tradeStatusSeach(tradeStatusSearchRequest).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        /*CancelBankCardRequest cancelBankCardRequest = new CancelBankCardRequest();
        cancelBankCardRequest.setInstuId("B00000603");
        cancelBankCardRequest.setFundDate("20180226");
        cancelBankCardRequest.setFundTime("163801");
        cancelBankCardRequest.setFundSeqId("7013333330303388");
        cancelBankCardRequest.setUserId("CP0000041574");
        cancelBankCardRequest.setUserNameText("测试用户");
        cancelBankCardRequest.setCertType("00");
        cancelBankCardRequest.setCertId("362401199010274819");
        cancelBankCardRequest.setCardNo("6214836552045821");
        cancelBankCardRequest.setBankCode("0308");
        try {
            System.out.println(ZlrtHttpUtils.cancelBankCard(cancelBankCardRequest).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        /*ChangeMobileNoRequest changeMobileNoRequest = new ChangeMobileNoRequest();
        changeMobileNoRequest.setInstuId("B00000603");
        changeMobileNoRequest.setFundDate("20180226");
        changeMobileNoRequest.setFundTime("163801");
        changeMobileNoRequest.setFundSeqId("7013333330303356");
        changeMobileNoRequest.setUserId("CP0000041568");
        changeMobileNoRequest.setUserNameText("测试用户");
        changeMobileNoRequest.setCertType("00");
        changeMobileNoRequest.setCertId("362401199010274811");
        changeMobileNoRequest.setPrePhone("15820780888");
        changeMobileNoRequest.setNewPhone("15820780933");
        try {
            System.out.println(ZlrtHttpUtils.changeMobileNo(changeMobileNoRequest).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }*/


    }

}
