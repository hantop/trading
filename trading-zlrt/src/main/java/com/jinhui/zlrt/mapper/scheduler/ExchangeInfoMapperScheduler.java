package com.jinhui.zlrt.mapper.scheduler;

import com.jinhui.zlrt.entity.domain.ExchangeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "exchangeInfoMapperScheduler")
public interface ExchangeInfoMapperScheduler {

    List<ExchangeInfo> selectAllExchangeInfoList();
}