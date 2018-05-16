package com.jinhui.api.service.query;

import com.jinhui.api.entity.dto.*;

import java.util.List;

/**
 * Created by Administrator on 2018/2/2 0002.
 */
public interface QueryService {


    /**
     * 查询用户全部银行卡
     */
    List<QueryCard> queryCards(QueryCard queryCard);


    /**
     * 查询用户信息
     */
    QueryUser queryUserInfo(QueryUser queryUser);


    /**
     * 查询用户的全部产品的交易记录
     */
    List<QueryTrans> queryAllTrans(QueryTrans queryTrans);


    /**
     * 查询用户的全部产品的当日持仓记录
     */
    List<QueryPosition> queryUserPosition(QueryPosition queryPosition);


    /**
     * 查询用户的全部产品的收益记录
     */
    List<QueryIncome> queryALLIncome(QueryIncome queryIncome);


    /**
     * 查询渠道所有产品信息
     */
    List<QueryProduct> queryAllProduct(QueryProduct queryProduct);


    /**
     * 查询用户的资金汇总
     */
    QueryAssetSummary queryAssetSummary(QueryAssetSummary summary);

}
