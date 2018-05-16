package com.jinhui.zlrt.mapper.trade;


import com.jinhui.zlrt.entity.domain.BatchState;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "batchStateMapperTrade")
public interface BatchStateMapperTrade {

    void delete();

    int saveBatch(@Param("batchDateList") List<BatchState> batchDateList);

    BatchState findNewest();
}