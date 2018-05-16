package com.jinhui.api.controller;

import com.alibaba.fastjson.JSON;
import com.jinhui.api.annotation.SignAndEncrypt;
import com.jinhui.api.constants.BusinessCode;
import com.jinhui.api.constants.RespCode;
import com.jinhui.api.entity.dto.BindCard;
import com.jinhui.api.entity.dto.ModifyPhone;
import com.jinhui.api.entity.dto.OpenAccount;
import com.jinhui.api.entity.vo.JsonForm;
import com.jinhui.api.service.account.BindCardService;
import com.jinhui.api.service.account.ModifyPhoneService;
import com.jinhui.api.service.account.OpenAccountService;
import com.jinhui.common.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/account")
public class AccountController {

    private static Logger logger = LoggerFactory.getLogger(AccountController.class);


    @Value("${trading-rsa-private-key}")
    private String rsaPrivateKey;

    @Autowired
    private OpenAccountService openAccountService;

    @Autowired
    private BindCardService bindCardService;


    @Autowired
    private ModifyPhoneService modifyPhoneService;


    /**
     * 首次开户
     */
    @PostMapping("openAccount")
    @SignAndEncrypt(clazz = OpenAccount.class)
    JsonForm openAccount(@RequestBody JsonForm form) throws Exception {

        OpenAccount openAccount = JSON.parseObject(form.getEncMsg(), OpenAccount.class);
        OpenAccount returnOpenAccount = openAccountService.openAccount(openAccount);
        form.setEncMsg(JSON.toJSONString(returnOpenAccount));
        form.setRespCode(RespCode.SUCCESS);
        return form;

    }

    /**
     * 绑卡，包括新增银行卡和取消银行卡
     */
    @PostMapping("bindCard")
    @SignAndEncrypt(clazz = BindCard.class)
    JsonForm bindCard(@RequestBody JsonForm form) throws Exception {

        BindCard bindCard = JSON.parseObject(form.getEncMsg(), BindCard.class);

        //新增银行卡
        if (bindCard.getBusinessCode().equals(BusinessCode.ADD_BANK_CARD)) {
            BindCard returnBindCard = bindCardService.addCard(bindCard);
            form.setEncMsg(JSON.toJSONString(returnBindCard));
            form.setRespCode(RespCode.SUCCESS);
            return form;
        }

        //取消银行卡
        if (bindCard.getBusinessCode().equals(BusinessCode.CANCEL_BANK_CARD)) {
            BindCard returnBindCard = bindCardService.cancelCard(bindCard);
            form.setEncMsg(JSON.toJSONString(returnBindCard));
            form.setRespCode(RespCode.SUCCESS);
            return form;
        }

        throw new BizException("不支持的业务代码:" + bindCard.getBusinessCode());

    }


    /**
     * 修改客户手机号
     */
    @PostMapping("modifyPhone")
    @SignAndEncrypt(clazz = ModifyPhone.class)
    JsonForm modifyPhone(@RequestBody JsonForm form) throws Exception {

        ModifyPhone modifyPhone = JSON.parseObject(form.getEncMsg(), ModifyPhone.class);
        ModifyPhone returnModifyPhone = modifyPhoneService.modifyPhone(modifyPhone);
        form.setEncMsg(JSON.toJSONString(returnModifyPhone));
        form.setRespCode(RespCode.SUCCESS);
        return form;

    }


    /**
     * 捕获该处理器的所有异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonForm expHandler(Exception e) {
        logger.error("接口异常", e);
        JsonForm form = new JsonForm();
        form.setRespCode(RespCode.ERROR);
        form.setErrorMessage(e.getMessage());
        return form;
    }


}