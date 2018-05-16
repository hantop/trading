package com.jinhui.zlrt.service;

import com.jinhui.common.utils.ResultResp;
import com.jinhui.zlrt.entity.dto.*;

/**
 * 证联支付相关业务服务层
 *
 * @autor wsc
 * @create 2018-01-30 14:05
 **/
public interface ZlrtBussService {
    //发送验证码
    ResultResp sendCode(SendCodeRequest sendCodeRequest);

    //开户
    ResultResp openAccount(OpenAccountRequest openAccountRequest);

    //添加银行卡
    ResultResp addBankCard(AddBankCardRequest addBankCardRequest);

    //取消银行卡
    ResultResp cancelBankCard(CancelBankCardRequest cancelBankCardRequest);

    //修改手机号
    ResultResp changeMobileNo(ChangeMobileNoRequest changeMobileNoRequest);

    //后台申购
    ResultResp purchase(PurchaseRequest purchaseRequest);

    //交易状态查询
    ResultResp tradeStatusSeach(TradeStatusSearchRequest tradeStatusSearchRequest);

}
