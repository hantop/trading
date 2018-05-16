package com.jinhui.test;


import com.jinhui.api.controller.TransController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;


/**
 * Created by jinhui on 2017/9/11.
 */


@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.jinhui.*.mapper")//扫描Mapper接口
@ComponentScan(basePackages = "com.jinhui.*")//测试类要指定扫描路径才能把其他模块的配置类找出来
@SpringBootApplication
public class TestExample{



    @Before
    public void setUp() throws Exception {
        MvcTest.init(new TransController());
    }


    @Test
    public void Test1() throws Exception {
        MockHttpServletRequestBuilder request = MvcTest.post("/trans/test").param("name", "sam");
        Actions actions = MvcTest.perform(request);
        actions.print();

    }
/*
    @Test
    public void Test2() throws Exception {
        String requestBody = "{\"id\":1, \"name\":\"zhang\"}";
        MockHttpServletRequestBuilder request = MvcTest.get("/hello/world/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody);

        Actions actions = MvcTest.perform(request);
        actions.print();

    }
*/



}
