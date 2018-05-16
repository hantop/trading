package com.jinhui.zlrt.mapper.trade;


import com.jinhui.zlrt.entity.domain.InvestorIncome;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "investorIncomeMapperTrade")
public interface InvestorIncomeMapperTrade {

    int delete();

    void saveBatch(@Param("incomeList") List<InvestorIncome> incomeList);
}