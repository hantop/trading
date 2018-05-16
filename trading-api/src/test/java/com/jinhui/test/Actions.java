package com.jinhui.test;


import org.hamcrest.Matchers;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Created by jinhui on 2017/9/11.
 */
public class Actions {

    private ResultActions resultActions;


    /**
     * 打印返回信息
     * @throws Exception
     */
    public void print() throws Exception {

        resultActions.andDo(MockMvcResultHandlers.print());

    }

    /**
     * 验证
     * @param str
     * @throws Exception
     */
    public void equalTo(String str) throws Exception {

        resultActions.andExpect(content().string(Matchers.equalTo(str)));

    }


    /**
     * 返回内容的字符串
     * @return
     * @throws Exception
     */
    public String getContentAsString() throws Exception {

        return resultActions.andReturn().getResponse().getContentAsString();

    }




    public ResultActions getResultActions() {
        return resultActions;
    }

    public void setResultActions(ResultActions resultActions) {
        this.resultActions = resultActions;
    }
}
