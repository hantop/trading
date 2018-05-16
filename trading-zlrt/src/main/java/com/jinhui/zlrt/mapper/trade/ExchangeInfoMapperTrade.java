package com.jinhui.zlrt.mapper.trade;

import com.jinhui.zlrt.entity.domain.ExchangeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "exchangeInfoMapperTrade")
public interface ExchangeInfoMapperTrade {

    void delete();

    int saveBatch(@Param("exchangeInfoList") List<ExchangeInfo> exchangeInfoList);
}