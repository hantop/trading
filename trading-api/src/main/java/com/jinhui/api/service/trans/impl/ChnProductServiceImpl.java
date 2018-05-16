package com.jinhui.api.service.trans.impl;

import com.jinhui.api.mapper.trade.ChnProductDao;
import com.jinhui.api.service.trans.ChnProductService;
import com.jinhui.common.exception.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018/2/1 0001.
 */
@Service
public class ChnProductServiceImpl implements ChnProductService {


    @Autowired
    private ChnProductDao chnProductDao;


    @Override
    public void subtractProductLimit(String channelCode, String productCode, String amount) {

        // 并发量不大的话，采取直接在数据库里更新
        int i = chnProductDao.subtractPurchaseLimit(channelCode, productCode, new BigDecimal(amount));
        if (i == 0) {
            throw new BizException("产品额度不足");
        }

    }

    /**
     * 增加产品库存
     */
    @Override
    public void increaseProductLimit(String channelCode, String productCode, String amount) {
        chnProductDao.increasePurchaseLimit(channelCode, productCode, new BigDecimal(amount));
    }
}
