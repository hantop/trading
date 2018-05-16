package com.jinhui.utils.validator;

import com.jinhui.common.utils.validator.ValidateResult;
import com.jinhui.common.utils.validator.ValidatorUtils;
import org.junit.Test;

/**
 * Created by Administrator on 2018/1/25 0025.
 */
public class ValidatorUtilsTest {




    @Test
    public void test1(){

        Dog dog1 = new Dog();
        dog1.setAge("19");
        dog1.setName("kaka");
        dog1.setBirthDate("20161210");
        ValidateResult result = ValidatorUtils.validate(dog1);

        System.out.println(result);

    }



}