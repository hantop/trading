package com.jinhui.zlrt.mapper.scheduler;


import com.jinhui.zlrt.entity.domain.ChnOpen;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "chnOpenMapperScheduler")
public interface ChnOpenMapperScheduler {

    //查询清算系统开户“成功”的渠道用户记录
    List<ChnOpen> selectOpenSuccessList(@Param("batchCode") String batchCode);

}