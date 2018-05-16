package com.jinhui.test;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * 简单封装Spring Mvc中对Controller测试方法
 * Created by jinhui on 2017/9/11.
 */
public class MvcTest {

    private static MockMvc mvc;

    /**
     * 初始化，放入要测试的控制器
     * @param controller
     */
    public static void init(Object controller) {
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    /**
     * 返回get()方法的构造器
     * @param url
     * @return
     * @throws Exception
     */
    public static MockHttpServletRequestBuilder get(String url) throws Exception {

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get(url);

        return mockHttpServletRequestBuilder;

    }

    /**
     * 返回post()方法的构造器
     * @param url
     * @return
     * @throws Exception
     */
    public static MockHttpServletRequestBuilder post(String url) throws Exception {

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post(url);

        return mockHttpServletRequestBuilder;

    }


    /**
     * 放入构造器，执行
     * @param request
     * @return
     * @throws Exception
     */
    public static Actions perform(RequestBuilder request) throws Exception {

        ResultActions resultActions = mvc.perform(request).andExpect(status().isOk());
        Actions action = new Actions();
        action.setResultActions(resultActions);

        return action;

    }


}
