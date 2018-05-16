package com.jinhui.api.mapper.trade;

import com.jinhui.api.entity.po.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据渠道用户ID查询用户信息
     */
    User selectByChnId(@Param("chnId") String chnId);

    /**
     * 根据渠道用户ID查询用户的证联客户号
     */
    String selectZlrtUserIdByChnId(@Param("chnId") String chnId);


    /**
     * 根据渠道代码和证件号码查询用户信息
     */
    User selectByChnCodeAndIDNo(@Param("chnCode") String chnCode, @Param("idNo") String idNo);

    /**
     *根据渠道用户id更新手机号
     */
    int updatePhoneByChnId(@Param("originPhone") String originPhone, @Param("phone") String phone, @Param("chnId") String chnId);

}