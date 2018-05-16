package com.jinhui.api.mapper.trade;

import com.jinhui.api.entity.po.InvestorIncome;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface InvestorIncomeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(InvestorIncome record);

    int insertSelective(InvestorIncome record);

    InvestorIncome selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InvestorIncome record);

    int updateByPrimaryKey(InvestorIncome record);

    /**
     * 根据渠道用户id,产品代码，查询用户的所有收益记录
     */
    List<InvestorIncome> selectAllByChnId(@Param("chnId") String chnId, @Param("productNo") String productNo);

    /**
     * 根据渠道用户id和产品代码查询该产品的总的累计收益
     */
    BigDecimal selectTotalIncome(@Param("chnId") String chnId, @Param("productNo") String productNo);
}