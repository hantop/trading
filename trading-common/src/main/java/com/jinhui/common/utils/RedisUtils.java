package com.jinhui.common.utils;


import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.core.*;

import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 *
 */

public class RedisUtils {

    private static RedisTemplate<String, Object> redisTemplate= (RedisTemplate<String, Object>) SpringContextUtils.getBean("redisTemplate");

    private static ValueOperations<String, String> valueOperations= (ValueOperations<String, String>) SpringContextUtils.getBean("valueOperations");


//    private HashOperations<String, String, Object> hashOperations;

//    private ListOperations<String, Object> listOperations;

//    private SetOperations<String, Object> setOperations;

//    private ZSetOperations<String, Object> zSetOperations;
    /**  默认过期时长，单位：秒 */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;
    /**  不设置过期时长 */
    public final static long NOT_EXPIRE = -1;


    /**
     * 保存对象成json字符串，设置缓存时间
     * @param key
     * @param value
     * @param expire
     */
    public static void set(String key, Object value, long expire){
        valueOperations.set(key, toJson(value));
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    /**
     * 保存对象成json字符串，不设置缓存时间
     * @param key
     * @param value
     */
    public static void set(String key, Object value){
        set(key, value, DEFAULT_EXPIRE);
    }


    /**
     * 获取java对象,获取之后，刷新缓存时间
     * @param key
     * @param clazz
     * @param expire
     * @param <T>
     * @return
     */
    public static <T> T get(String key, Class<T> clazz, long expire) {
        String value = valueOperations.get(key);
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : fromJson(value, clazz);
    }

    /**
     * 获取java对象,获取之后，不刷新缓存时间
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T get(String key, Class<T> clazz) {
        return get(key, clazz, NOT_EXPIRE);
    }

    /**
     * 获取保存的字符串，获取之后刷新缓存时间
     * @param key
     * @param expire
     * @return
     */
    public static String get(String key, long expire) {
        String value = valueOperations.get(key);
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    public static String get(String key) {
        return get(key, NOT_EXPIRE);
    }

    /**
     * 删除缓存
     * @param key
     */
    public static void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * Object转成JSON数据
     */
    private static String toJson(Object object){
        if(object instanceof Integer || object instanceof Long || object instanceof Float ||
                object instanceof Double || object instanceof Boolean || object instanceof String){
            return String.valueOf(object);
        }
        return JSON.toJSONString(object);
    }

    /**
     * JSON数据，转成Object
     */
    private static  <T> T fromJson(String json, Class<T> clazz){
        return JSON.parseObject(json,clazz);
    }
}
