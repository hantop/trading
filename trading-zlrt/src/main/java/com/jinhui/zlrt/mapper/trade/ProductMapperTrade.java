package com.jinhui.zlrt.mapper.trade;


import com.jinhui.zlrt.entity.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "productMapperTrade")
public interface ProductMapperTrade {

    /**
     * 清空产品表
     */
    void deleteProducts();

    void insertProductsBatch(@Param("productList") List<Product> productList);


}