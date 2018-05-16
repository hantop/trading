package com.jinhui.zlrt.service;

import java.io.IOException;

/**
 * 生成申请文件（账户申请文件，交易申请文件）
 *
 * @autor wsc
 * @create 2018-02-09 14:30
 **/
public interface GenerateApplyFileService {

    /**
     * 生成索引文件
     */
    void generateIndexFile(String chnCode,String applyDate) throws IOException;

    /**
     * 生成账户申请文件
     */
      void generateAccountApplyFile(String chnCode,String preDate,String applyDate) throws IOException;

    /**
     * 生成交易申请文件
     */
    void generateTradeApplyFile(String chnCode,String preDate,String applyDate) throws IOException;

    /**
     * 生成所有渠道的所有文件
     */
    void generateAllFiles();
}
