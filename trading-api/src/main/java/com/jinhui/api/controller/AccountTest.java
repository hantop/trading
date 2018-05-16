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
import com.jinhui.common.utils.validator.ValidatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/2/6 0006.
 */

@RestController
@RequestMapping("/accounttest")
public class AccountTest {

    private static Logger logger = LoggerFactory.getLogger(AccountTest.class);


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
    OpenAccount openAccount(@RequestBody OpenAccount form) throws Exception {

        ValidatorUtils.validateEntity(form);
        OpenAccount returnOpenAccount = openAccountService.openAccount(form);

        return returnOpenAccount;

    }

    /**
     * 绑卡，包括新增银行卡和取消银行卡
     */
    @PostMapping("bindCard")
    BindCard bindCard(@RequestBody BindCard form) throws Exception {
        ValidatorUtils.validateEntity(form);

        //新增银行卡
        if (form.getBusinessCode().equals(BusinessCode.ADD_BANK_CARD)) {
            BindCard returnBindCard = bindCardService.addCard(form);

            return returnBindCard;
        }

        //取消银行卡
        if (form.getBusinessCode().equals(BusinessCode.CANCEL_BANK_CARD)) {
            BindCard returnBindCard = bindCardService.cancelCard(form);

            return returnBindCard;
        }

        throw new BizException("绑卡业务不支持的业务代码:" + form.getBusinessCode());

    }


    /**
     * 修改客户手机号
     */
    @PostMapping("modifyPhone")
    ModifyPhone modifyPhone(@RequestBody ModifyPhone form) throws Exception {
        ValidatorUtils.validateEntity(form);
        ModifyPhone returnModifyPhone = modifyPhoneService.modifyPhone(form);

        return returnModifyPhone;

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
