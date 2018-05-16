package com.jinhui.zlrt.mapper.scheduler;


import com.jinhui.zlrt.entity.domain.InvestorTrans;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "investorTransMapperScheduler")
public interface InvestorTransMapperScheduler {
    //查询清算系统当前批次的记录
    List<InvestorTrans> selectBatchTransList(@Param("batchCode") String batchCode);
}