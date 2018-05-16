package com.jinhui.api.controller.test;

import com.jinhui.api.entity.po.TestUser;
import com.jinhui.api.mapper.trade.TestUserDao;
import com.jinhui.api.utils.SMSender;
import com.jinhui.common.exception.BizException;
import com.jinhui.common.service.HolidayService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/1 0001.
 */

@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    private HolidayService holidayService;

    @Autowired
    private TestUserDao testUserDao;

    //注册
    @PostMapping("register")
    Map register(@RequestBody TestUser userInfo) throws Exception {

        testUserDao.insert(userInfo);
        HashMap map = new HashMap();
        map.put("code", "RC00");
        map.put("userInfo", userInfo);
        return map;

    }


    //登录
    @PostMapping("login")
    Map login(@RequestBody TestUser userInfo) throws Exception {

        TestUser testUser = testUserDao.selectByLoginId(userInfo.getLoginId());
        HashMap map = new HashMap();
        map.put("code", "RC00");
        map.put("userInfo", testUser);
        return map;

    }

    //保存
    @PostMapping("update")
    Map save(@RequestBody TestUser userInfo) throws Exception {

        testUserDao.updateByLoginId(userInfo);

        HashMap map = new HashMap();
        map.put("code", "RC00");
        map.put("userInfo", userInfo);
        return map;

    }

    //查询
    @PostMapping("query")
    Map query(@RequestBody TestUser userInfo) throws Exception {

        return login(userInfo);

    }

    //查询“开始计算收益”，T+1日 和“看到收益的日期”T+2 日
    @PostMapping("queryDate")
    Map queryDate() throws Exception {
        String date = testUserDao.queryDate();
        System.out.println("date:" + date);
        HashMap map = new HashMap();
        DateTime dt = DateTime.parse(date, DateTimeFormat.forPattern("yyyy-MM-dd"));
        map.put("code", "RC00");
        map.put("batchDate", dt.toString("yyyy-MM-dd"));
        String nextBatchDate = holidayService.getNextWorkDay(dt.toString("yyyyMMdd"));
        DateTime dt2 = DateTime.parse(nextBatchDate, DateTimeFormat.forPattern("yyyyMMdd"));
        DateTime dt3 = dt2.plusDays(1);
        map.put("nextBatchDate", dt2.toString("yyyy-MM-dd"));
        map.put("nextBatchDate2", dt3.toString("yyyy-MM-dd"));
        return map;

    }

    //发送短信
    @PostMapping("sendMessage")
    Map sendMessage(@RequestBody SendMsg sendMsg) throws Exception {
       /* String mobile = sendMsg.getMobile();
        String type = sendMsg.getType();

        int mobile_code = (int) ((Math.random() * 9 + 1) * 100000);
        String content = null;
        if (type.equals("redeem")) {//赎回
            content = new String("您的验证码为：" + mobile_code + ",此验证码只用于进行招银活宝提现,验证码10分钟内有效");
        }
        if (type.equals("modifyPhone")) {//修改手机号
            content = new String("您的验证码为：" + mobile_code + ",此验证码只用于进行修改手机号,验证码10分钟内有效");
        }
        HashMap map = new HashMap();
        GsmsResponse resp = null;
        SMSender sender = null;
        try {
            sender = new SMSender("jfb@jinhui", "nLpBhs8F", "211.147.239.62", 9080);
            resp = sender.doSendSms(mobile, content);
            if (resp.getResult() == 0) {
                map.put("respCode", "RC00");
                map.put("errorMsg", "验证码发送成功");
            } else {
                map.put("respCode", "RC99");
                map.put("errorMsg", "验证码发送失败");
            }
            return map;
        } catch (Exception e) {
            throw new BizException("验证码发送失败");
        }*/
        return null;
    }


}
