package com.jinhui.api.mapper.trade;

import com.jinhui.api.entity.po.BussSerialRecord;

public interface BussSerialRecordDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BussSerialRecord record);

    int insertSelective(BussSerialRecord record);

    BussSerialRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BussSerialRecord record);

    int updateByPrimaryKey(BussSerialRecord record);

    /**
     *根据申请单号更新业务状态
     */
    int updateStateByApplyNo(BussSerialRecord record);
}