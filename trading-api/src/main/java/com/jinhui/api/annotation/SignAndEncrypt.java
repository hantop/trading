package com.jinhui.api.annotation;

import java.lang.annotation.*;

/**
 * 对JsonForm类 验签，加密，加签注解
 *  ps:必须要把JsonForm放在第一个参数
 *
 * 1.对JsonForm验签
 * 2.解密出json字符串，根据注解的encryptClass转成相应对象
 * 3.验证对象的信息
 * 4.方法执行完后，对JsonForm加密，加签
 *
 *  具体实现：com.jinhui.api.aspect.SignAndEncryptAspect
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SignAndEncrypt {

    /**
     * 把JsonForm内的密文转为相应的对象
     */
    Class clazz();

}
