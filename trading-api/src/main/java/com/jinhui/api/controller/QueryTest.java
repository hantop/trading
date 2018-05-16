package com.jinhui.api.controller;

import com.alibaba.fastjson.JSON;
import com.jinhui.api.annotation.SignAndEncrypt;
import com.jinhui.api.constants.RespCode;
import com.jinhui.api.entity.dto.*;
import com.jinhui.api.entity.vo.JsonForm;
import com.jinhui.api.service.query.QueryService;
import com.jinhui.common.utils.validator.ValidatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2018/2/6 0006.
 */

@RestController
@RequestMapping("/querytest")
public class QueryTest {

    private static Logger logger = LoggerFactory.getLogger(QueryTest.class);

    @Autowired
    private QueryService queryService;

    /**
     * 查询用户全部银行卡
     */
    @PostMapping("queryCards")
    List<QueryCard> queryCards(@RequestBody QueryCard form) throws Exception {
        ValidatorUtils.validateEntity(form);
        List<QueryCard> returnQueryCards = queryService.queryCards(form);
        return returnQueryCards;

    }


    /**
     * 查询用户信息
     */
    @PostMapping("queryUserInfo")
    QueryUser queryUserInfo(@RequestBody QueryUser form) throws Exception {
        ValidatorUtils.validateEntity(form);
        QueryUser returnQueryUser = queryService.queryUserInfo(form);

        return returnQueryUser;

    }

    /**
     * 查询用户的全部交易记录
     * <p>
     * ps:如果后期用户的交易数据多的话，一定要提供另外的接口供渠道按时间查询，或者分页查询。
     */
    @PostMapping("queryAllTrans")
    List<QueryTrans> queryAllTrans(@RequestBody QueryTrans form) throws Exception {
        ValidatorUtils.validateEntity(form);
        List<QueryTrans> returnQueryTranses = queryService.queryAllTrans(form);

        return returnQueryTranses;

    }

    /**
     * 查询用户的当日持仓记录
     */
    @PostMapping("queryUserPosition")
    List<QueryPosition> queryUserPosition(@RequestBody QueryPosition form) throws Exception {
        ValidatorUtils.validateEntity(form);
        List<QueryPosition> returnQueryPositions = queryService.queryUserPosition(form);

        return returnQueryPositions;


    }

    /**
     * 查询用户的全部收益记录
     * <p>
     * ps:如果后期用户的收益数据多的话，一定要提供另外的接口供渠道按时间查询，或者分页查询。
     */
    @PostMapping("queryALLIncome")
    List<QueryIncome> queryALLIncome(@RequestBody QueryIncome form) throws Exception {
        ValidatorUtils.validateEntity(form);
        List<QueryIncome> returnQueryIncomes = queryService.queryALLIncome(form);

        return returnQueryIncomes;

    }

    /**
     * 查询渠道所有产品信息
     */
    @PostMapping("queryAllProduct")
    List<QueryProduct> queryAllProduct(@RequestBody QueryProduct form) throws Exception {
        ValidatorUtils.validateEntity(form);
        List<QueryProduct> returnQueryProducts = queryService.queryAllProduct(form);

        return returnQueryProducts;

    }

    /**
     * 查询渠道用户的资金汇总
     */
    @PostMapping("queryAssetSummary")
    QueryAssetSummary queryAssetSummary(@RequestBody QueryAssetSummary form) throws Exception {
        QueryAssetSummary returnAssetSummary = queryService.queryAssetSummary(form);
        return returnAssetSummary;

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
