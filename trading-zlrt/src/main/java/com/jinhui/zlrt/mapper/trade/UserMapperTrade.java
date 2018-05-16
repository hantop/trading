package com.jinhui.zlrt.mapper.trade;


import com.jinhui.zlrt.entity.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "userMapperTrade")
public interface UserMapperTrade {

    List<User> selectConfirmUserList(@Param("chnCode") String chnCode,@Param("preDate") String preDate,@Param("applyDate") String applyDate);

    /**
     * 更新投资人ID investor_id
     * @return
     */
    int updateInvestorId(@Param("investorId") String investorId,@Param("applyNo") String applyNo);
}