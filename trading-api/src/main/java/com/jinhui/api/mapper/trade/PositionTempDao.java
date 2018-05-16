package com.jinhui.api.mapper.trade;

import com.jinhui.api.entity.po.PositionTemp;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PositionTempDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PositionTemp record);

    int insertSelective(PositionTemp record);

    PositionTemp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PositionTemp record);

    int updateByPrimaryKey(PositionTemp record);


    /**
     * 查询当天的批次日
     */
    @Select(value = "SELECT date FROM batch_state order by date desc limit 1")
    String queryDate();


    /**
     * 查询所有的持仓记录
     */
    List<PositionTemp> selectAll();
}