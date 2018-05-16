package com.jinhui.api.controller;

import com.jinhui.api.constants.RespCode;
import com.jinhui.api.entity.dto.Purchasing;
import com.jinhui.api.entity.dto.QueryLimit;
import com.jinhui.api.entity.dto.Redeeming;
import com.jinhui.api.entity.dto.ShortMessage;
import com.jinhui.api.entity.vo.JsonForm;
import com.jinhui.api.mapper.trade.ChnProductDao;
import com.jinhui.api.service.trans.PurchaseService;
import com.jinhui.api.service.trans.RedeemService;
import com.jinhui.api.service.trans.ShortMsgService;
import com.jinhui.api.service.trans.TransLimitService;
import com.jinhui.api.task.SynPositionTask;
import com.jinhui.common.utils.RedisUtils;
import com.jinhui.common.utils.validator.ValidatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/2/6 0006.
 */
@RestController
@RequestMapping("/transtest")
public class TransTest {

    private static Logger logger = LoggerFactory.getLogger(TransTest.class);


    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private RedeemService redeemService;

    @Autowired
    private ChnProductDao chnProductDao;

    @Autowired
    private TransLimitService transLimitService;


    @Autowired
    private ShortMsgService shortMsgService;

    @Autowired
    private SynPositionTask synPositionTask;

    /**
     * 实时交易额度信息查询
     */
    @PostMapping("queryTransLimit")
    QueryLimit queryTransLimit(@RequestBody QueryLimit form) throws Exception {
        ValidatorUtils.validateEntity(form);


        //两次请求在30秒内，取缓存的数据
        StringBuilder sb = new StringBuilder();
        sb.append(form.getChannelUserId());
        sb.append(form.getChannelCode());
        sb.append(form.getProductCode());
        String cacheKey = sb.toString();
        QueryLimit cache = RedisUtils.get(cacheKey, QueryLimit.class,10);
        if (cache != null) {
            logger.info("实时交易额度信息取自缓存:{}", cache);
            return cache;
        }

        QueryLimit returnQueryLimit = transLimitService.queryTransLimit(form);


        //把结果缓存起来,10秒
        RedisUtils.set(cacheKey, returnQueryLimit,10);

        return returnQueryLimit;


    }

    /**
     * 申购活期产品
     */
    @PostMapping("purchasingFunds")
    Purchasing purchasingFunds(@RequestBody Purchasing form) throws Exception {
        ValidatorUtils.validateEntity(form);
        Purchasing returnPurchasing = purchaseService.purchaseFunds(form);
        return returnPurchasing;

    }


    /**
     * 赎回活期产品
     */
    @PostMapping("redeemingFunds")
    Redeeming redeemingFunds(@RequestBody Redeeming form) throws Exception {
        ValidatorUtils.validateEntity(form);
        Redeeming returnRedeeming = redeemService.redeemFunds(form);
        return returnRedeeming;

    }


    /**
     * 发送短信
     */
    @PostMapping("sendCode")
    ShortMessage sendCode(@RequestBody ShortMessage shortMessage) throws Exception {
        ValidatorUtils.validateEntity(shortMessage);
        ShortMessage sendCode = shortMsgService.sendCode(shortMessage);
        return sendCode;

    }


    /**
     * 同步持仓
     */
    @PostMapping("synPosition")
    String  synPosition() throws Exception {

        synPositionTask.SynPositionTask();

        return "同步成功";

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
