package com.jinhui.api.mapper.trade;

import com.jinhui.api.entity.po.ExchangeOpen;
import org.apache.ibatis.annotations.Param;

public interface ExchangeOpenDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ExchangeOpen record);

    int insertSelective(ExchangeOpen record);

    ExchangeOpen selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExchangeOpen record);

    int updateByPrimaryKey(ExchangeOpen record);

    /**
     * 根据渠道用户ID,产品代码查询该用户是否在该产品的交易所开过户
     */
    int selectIsOpen(@Param("chnId") String chnId, @Param("productNo") String productNo);
}