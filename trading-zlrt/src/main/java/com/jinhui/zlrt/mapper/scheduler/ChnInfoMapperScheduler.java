package com.jinhui.zlrt.mapper.scheduler;


import com.jinhui.zlrt.entity.domain.ChnInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "chnInfoMapperScheduler")
public interface ChnInfoMapperScheduler {

    List<ChnInfo> selectAllChnInfoList();
}