package com.jinhui.common.service.impl;

import com.jinhui.common.mapper.trade.TradeIdSequenceDao;
import com.jinhui.common.service.IdService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jinhui on 2017/5/25.
 */
@Service
public class IdServiceImpl implements IdService {

    @Autowired
    private TradeIdSequenceDao tradeIdSequenceDao;


    @Override
    public String generateTransferNo() {

        long seq = getSeq("zlrt");
        String yyyyMMdd = DateTime.now().toString("yyyyMMdd");
        return yyyyMMdd + String.format("%010d", seq);//不足10位补零

    }

    @Override
    public String generateOpenAccountNo() {
        long seq = getSeq("user");
        return String.format("%024d", seq);//不足18位补零
    }


    /**
     * 根据key递增生成seq
     */
    private long getSeq(final String key) {

        tradeIdSequenceDao.insertOrUpdateByKey(key);

        return tradeIdSequenceDao.querySeqByKey(key);

    }


}
