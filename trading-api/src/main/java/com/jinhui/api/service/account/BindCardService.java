package com.jinhui.api.service.account;

import com.jinhui.api.entity.dto.BindCard;

/** 新增银行卡，取消银行卡
 * Created by Administrator on 2018/1/25 0025.
 */
public interface BindCardService {


    /**
     * 新增银行卡
     */
    BindCard addCard(BindCard BindCard);



    /**
     *取消银行卡
     */
    BindCard cancelCard(BindCard BindCard);

}
