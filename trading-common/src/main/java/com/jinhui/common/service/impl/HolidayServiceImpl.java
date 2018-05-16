package com.jinhui.common.service.impl;

import com.jinhui.common.entity.domain.Holiday;
import com.jinhui.common.mapper.trade.HolidayMapperTrade;
import com.jinhui.common.service.HolidayService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("holidayService")
public class HolidayServiceImpl implements HolidayService {
	
	private static Logger log = LoggerFactory.getLogger(HolidayServiceImpl.class);
	
	
	@Autowired
	private HolidayMapperTrade holidayMapperTrade;
	
	
	/**
	 * 是否工作日
	 * */
	@Override
	public Boolean isWorkDay(String date) {
		
		Holiday holiday = holidayMapperTrade.queryHoliday(date);
		if(holiday==null){
			throw new RuntimeException("该日期在holiday表中找不到记录");
		}
		if(holiday.getFlag().equals("Y"))
			return true;
		else
			return false;

	}

	/**
	 * 获取下一个工作日
	 * */
	@Override
	public String getNextWorkDay(String date) {
		
		do {
			DateTimeFormatter format = DateTimeFormat.forPattern("yyyyMMdd"); 
			DateTime dt=DateTime.parse(date,format);
			DateTime plusDays = dt.plusDays(1);
			date=plusDays.toString(format);
			
		} while (!isWorkDay(date));
			
		return date;
	}

	/**
	 * 获取上一个工作日
	 * */
	@Override
	public String getPreWorkDay(String date) {
		do {
			DateTimeFormatter format = DateTimeFormat.forPattern("yyyyMMdd"); 
			DateTime dt=DateTime.parse(date,format);
			DateTime plusDays = dt.minusDays(1);
			date=plusDays.toString(format);
			
		} while (!isWorkDay(date));
			
		return date;
		
	}
	
	
	/**
	 * 获取输入日期与上一个工作日之间的日期列表,(输入的不算在其中)
	 * */
	@Override
	public List<String> getPreWorkDayBetween(String date) {
		List<String> list=new ArrayList<>();
		do {
			DateTimeFormatter format = DateTimeFormat.forPattern("yyyyMMdd"); 
			DateTime dt=DateTime.parse(date,format);
			DateTime plusDays = dt.minusDays(1);
			date=plusDays.toString(format);
			list.add(date);
			
		} while (!isWorkDay(date));
			
		return list;
		
	}

	/**
	 * 获取输入日期与下一个工作日之间的日期列表
	 * */
	@Override
	public List<String> getNextWorkDayBetween(String date) {
		List<String> list=new ArrayList<>();
		do {
			list.add(date);
			DateTimeFormatter format = DateTimeFormat.forPattern("yyyyMMdd");
			DateTime dt=DateTime.parse(date,format);
			DateTime plusDays = dt.plusDays(1);
			date=plusDays.toString(format);
		} while (!isWorkDay(date));

		return list;

	}



	/*@Override
	public void initHolidayTable(String start, String end,String excelPath)  {
		//初始化工作日列表
		DateTimeFormatter format = DateTimeFormat.forPattern("yyyyMMdd"); 
		DateTime sd=DateTime.parse(start,format);
		DateTime ed=DateTime.parse(end,format);
		List<Holiday> list=new ArrayList<>();
		
		List<String> datelist=new ArrayList<>();//维护一份String类型的date

		Holiday day=new Holiday(sd.toDate(),"Y","交易日");
		list.add(day);
		datelist.add(sd.toString("yyyy/MM/dd"));
		while(sd.isBefore(ed)){
			sd = sd.plusDays(1);
			Holiday days=new Holiday(sd.toDate(),"Y","交易日");
			datelist.add(sd.toString("yyyy/MM/dd"));
			list.add(days);
		}
		holidayMapperTrade.addList(list);
		
		//解析xlsx文件,得到交易日,"C:/Users/jinhui/Desktop/交易日.xlsx"
		List<String> excel2List = ExcelUtils.Excel2List(new File(excelPath));
		
		//计算非交易日
		datelist.removeAll(excel2List);
		
		//更新非交易日
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		for (String noWorkDate : datelist) {
			try {
				Holiday h=new Holiday(sdf.parse(noWorkDate),"N","非交易日");
				holidayMapperTrade.updateHoliday(h);
			} catch (ParseException e) {
				log.error("excelPath");
				log.error("交易日文件日期解析失败",e);
			}
		}
		
		
		
	}*/


	
	
}


