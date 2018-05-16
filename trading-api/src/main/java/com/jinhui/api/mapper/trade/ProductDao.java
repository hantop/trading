package com.jinhui.api.mapper.trade;

import com.jinhui.api.entity.po.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * 根据产品代码查询产品信息
     */
    Product selectByCode(@Param("productNo") String productNo);


    /**
     * 更具产品代码查询对应的交易所的证联商户机构代码
     */
    String selectZlrtInstCode(@Param("productNo") String productNo);

}