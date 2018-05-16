package com.jinhui.zlrt.mapper.scheduler;


import com.jinhui.zlrt.entity.domain.BatchState;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "batchStateMapperScheduler")
public interface BatchStateMapperScheduler {

    List<BatchState> selectAllBatchStateList();

    BatchState selectBatchStateCurrent();
}