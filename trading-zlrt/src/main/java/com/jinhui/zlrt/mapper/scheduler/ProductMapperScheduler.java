package com.jinhui.zlrt.mapper.scheduler;


import com.jinhui.zlrt.entity.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "productMapperScheduler" )
public interface ProductMapperScheduler {
  /**
     * 查询所有产品
     * @return
     */
    List<Product> selectAllProductList();
}