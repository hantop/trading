package com.jinhui.common.mapper.trade;

import com.jinhui.common.entity.domain.Holiday;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>Title:HolidayMapperTrade</p>
 * <p>Description:DAO接口类</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: 金汇金融有限公司</p>
 * @author luoyuanq
 * @version v1.0 2017-06-05
 */
@Mapper
@Component(value = "holidayMapperTrade")
public interface HolidayMapperTrade {
	
	int save(Holiday holiday);
	
	int addList(List list);
	
	Holiday queryHoliday(@Param("date") String date);
	
	int updateHoliday(Holiday holiday);
	
}