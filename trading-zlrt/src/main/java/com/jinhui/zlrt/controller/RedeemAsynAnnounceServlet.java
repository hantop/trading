package com.jinhui.zlrt.controller;

import com.jinhui.common.service.HolidayService;
import com.jinhui.zlrt.common.ZlrtTransCodeConstant;
import com.jinhui.zlrt.entity.domain.BatchState;
import com.jinhui.zlrt.entity.dto.AnnounceResponse;
import com.jinhui.zlrt.mapper.trade.BatchStateMapperTrade;
import com.jinhui.zlrt.mapper.trade.TradeFundTransferMapperTrade;
import com.jinhui.zlrt.utils.ZlrtHttpUtils;
import com.zlink.zlpay.commonofs.common.ZlpayUtil;
import com.zlink.zlpay.commonofs.common.exception.MsgException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * 赎回异步回调地址
 * 根据证联的异步通知结果更新 交易-资金划转表 中的pay_status
 *
 * @autor wsc
 * @create 2018-03-08 15:02
 **/
@WebServlet(name="asynAnnounce",urlPatterns={"/asynAnnounce"})
public class RedeemAsynAnnounceServlet extends HttpServlet{
    private static Logger logger = LoggerFactory.getLogger(RedeemAsynAnnounceServlet.class);


    private BatchStateMapperTrade batchStateMapperTrade = null;
    private HolidayService holidayService = null;
    private TradeFundTransferMapperTrade tradeFundTransferMapperTrade = null;

    private static String root = RequestContext.class.getResource("/").getFile();
    private static String cerPath = root + "cert/zlzf_uat.cer";
    private static String pfxPath = root + "cert/通用商户私钥.pfx";

    public void init() throws ServletException {
        super.init();
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        batchStateMapperTrade = (BatchStateMapperTrade) context.getBean("batchStateMapperTrade");
        holidayService = (HolidayService) context.getBean("holidayService");
        tradeFundTransferMapperTrade = (TradeFundTransferMapperTrade) context.getBean("tradeFundTransferMapperTrade");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("POST  ----------------------------------   赎回异步通知接收  ------------------------------------");
        logger.info(req.getContextPath());
        Map<String, String[]> params = req.getParameterMap();
        String queryString = "";
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (int i = 0; i < values.length; i++) {
                String value = values[i];
                queryString += key + "=" + value + "&";
            }
        }
        // 去掉最后一个空格
        queryString = queryString.substring(0, queryString.length() - 1);
        //queryString = "verNum=1.0&sysDateTime=20180312194028&instuId=B00000603&transType=001&encMsg=TUlJQjN3WUpLb1pJaHZjTkFRY0RvSUlCMERDQ0Fjd0NBUUl4Z2dFd01JSUJMQUlCQW9BVTVGUWhab0lKaGU0LytJZlhuTmxkaEZ1ckE4Y3dEUVlKS29aSWh2Y05BUUVCQlFBRWdnRUFTR2plQmIwS2s4TUN2T3A0WDZ5YlB5TzRHTzdvbzBlZUdSOVJyNlJmdldLUnJScnpGa0ZheHZFU0p6c3FZY3hLYlBkRlg2TzlCbUhKeFZpbmVtZ3R0dmYrZlF2eVQ4eURsbjVnWEc3TXdyN3dOWUFoQjFhTkIxMjRRRUdJZ1E5U2Q3YTNUdFM5Z3lsZGx5SndxNCsvaTZZMjNMUytST1lFMDFOZk41MC9hQzF5cFgzUFRoeEh5bUE5SjlWZ2VIVUNBOGZaY0FCaFMwQTFabTMwUzFVRmVVTElwZFBLcUI5Q2lqQzd1cFNhditpSERBbHRaZjRualo0bTVzUEJUYnZ1STMzL1hjdHlBSHNHUjhVQUhRN3drTkI2Y1JGblVmYUszYk51Qk0vaXN2QXBtdVZTWC9kdVMzaUFjUmFZa2FpekRqMEtzbnl4ODRoVnA0Y0V4ektadERDQmtnWUpLb1pJaHZjTkFRY0JNQXdHQ0NxR1NJYjNEUU1FQlFDQWQyQVA4K0k2TTJucHEyQXpxajBKcUNJTW4rQ0RoRTJ5UVRyQ1laWkxnOHp1eVFkYlZPUHFmVEduNG5qZFYxcUp2Sk5qeTZtWUd5c0Z2Mkl5ZGQwbzhQY1FtSmtyeEpmY2FkL3h5amRkNzFVZ3ZHazM5TlZLSnVNOGZnR3hIQzJ4YTBNQjZZa1N2dHVmL1A4K3I2cHZGcTc1b3pBY0xnSjA=&checkValue=Yk9JY25LU1RvZDJvSGxBNnlHakVhK2NsU3JjUkttTG83ampDdkR4MDh5QmJpdnNvcVZ3VncxYkpxSnFmVlFOeFJVZ2QrcmdONkxqcDFlY0I0RU5GQXdYUCtVQ0Fia0xvditzUkw1MlZ6aXlSamZ5OTBsNHFQWFVjb3FxMXpuV1pNOXNnQjRFdWZSbGpxQmZtak1rMFNndzFWSW5yblRxMmVRbkRNNVQyQk5qRFU5NUErZWcxTXVqRTFrK3hhRXY3VmE4bFBFZ2U2UHFpV3dnemxkRUxKakNEbWZKUk1za2EzWHpQcFd5cVhpOGhoRGpmbEIyM2JkRStCYS9lWDNUMW5JOWtvV0tZVzM4Snk3ZDgyMVFITXhMMVdWcTEyaTBFQTdmTm5zWmVxYWpIUW1JWGIwOWt4Z1BBV21KZDFCNGtqaTI3RGd1THRzVjY5dkpLUWRCRVpBPT0=";
        logger.info("POST " + req.getRequestURL() + " " + queryString);
        String encMsg = choiceData(queryString,queryString.indexOf("&encMsg=")+"&encMsg=".length(),queryString.indexOf("&checkValue="));
        String checkValue = choiceData(queryString,queryString.indexOf("&checkValue=")+"&checkValue=".length(),queryString.length());
        try {
            logger.info(cerPath);
            logger.info(pfxPath);
            logger.info(ZlrtHttpUtils.getKeyPwd());
            AnnounceResponse announceResponse = (AnnounceResponse)generateObj(ZlpayUtil.parseResponse(checkValue,encMsg, cerPath, pfxPath, ZlrtHttpUtils.getKeyPwd()),new AnnounceResponse());
            logger.info(announceResponse.toString());
            BatchState batchState = batchStateMapperTrade.findNewest();
            String batchDate = new SimpleDateFormat("yyyyMMdd").format(batchState.getDate());
            String preDate = holidayService.getPreWorkDay(batchDate);
            logger.info("起始日： " + preDate + "   结束日： "+batchDate);
            if(ZlrtTransCodeConstant.SUCCESS_CODE.equals(announceResponse.getRespCode())){
                //将当天批次的赎回状态改为0 成功
                tradeFundTransferMapperTrade.updateStatusToSucc(preDate,batchDate);
            }else{
                //将当天批次的赎回状态改为1 失败
                tradeFundTransferMapperTrade.updateStatusToFail(preDate,batchDate);
            }

        } catch (IllegalAccessException e) {
            logger.info(e.getMessage());
        } catch (MsgException e) {
            logger.info(e.getMessage());
        }
        logger.info("POST  ----------------------------------   赎回异步通知结束  ------------------------------------");

    }

    private static String choiceData(String queryString, int start, int end){
         return queryString.substring(start,end);
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

   /* public static void main(String[] args) {
        String str = "verNum=1.0&sysDateTime=20180312194028&instuId=B00000603&transType=001&encMsg=TUlJQjN3WUpLb1pJaHZjTkFRY0RvSUlCMERDQ0Fjd0NBUUl4Z2dFd01JSUJMQUlCQW9BVTVGUWhab0lKaGU0LytJZlhuTmxkaEZ1ckE4Y3dEUVlKS29aSWh2Y05BUUVCQlFBRWdnRUFTR2plQmIwS2s4TUN2T3A0WDZ5YlB5TzRHTzdvbzBlZUdSOVJyNlJmdldLUnJScnpGa0ZheHZFU0p6c3FZY3hLYlBkRlg2TzlCbUhKeFZpbmVtZ3R0dmYrZlF2eVQ4eURsbjVnWEc3TXdyN3dOWUFoQjFhTkIxMjRRRUdJZ1E5U2Q3YTNUdFM5Z3lsZGx5SndxNCsvaTZZMjNMUytST1lFMDFOZk41MC9hQzF5cFgzUFRoeEh5bUE5SjlWZ2VIVUNBOGZaY0FCaFMwQTFabTMwUzFVRmVVTElwZFBLcUI5Q2lqQzd1cFNhditpSERBbHRaZjRualo0bTVzUEJUYnZ1STMzL1hjdHlBSHNHUjhVQUhRN3drTkI2Y1JGblVmYUszYk51Qk0vaXN2QXBtdVZTWC9kdVMzaUFjUmFZa2FpekRqMEtzbnl4ODRoVnA0Y0V4ektadERDQmtnWUpLb1pJaHZjTkFRY0JNQXdHQ0NxR1NJYjNEUU1FQlFDQWQyQVA4K0k2TTJucHEyQXpxajBKcUNJTW4rQ0RoRTJ5UVRyQ1laWkxnOHp1eVFkYlZPUHFmVEduNG5qZFYxcUp2Sk5qeTZtWUd5c0Z2Mkl5ZGQwbzhQY1FtSmtyeEpmY2FkL3h5amRkNzFVZ3ZHazM5TlZLSnVNOGZnR3hIQzJ4YTBNQjZZa1N2dHVmL1A4K3I2cHZGcTc1b3pBY0xnSjA=&checkValue=Yk9JY25LU1RvZDJvSGxBNnlHakVhK2NsU3JjUkttTG83ampDdkR4MDh5QmJpdnNvcVZ3VncxYkpxSnFmVlFOeFJVZ2QrcmdONkxqcDFlY0I0RU5GQXdYUCtVQ0Fia0xvditzUkw1MlZ6aXlSamZ5OTBsNHFQWFVjb3FxMXpuV1pNOXNnQjRFdWZSbGpxQmZtak1rMFNndzFWSW5yblRxMmVRbkRNNVQyQk5qRFU5NUErZWcxTXVqRTFrK3hhRXY3VmE4bFBFZ2U2UHFpV3dnemxkRUxKakNEbWZKUk1za2EzWHpQcFd5cVhpOGhoRGpmbEIyM2JkRStCYS9lWDNUMW5JOWtvV0tZVzM4Snk3ZDgyMVFITXhMMVdWcTEyaTBFQTdmTm5zWmVxYWpIUW1JWGIwOWt4Z1BBV21KZDFCNGtqaTI3RGd1THRzVjY5dkpLUWRCRVpBPT0=";
        System.out.println(choiceData(str,str.indexOf("&encMsg=")+"&encMsg=".length(),str.indexOf("&checkValue=")));
        System.out.println(choiceData(str,str.indexOf("&checkValue=")+"&checkValue=".length(),str.length()));
    }*/
}
