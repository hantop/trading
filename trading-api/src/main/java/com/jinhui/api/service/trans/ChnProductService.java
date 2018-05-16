package com.jinhui.api.service.trans;

/**
 * Created by Administrator on 2018/2/1 0001.
 */
public interface ChnProductService {

    void subtractProductLimit(String channelCode, String productCode, String amount);

    void increaseProductLimit(String channelCode, String productCode, String amount);
}
