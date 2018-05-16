package com.jinhui.api.service.trans.impl;

import com.jinhui.api.entity.dto.QueryLimit;
import com.jinhui.api.entity.po.ChnProduct;
import com.jinhui.api.entity.po.InvestorPosition;
import com.jinhui.api.mapper.trade.ChnProductDao;
import com.jinhui.api.mapper.trade.InvestorPositionDao;
import com.jinhui.api.mapper.trade.TradeConsignDao;
import com.jinhui.api.mapper.trade.TradeFundTransferDao;
import com.jinhui.api.service.trans.TransLimitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Administrator on 2018/1/30 0030.
 */
@Service
public class TransLimitServiceImpl implements TransLimitService {

    private static Logger logger = LoggerFactory.getLogger(TransLimitServiceImpl.class);

    @Autowired
    private ChnProductDao chnProductDao;

    @Autowired
    private InvestorPositionDao investorPositionDao;

    @Autowired
    private TradeConsignDao tradeConsignDao;

    private final static BigDecimal zero=new BigDecimal("0");


    /**
     * 用户可购买产品金额 = min(客户限制购买金额，客户当日限购金额，产品剩余购买金额)
     * ps:客户限制购买金额=客户持仓限额-客户已持仓金额 - 客户的在途申购金额(资金划转表中未成功的申购金额)
     * <p>
     * 用户可赎回金额 = min(客户已持仓金额,客户当日赎回限额)
     */
    @Override
    public QueryLimit queryTransLimit(QueryLimit queryLimit) {

        String channelUserId = queryLimit.getChannelUserId();
        String channelCode = queryLimit.getChannelCode();
        String productCode = queryLimit.getProductCode();

        //客户的在途申购金额
        BigDecimal underwayAmount = tradeConsignDao.selectUnderwayAmount(channelUserId, productCode);

        ChnProduct chnProduct = chnProductDao.selectProductInfo(channelCode, productCode);
        BigDecimal clientSubsToplimit = chnProduct.getClientSubsToplimit();//客户当日限购金额
        BigDecimal purchaseLimit = chnProduct.getPurchaseLimit();//产品剩余购买金额
        BigDecimal clientRedeemToplimit = chnProduct.getClientRedeemToplimit();//客户当日赎回限额
        BigDecimal clientPositionLimit = chnProduct.getClientPositionLimit();//客户持仓限额


        BigDecimal positionAmount = new BigDecimal("0");
        InvestorPosition investorPosition = investorPositionDao.selectByChnIdAndProduct(channelUserId, productCode);
        if (investorPosition != null) {
            positionAmount = investorPosition.getTotalPostionAmount();//客户已持仓金额
        }

        //查询用户可购买产品金额
        ArrayList<BigDecimal> list = new ArrayList<>();
        BigDecimal purchaseLimitAmount = clientPositionLimit.subtract(positionAmount).subtract(underwayAmount);
        if (purchaseLimitAmount.compareTo(zero)<0){
            list.add(zero);//客户限制购买金额
        }else {
            list.add(purchaseLimitAmount);//客户限制购买金额
        }



        list.add(clientSubsToplimit);
        list.add(purchaseLimit);

        //取三个值中的最小值，就是用户的可购买产品金额
        BigDecimal purchaseAmount = list.stream().min(Comparator.comparing(num -> num)).get();

        //查询用户可赎回金额
        ArrayList<BigDecimal> list2 = new ArrayList<>();
        list2.add(clientRedeemToplimit);
        list2.add(positionAmount);

        //取两个值中的最小值，就是用户的可赎回金额
        BigDecimal redeemAmount = list2.stream().min(Comparator.comparing(num -> num)).get();

        queryLimit.setPurchaseAmount(purchaseAmount.toString());
        queryLimit.setRedeemAmount(redeemAmount.toString());
        queryLimit.setPositionAmount(positionAmount.toString());

        return queryLimit;
    }


}
