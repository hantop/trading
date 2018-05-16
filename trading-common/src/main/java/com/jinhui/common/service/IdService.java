package com.jinhui.common.service;

/**
 * 提供ID生成服务
 */
public interface IdService {

    /**
     * 获取18位资金划转流水号
     * @return
     */
    String generateTransferNo();

    /**
     * 生成24位的开户申请单编号
     * @return
     */
    String generateOpenAccountNo();


}
