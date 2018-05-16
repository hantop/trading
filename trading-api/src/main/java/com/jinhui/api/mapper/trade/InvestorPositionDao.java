package com.jinhui.api.mapper.trade;

import com.jinhui.api.entity.po.InvestorPosition;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface InvestorPositionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(InvestorPosition record);

    int insertSelective(InvestorPosition record);

    InvestorPosition selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InvestorPosition record);

    int updateByPrimaryKey(InvestorPosition record);

    /**
     * 根据渠道用户id获取用户某个产品的持仓信息
     */
    InvestorPosition selectByChnIdAndProduct(@Param("chnId") String chnId, @Param("productNo") String productNo);

    /**
     * 根据渠道用户id获取用户的所持有的产品的持仓信息
     */
    List<InvestorPosition> selectByChnId(@Param("chnId") String chnId);


    /**
     * 减去用户关于某个产品的持仓金额
     */
    int subtractPosition(@Param("chnId") String chnId, @Param("productNo") String productNo, @Param("amount") BigDecimal amount);


    /**
     * 根据渠道用户id获取用户的所持有的产品总持仓金额
     */
    BigDecimal selectTotalPositionByChnId(@Param("chnId") String chnId);


    /**
     * 根据渠道用户id获取用户的所持有的产品总持仓金额
     */
    BigDecimal selectTotalIncomeByChnId(@Param("chnId") String chnId);



    /**
     * 加上用户关于某个产品的持仓金额
     */
    int addPosition(@Param("chnId") String chnId, @Param("productNo") String productNo, @Param("amount") BigDecimal amount);


    /**
     * 查询所有持仓记录
     */
    List<InvestorPosition> selectAll();

    /**
     *根据渠道用户id更新用户某个产品的持仓信息
     */
    int updateByChnIdAndProduct(InvestorPosition record);


    /**
     *
     根据渠道用户id删除用户某个产品的持仓信息
     */
    int deleteByChnIdAndProduct(@Param("chnId") String chnId, @Param("productNo") String productNo);

}