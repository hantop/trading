package com.jinhui.api.controller;

import com.alibaba.fastjson.JSON;
import com.jinhui.api.annotation.SignAndEncrypt;
import com.jinhui.api.constants.RespCode;
import com.jinhui.api.entity.dto.*;
import com.jinhui.api.entity.vo.JsonForm;
import com.jinhui.api.service.query.QueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2018/2/2 0002.
 */
@RestController
@RequestMapping("/query")
public class QueryController {

    private static Logger logger = LoggerFactory.getLogger(QueryController.class);

    @Autowired
    private QueryService queryService;


    /**
     * 查询用户全部银行卡
     */
    @PostMapping("queryCards")
    @SignAndEncrypt(clazz = QueryCard.class)
    JsonForm queryCards(@RequestBody JsonForm form) throws Exception {

        QueryCard queryCard = JSON.parseObject(form.getEncMsg(), QueryCard.class);
        List<QueryCard> returnQueryCards = queryService.queryCards(queryCard);
        form.setEncMsg(JSON.toJSONString(returnQueryCards));
        form.setRespCode(RespCode.SUCCESS);
        return form;

    }


    /**
     * 查询用户信息
     */
    @PostMapping("queryUserInfo")
    @SignAndEncrypt(clazz = QueryUser.class)
    JsonForm queryUserInfo(@RequestBody JsonForm form) throws Exception {
        QueryUser queryUser = JSON.parseObject(form.getEncMsg(), QueryUser.class);
        QueryUser returnQueryUser = queryService.queryUserInfo(queryUser);
        form.setEncMsg(JSON.toJSONString(returnQueryUser));
        form.setRespCode(RespCode.SUCCESS);
        return form;

    }

    /**
     * 查询用户的全部交易记录
     * <p>
     * ps:如果后期用户的交易数据多的话，一定要提供另外的接口供渠道按时间查询，或者分页查询。
     */
    @PostMapping("queryAllTrans")
    @SignAndEncrypt(clazz = QueryTrans.class)
    JsonForm queryAllTrans(@RequestBody JsonForm form) throws Exception {
        QueryTrans queryTrans = JSON.parseObject(form.getEncMsg(), QueryTrans.class);
        List<QueryTrans> returnQueryTranses = queryService.queryAllTrans(queryTrans);
        form.setEncMsg(JSON.toJSONString(returnQueryTranses));
        form.setRespCode(RespCode.SUCCESS);
        return form;

    }

    /**
     * 查询用户的当日持仓记录
     */
    @PostMapping("queryUserPosition")
    @SignAndEncrypt(clazz = QueryPosition.class)
    JsonForm queryUserPosition(@RequestBody JsonForm form) throws Exception {
        QueryPosition queryPosition = JSON.parseObject(form.getEncMsg(), QueryPosition.class);
        List<QueryPosition> returnQueryPositions = queryService.queryUserPosition(queryPosition);
        form.setEncMsg(JSON.toJSONString(returnQueryPositions));
        form.setRespCode(RespCode.SUCCESS);
        return form;


    }

    /**
     * 查询用户的全部收益记录
     * <p>
     * ps:如果后期用户的收益数据多的话，一定要提供另外的接口供渠道按时间查询，或者分页查询。
     */
    @PostMapping("queryALLIncome")
    @SignAndEncrypt(clazz = QueryIncome.class)
    JsonForm queryALLIncome(@RequestBody JsonForm form) throws Exception {
        QueryIncome queryIncome = JSON.parseObject(form.getEncMsg(), QueryIncome.class);
        List<QueryIncome> returnQueryIncomes = queryService.queryALLIncome(queryIncome);
        form.setEncMsg(JSON.toJSONString(returnQueryIncomes));
        form.setRespCode(RespCode.SUCCESS);
        return form;

    }

    /**
     * 查询渠道所有产品信息
     */
    @PostMapping("queryAllProduct")
    @SignAndEncrypt(clazz = QueryProduct.class)
    JsonForm queryAllProduct(@RequestBody JsonForm form) throws Exception {
        QueryProduct queryProduct = JSON.parseObject(form.getEncMsg(), QueryProduct.class);
        List<QueryProduct> returnQueryProducts = queryService.queryAllProduct(queryProduct);
        form.setEncMsg(JSON.toJSONString(returnQueryProducts));
        form.setRespCode(RespCode.SUCCESS);
        return form;

    }

    /**
     * 查询渠道用户的资金汇总
     */
    @PostMapping("queryAssetSummary")
    @SignAndEncrypt(clazz = QueryAssetSummary.class)
    JsonForm queryAssetSummary(@RequestBody JsonForm form) throws Exception {
        QueryAssetSummary queryAssetSummary = JSON.parseObject(form.getEncMsg(), QueryAssetSummary.class);
        QueryAssetSummary returnAssetSummary = queryService.queryAssetSummary(queryAssetSummary);
        form.setEncMsg(JSON.toJSONString(returnAssetSummary));
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
