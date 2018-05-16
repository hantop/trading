package com.jinhui.zlrt.mapper.trade;


import com.jinhui.zlrt.entity.domain.ChnProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "chnProductMapperTrade")
public interface ChnProductMapperTrade {

      ChnProduct selectChnProduct(@Param("productNo") String productNo);

      void insertChnProduct(ChnProduct chnProduct);

      void updateChnProduct(ChnProduct chnProduct);
}