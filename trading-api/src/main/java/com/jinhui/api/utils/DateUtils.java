package com.jinhui.api.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2018/1/25 0025.
 */
public class DateUtils {

    /**
     * 把yyyyMMdd格式的日期格式转为Date
     */
    public static Date toDate(String dateStr) {
        DateTime dt = DateTime.parse(dateStr, DateTimeFormat.forPattern("yyyyMMdd"));
        return dt.toDate();
    }

    /**
     * 把yyyyMMddHHmmss格式的日期格式转为Date
     */
    public static Date toTime(String dateStr) {
        DateTime dt = DateTime.parse(dateStr, DateTimeFormat.forPattern("yyyyMMddHHmmss"));
        return dt.toDate();

    }

    /**
     * 把日期转为yyyyMMdd格式的字符串
     */
    public static String toDateStr(Date date){
        DateTime dt=new DateTime(date);
        return dt.toString("yyyyMMdd");
    }


    /**
     * 把日期转为yyyyMMddHHmmss格式的字符串
     */
    public static String toTimeStr(Date date){
        DateTime dt=new DateTime(date);
        return dt.toString("yyyyMMddHHmmss");
    }

    /**
     * 把日期转为HHmmss格式的字符串
     */
    public static String toTimeStr2(Date date){
        DateTime dt=new DateTime(date);
        return dt.toString("HHmmss");
    }

}
