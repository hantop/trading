package com.jinhui.api.mapper.trade;

import com.jinhui.api.entity.po.BindCardInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BindCardInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BindCardInfo record);

    int insertSelective(BindCardInfo record);

    BindCardInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BindCardInfo record);

    int updateByPrimaryKey(BindCardInfo record);

    /**
     * 根据渠道代码，银行卡号，银行代码，卡状态来查询绑卡信息
     */
    BindCardInfo selectByParam(BindCardInfo record);

    /**
     * 根据渠道代码，渠道用户id，卡状态来查询绑卡数量
     */
    int selectCountByParam(BindCardInfo record);


    /**
     * 根据渠道代码，银行卡号，银行代码，查询是不是第一次绑卡
     */
    int selectFirstBind(BindCardInfo record);

    /**
     * 根据渠道代码，银行卡号，银行代码更新卡状态
     */
    int updateByParam(BindCardInfo record);

    /**
     * 根据渠道代码，渠道用户id，查询用户的所有绑卡信息
     */
    List<BindCardInfo> selectAllByChnId(@Param("chnId") String chnId, @Param("chnCode") String chnCode);
}