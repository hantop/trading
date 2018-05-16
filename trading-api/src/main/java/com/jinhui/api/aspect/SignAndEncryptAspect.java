package com.jinhui.api.aspect;

import com.alibaba.fastjson.JSON;
import com.jinhui.api.annotation.SignAndEncrypt;
import com.jinhui.api.entity.vo.JsonForm;
import com.jinhui.api.utils.Md5Utils;
import com.jinhui.api.utils.RSAUtils;
import com.jinhui.common.exception.BizException;
import com.jinhui.common.utils.validator.ValidatorUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * SignAndEncrypt注解的切面处理类
 * 1.对JsonForm验签
 * 2.解密出json字符串，根据注解的encryptClass转成相应对象
 * 3.验证对象的信息是否正确
 * 4.方法执行完后，对JsonForm加密，加签
 */
@Aspect
@Component
public class SignAndEncryptAspect {

    private static Logger logger = LoggerFactory.getLogger(SignAndEncryptAspect.class);

    @Value("${trading-rsa-private-key}")
    private String rsaPrivateKey;

    @Value("${md5salt}")
    private String md5salt;


    @Pointcut("@annotation(com.jinhui.api.annotation.SignAndEncrypt)")
    public void pointCut() {

    }


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        SignAndEncrypt signAndEncrypt = method.getAnnotation(SignAndEncrypt.class);
        //获取注解上的class
        Class clazz = signAndEncrypt.clazz();

        //请求的参数
        Object[] args = point.getArgs();
        JsonForm form = (JsonForm) args[0];//第一个参数

        //验签
        StringBuilder sb = new StringBuilder();
        sb.append(form.getChnCode());
        sb.append(form.getSysDateTime());
        sb.append(form.getEncMsg());
        sb.append(md5salt);

        //验签没通过
        if (!Md5Utils.vedify(sb.toString().getBytes("UTF-8"), form.getCheckValue())) {
            throw new BizException("验签失败");
        }

        //验证form对象
        ValidatorUtils.validateEntity(form);


        //解密后的密文，转换为对象
        String encMsg = form.getEncMsg();
        byte[] bytes = RSAUtils.decryptByPrivateKey(RSAUtils.decryptBASE64(encMsg), rsaPrivateKey);
        Object object = JSON.parseObject(bytes, clazz);


        //验证接口对象
        ValidatorUtils.validateEntity(object);

        form.setEncMsg(JSON.toJSONString(object));

        if (logger.isInfoEnabled()) {
            logger.info("请求的接口信息{}:{}", clazz.getName(), form);
        }

        args[0] = form;//把处理过后的数据再放回去

        /**
         * 执行方法后
         */
        Object result = point.proceed();

        //加密和加签
        JsonForm form1 = (JsonForm) result;

        if (logger.isInfoEnabled()) {
            logger.info("返回的接口信息{}:{}", clazz.getName(), form1);
        }

        String jsonString = form1.getEncMsg();
        String base64 = RSAUtils.encryptBASE64(RSAUtils.encryptByPrivateKey(jsonString.getBytes("UTF-8"), rsaPrivateKey));
        form.setEncMsg(base64);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(form.getChnCode());
        sb2.append(form.getSysDateTime());
        sb2.append(form.getEncMsg());
        sb2.append(md5salt);
        String sign = Md5Utils.sign(sb2.toString().getBytes("UTF-8"));
        form.setCheckValue(sign);
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        if (logger.isInfoEnabled()) {
            logger.info("接口执行时长:{} ms", time);
        }
        return form;
    }


}
