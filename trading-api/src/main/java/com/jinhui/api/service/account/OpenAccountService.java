package com.jinhui.api.service.account;


import com.jinhui.api.entity.dto.OpenAccount;

/**
 * 开户绑卡服务类
 * Created by Administrator on 2018/1/24 0024.
 */
public interface OpenAccountService {


    /**
     * 开户并绑卡
     */
    OpenAccount openAccount(OpenAccount openAccountVo);


}
