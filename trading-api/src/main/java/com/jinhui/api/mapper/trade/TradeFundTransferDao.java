package com.jinhui.api.mapper.trade;

import com.jinhui.api.entity.po.TradeFundTransfer;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TradeFundTransferDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TradeFundTransfer record);

    int insertSelective(TradeFundTransfer record);

    TradeFundTransfer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TradeFundTransfer record);

    int updateByPrimaryKey(TradeFundTransfer record);

    /**
     * 根据申请单号更新支付状态
     */
    int updateStateByPayStatus(@Param("applyNo") String applyNo, @Param("payState") String payState);


    /**
     *查询用户的全部的在途赎回金额
     */
    BigDecimal selectTotalUnderwayReedem(@Param("chnId") String chnId);


    /**
     * 根据支付状态查询资金划转记录
     */
    List<TradeFundTransfer> selectByPayStatus(@Param("payStatus") String payStatus);

}