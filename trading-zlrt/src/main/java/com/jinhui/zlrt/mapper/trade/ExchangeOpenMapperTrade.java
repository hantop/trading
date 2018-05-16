package com.jinhui.zlrt.mapper.trade;


import com.jinhui.zlrt.entity.domain.ExchangeOpen;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "exchangeOpenMapperTrade")
public interface ExchangeOpenMapperTrade {

    /**
     * 查询状态为“未上报”的开户记录
     * @return
     */
    List<ExchangeOpen> selecToHandingList();

    /**
     * 更新状态为“已上报”
     * @return
     */
    int updateToSuccess(@Param("applyNo") String applyNo);
}