package com.jinhui.zlrt.mapper.scheduler;


import com.jinhui.zlrt.entity.domain.InvestorIncome;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "investorIncomeMapperScheduler")
public interface InvestorIncomeMapperScheduler {

    List<InvestorIncome> selectAllIncome();


}