package com.jinhui.api.service.trans;

import com.jinhui.api.entity.dto.Redeeming;

/**
 * Created by Administrator on 2018/1/30 0030.
 */
public interface RedeemService {


    /**
     * 赎回活期产品
     */
    Redeeming redeemFunds(Redeeming redeeming);



//    queryRedeemLimit();

}
