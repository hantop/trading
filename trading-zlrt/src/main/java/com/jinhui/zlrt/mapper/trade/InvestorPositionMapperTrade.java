package com.jinhui.zlrt.mapper.trade;


import com.jinhui.zlrt.entity.domain.InvestorPosition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "investorPositionMapperTrade")
public interface InvestorPositionMapperTrade {

    int delete();

    void saveBatch(@Param("positionList") List<InvestorPosition> positionList);
}