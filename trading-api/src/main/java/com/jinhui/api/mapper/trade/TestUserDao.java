package com.jinhui.api.mapper.trade;

import com.jinhui.api.entity.po.TestUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface TestUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TestUser record);

    int insertSelective(TestUser record);

    TestUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestUser record);

    int updateByPrimaryKey(TestUser record);

    /**
     * 根据登录id查询测试用户信息
     */
    TestUser selectByLoginId(@Param("loginId") String loginId);


    /**
     * 根据登录id更新测试用用户信息
     */
    int updateByLoginId(TestUser record);

    @Select(value = "SELECT date FROM batch_state order by date desc limit 1")
    String queryDate();
}