package com.jinhui.api.service.trans;

import com.jinhui.api.entity.dto.QueryLimit;

/**
 * Created by Administrator on 2018/1/30 0030.
 */
public interface TransLimitService {


    /**
     * 查询客户的可购买和可赎回额度
     *
     */
    QueryLimit queryTransLimit(QueryLimit queryLimit);

}
