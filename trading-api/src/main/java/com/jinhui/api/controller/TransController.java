package com.jinhui.api.controller;

import com.alibaba.fastjson.JSON;
import com.jinhui.api.annotation.SignAndEncrypt;
import com.jinhui.api.constants.RespCode;
import com.jinhui.api.entity.dto.Purchasing;
import com.jinhui.api.entity.dto.QueryLimit;
import com.jinhui.api.entity.dto.QueryProduct;
import com.jinhui.api.entity.dto.Redeeming;
import com.jinhui.api.entity.vo.JsonForm;
import com.jinhui.api.mapper.trade.ChnProductDao;
import com.jinhui.api.service.trans.PurchaseService;
import com.jinhui.api.service.trans.RedeemService;
import com.jinhui.api.service.trans.TransLimitService;
import com.jinhui.common.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/1/29 0029.
 */

@RestController
@RequestMapping("/trans")
public class TransController {

    private static Logger logger = LoggerFactory.getLogger(TransController.class);


    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private RedeemService redeemService;

    @Autowired
    private ChnProductDao chnProductDao;

    @Autowired
    private TransLimitService transLimitService;


    /**
     * 实时交易额度信息查询
     */
    @PostMapping("queryTransLimit")
    @SignAndEncrypt(clazz = QueryLimit.class)
    JsonForm queryTransLimit(@RequestBody JsonForm form) throws Exception {

        QueryLimit queryLimit = JSON.parseObject(form.getEncMsg(), QueryLimit.class);

        //两次请求在30秒内，取缓存的数据
        StringBuilder sb = new StringBuilder();
        sb.append(queryLimit.getChannelUserId());
        sb.append(queryLimit.getChannelCode());
        sb.append(queryLimit.getProductCode());
        String cacheKey = sb.toString();
        JsonForm cache = RedisUtils.get(cacheKey, JsonForm.class);
        if (cache != null) {
            logger.info("实时交易额度信息取自缓存:{}", cache);
            return cache;
        }

        QueryLimit returnQueryLimit = transLimitService.queryTransLimit(queryLimit);
        form.setEncMsg(JSON.toJSONString(returnQueryLimit));
        form.setRespCode(RespCode.SUCCESS);

        //把结果缓存起来,30秒
        RedisUtils.set(cacheKey, form,30);

        return form;


    }

    /**
     * 申购活期产品
     */
    @PostMapping("purchasingFunds")
    @SignAndEncrypt(clazz = Purchasing.class)
    JsonForm purchasingFunds(@RequestBody JsonForm form) throws Exception {

        Purchasing purchasing = JSON.parseObject(form.getEncMsg(), Purchasing.class);

        //检查申购产品是否存在，申购用户是否存在

        Purchasing returnPurchasing = purchaseService.purchaseFunds(purchasing);
        form.setEncMsg(JSON.toJSONString(returnPurchasing));
        form.setRespCode(RespCode.SUCCESS);
        return form;

    }


    /**
     * 赎回活期产品
     */
    @PostMapping("redeemingFunds")
    @SignAndEncrypt(clazz = Redeeming.class)
    JsonForm redeemingFunds(@RequestBody JsonForm form) throws Exception {

        Redeeming redeeming = JSON.parseObject(form.getEncMsg(), Redeeming.class);
        Redeeming returnRedeeming = redeemService.redeemFunds(redeeming);
        form.setEncMsg(JSON.toJSONString(returnRedeeming));
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
