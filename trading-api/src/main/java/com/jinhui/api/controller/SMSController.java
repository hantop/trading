package com.jinhui.api.controller;

import com.alibaba.fastjson.JSON;
import com.jinhui.api.annotation.SignAndEncrypt;
import com.jinhui.api.constants.RespCode;
import com.jinhui.api.entity.dto.ModifyPhone;
import com.jinhui.api.entity.dto.ShortMessage;
import com.jinhui.api.entity.vo.JsonForm;
import com.jinhui.api.service.trans.ShortMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/2/27 0027.
 */

@RestController
@RequestMapping("/sms")
public class SMSController {

    @Autowired
    private ShortMsgService shortMsgService;

    /**
     * 获取验证码
     */
    @PostMapping("sendCode")
    @SignAndEncrypt(clazz = ShortMessage.class)
    JsonForm modifyPhone(@RequestBody JsonForm form) throws Exception {

        ShortMessage shortMessage = JSON.parseObject(form.getEncMsg(), ShortMessage.class);
        
        ShortMessage returnSendCode = shortMsgService.sendCode(shortMessage);
        form.setEncMsg(JSON.toJSONString(returnSendCode));
        form.setRespCode(RespCode.SUCCESS);

        return form;

    }


}
