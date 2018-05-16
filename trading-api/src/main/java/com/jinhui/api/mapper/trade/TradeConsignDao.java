package com.jinhui.api.mapper.trade;

import com.jinhui.api.entity.po.TradeConsign;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TradeConsignDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TradeConsign record);

    int insertSelective(TradeConsign record);

    TradeConsign selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TradeConsign record);

    int updateByPrimaryKey(TradeConsign record);

    /**
     * 根据渠道用户id查询用户的所有交易记录
     */
    List<TradeConsign> selectAllTransByChnId(@Param("chnId") String chnId);

    /**
     * 根据申请单号更新交易委托的状态
     */
    int updateStateByApplyNo(@Param("applyNo") String applyNo, @Param("state") String state);


    /**
     * 查询用户的某个产品的在途申购金额
     */
    BigDecimal selectUnderwayAmount(@Param("chnId") String chnId, @Param("productNo") String productNo);

    /**
     * 查询用户的全部的在途申购金额
     */
    BigDecimal selectTotalUnderwaySubs(@Param("chnId") String chnId);


    /**
     * 查询失败的赎回记录
     */
    List<TradeConsign> selectFailRedeem();


    /**
     * 查询大于某个时间的，某个用户的某个产品的赎回总额
     */
    BigDecimal selectRedeemSum(@Param("date") String date, @Param("chnId") String chnId, @Param("productNo") String productNo);
}