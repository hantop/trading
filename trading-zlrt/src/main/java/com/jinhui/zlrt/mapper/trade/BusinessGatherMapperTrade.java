package com.jinhui.zlrt.mapper.trade;


import com.jinhui.zlrt.entity.domain.BusinessGather;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "businessGatherMapperTrade")
public interface BusinessGatherMapperTrade {

    int delete();

    int saveBatch(@Param("bussGatherList") List<BusinessGather> bussGatherList);

}