package com.jinhui.api.mapper.trade;

import com.jinhui.api.entity.po.ChnProduct;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

public interface ChnProductDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ChnProduct record);

    int insertSelective(ChnProduct record);

    ChnProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChnProduct record);

    int updateByPrimaryKey(ChnProduct record);


    /**
     * 根据产品代码和渠道代码查询产品信息
     */
    ChnProduct selectProductInfo(@Param("chnCode") String channelCode, @Param("productNo") String productCode);


    /**
     * 查询产品的最新的剩余库存,在事务内加写锁
     */
    @Select(value = "select purchase_limit from chn_product where product_no=#{productNo} and chn_code=#{chnCode} for update")
    BigDecimal selectPurchaseLimitByLock(@Param("chnCode") String channelCode,@Param("productNo") String productNo);

    /**
     * 减库存,在原数据中减去数据
     */
    int subtractPurchaseLimit(@Param("chnCode") String channelCode,@Param("productNo") String productNo, @Param("purchaseLimit") BigDecimal purchaseLimit);


    int increasePurchaseLimit(@Param("chnCode") String channelCode,@Param("productNo") String productNo, @Param("purchaseLimit") BigDecimal purchaseLimit);


    /**
     * 根据渠道查询多个产品信息
     */
    List<ChnProduct> selectByChnCode(@Param("chnCode") String chnCode);

}