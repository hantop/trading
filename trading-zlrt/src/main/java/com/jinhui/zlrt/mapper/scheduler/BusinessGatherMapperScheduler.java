package com.jinhui.zlrt.mapper.scheduler;


import com.jinhui.zlrt.entity.domain.BusinessGather;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "businessGatherMapperScheduler")
public interface BusinessGatherMapperScheduler {

    List<BusinessGather> selectBussGatherList();

}