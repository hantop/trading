package com.jinhui;

import com.jinhui.api.mapper.trade.UserDao;
import com.jinhui.api.service.trans.PurchaseService;
import com.jinhui.common.service.IdService;
import com.jinhui.common.utils.RedisUtils;
import com.jinhui.zlrt.mapper.trade.ChnProductMapperTrade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 集成测试类
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "com.jinhui.*")//测试类要指定扫描路径才能把其他模块的配置类找出来
@SpringBootApplication
public class RootTest {


    @Autowired
    private UserDao userMapper;

    @Autowired
    private IdService IdService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ChnProductMapperTrade chnProductMapperTrade;



    @Test
    public void test1() {

        RedisUtils.set("123","123666");
        System.out.println(RedisUtils.get("123"));

//        userMapper.selectByChnId("");
//        chnProductMapperTrade.selectChnProduct("");
    }


}