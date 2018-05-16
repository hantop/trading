package com.jinhui.zlrt.mapper.trade;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Mapper
@Component(value = "tradeFundTransferMapperTrade")
public interface TradeFundTransferMapperTrade {

    /**
     * 批量更新支付状态为成功
     * @return
     */
    int updateStatusToSucc(@Param("preDate") String preDate,@Param("batchDate") String batchDate);

    /**
     * 批量更新支付状态为失败
     * @return
     */
    int updateStatusToFail(@Param("preDate") String preDate,@Param("batchDate") String batchDate);


    /**
     * 根据trade_consign委托表中赎回失败的记录，将trade_fund_transfer资金划转表赎回记录状态改为失败
     * @return
     */
    int syncPayStatus(@Param("preDate") String preDate,@Param("batchDate") String batchDate);
}