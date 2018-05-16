package com.jinhui.zlrt.mapper.scheduler;


import com.jinhui.zlrt.entity.domain.ChnProduct;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "chnProductMapperScheduler")
public interface ChnProductMapperScheduler {

     List<ChnProduct> selectAllChnProductList();
}