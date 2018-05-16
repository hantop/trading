package com.jinhui.zlrt.service;

/**
 * 从清算系统同步数据到交易系统
 *
 * @autor wsc
 * @create 2018-02-08 10:55
 **/
public interface SyncDataServcie {

    /**
     * 同步产品表数据
     */
    void syncProduct();

    /**
     * 同步渠道产品数据
     */
    void syncChnProduct();

    /**
     * 同步汇总数据
     */
    void syncBussGather();

    /**
     * 同步收益数据
     */
    void syncIncome();

    /**
     * 同步持仓数据
     */
    void syncPosition();

    /**
     * 同步渠道数据
     */
    void syncChnInfo();
    /**
     * 同步交易所数据
     */
    void syncExchangeInfo();
    /**
     * 同步批次数据
     */
    void syncBatchDate();

    /**
     * 同步用户状态和投资人ID字段
     */
    void syncUserState();

    /**
     * 同步交易委托的状态
     */
    void syncTransState();

    void syncAllData();

}
