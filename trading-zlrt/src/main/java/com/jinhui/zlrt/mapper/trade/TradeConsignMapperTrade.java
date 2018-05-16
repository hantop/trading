package com.jinhui.zlrt.mapper.trade;


import com.jinhui.zlrt.entity.domain.TradeConsign;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "tradeConsignMapperTrade")
public interface TradeConsignMapperTrade {

    List<TradeConsign> selectConfirmTradeList(@Param("chnCode") String chnCode,@Param("preDate") String preDate,@Param("applyDate") String applyDate);


    //查询“确认中”的交易委托记录
    List<TradeConsign> selectToHandingTradeList();

    //更新状态为“成功”或“失败”
    int updateconsignStatus(@Param("flag") String flag,@Param("applyNo") String applyNo);
}