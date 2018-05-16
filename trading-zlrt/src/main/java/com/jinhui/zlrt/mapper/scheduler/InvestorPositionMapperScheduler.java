package com.jinhui.zlrt.mapper.scheduler;


import com.jinhui.zlrt.entity.domain.InvestorPosition;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "investorPositionMapperScheduler")
public interface InvestorPositionMapperScheduler {

    List<InvestorPosition> selectAllPosition();

}