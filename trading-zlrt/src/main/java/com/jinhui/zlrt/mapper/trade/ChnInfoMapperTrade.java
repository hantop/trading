package com.jinhui.zlrt.mapper.trade;

import com.jinhui.zlrt.entity.domain.ChnInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "chnInfoMapperTrade")
public interface ChnInfoMapperTrade {

    void delete();

    int saveBatch(@Param("chnInfoList") List<ChnInfo> chnInfoList);

    List<ChnInfo> selectAllChnInfoList();
}