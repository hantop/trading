package com.jinhui.api.service.query.impl;

import com.jinhui.api.entity.dto.*;
import com.jinhui.api.entity.po.*;
import com.jinhui.api.mapper.trade.*;
import com.jinhui.api.service.query.QueryService;
import com.jinhui.api.utils.DateUtils;
import com.jinhui.common.exception.BizException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/2/2 0002.
 */
@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private BindCardInfoDao bindCardInfoDao;


    @Autowired
    private UserDao userDao;

    @Autowired
    private InvestorPositionDao positionDao;

    @Autowired
    private InvestorIncomeDao incomeDao;

    @Autowired
    private TradeConsignDao tradeConsignDao;

    @Autowired
    private ChnProductDao chnProductDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private TradeFundTransferDao tradeFundTransferDao;



    @Override
    public List<QueryCard> queryCards(QueryCard queryCard) {

        List<BindCardInfo> cardInfos = bindCardInfoDao.selectAllByChnId(queryCard.getChannelUserId(), queryCard.getChannelCode());

        List<QueryCard> list = new ArrayList();

        for (BindCardInfo cardInfo : cardInfos) {
            QueryCard card = new QueryCard();
            card.setChannelCode(queryCard.getChannelCode());
            card.setUserNameText(queryCard.getUserNameText());
            card.setChannelUserId(queryCard.getChannelUserId());
            card.setBankCode(cardInfo.getOpenBank());//银行代码
            card.setCardNo(cardInfo.getBankAccount()); //银行账号
            card.setBankProvinceCode(cardInfo.getProvince());   //银行所属省市代码
            card.setBankRegionCode(cardInfo.getCity()); //银行所属地区代码
            card.setStatus(cardInfo.getStatus()); //卡状态
            card.setCardDate(DateUtils.toDateStr(cardInfo.getCreateTime()));//绑卡日期
            card.setCardTime(DateUtils.toTimeStr(cardInfo.getCreateTime()));//绑卡时间
            list.add(card);
        }

        return list;
    }

    @Override
    public QueryUser queryUserInfo(QueryUser queryUser) {

        User user = userDao.selectByChnId(queryUser.getChannelUserId());

        if (user == null) {
            throw new BizException("该用户不存在");
        }

        queryUser.setUserType(user.getUserFlag());  //客户类别
        queryUser.setCertType(user.getIdType());//证件类型
        queryUser.setCertId(user.getIdNo());//证件号码
        queryUser.setPhoneNo(user.getPhone());//手机号
        queryUser.setSex(user.getSex());//性别
        queryUser.setAddress(user.getAddress());//联系地址
        queryUser.setClientRiskRate(user.getRiskLevel());//客户风险级别
        queryUser.setInstReprName(user.getInstReprIdName()); //法人代表姓名
        queryUser.setInstReprIDType(user.getInstReprIdType());//法人代表证件类型
        queryUser.setInstReprIDCode(user.getBankRegionCode());//法人代表证件号码
        queryUser.setInstReprCertValidDate(DateUtils.toDateStr(user.getInstReprExpdate()));//法人代表证件有效期
        queryUser.setInstReprphoneNo(user.getInstReprPhone());//法人联系电话

        return queryUser;
    }

    @Override
    public List<QueryTrans> queryAllTrans(QueryTrans queryTrans) {

        List<QueryTrans> list = new ArrayList();

        List<TradeConsign> trades = tradeConsignDao.selectAllTransByChnId(queryTrans.getChannelUserId());


        for (TradeConsign trade : trades) {

            QueryTrans qt = new QueryTrans();
            BeanUtils.copyProperties(queryTrans, qt);
            qt.setFundSeqId(trade.getApplyNo());//申请单号
            String dateStr = DateUtils.toDateStr(trade.getApplyDate());
            String timeStr2 = DateUtils.toTimeStr2(trade.getApplyTime());//时间HHmmss
            qt.setFundDate(dateStr); //申请日期yyyyMMdd
            qt.setFundTime(dateStr+timeStr2); //申请时间yyyyMMddHHmmss
            qt.setBankCode(trade.getTransBankCode()); //银行代码
            qt.setCardNo(trade.getTransBankAct());  //银行账号
            qt.setAmount(trade.getTransAmount().toString());//交易金额
            qt.setTransVol(trade.getTransVol().toString()); //交易份额
            qt.setProductCode(trade.getProductNo()); //产品代码
            qt.setBusinessCode(trade.getBussCode());//业务代码
            qt.setTransState(trade.getConsignStatus()); //交易状态

            list.add(qt);
        }

        return list;
    }

    @Override
    public List<QueryPosition> queryUserPosition(QueryPosition queryPosition) {

        List<QueryPosition> list = new ArrayList();
        List<InvestorPosition> positions = positionDao.selectByChnId(queryPosition.getChannelUserId());

        for (InvestorPosition position : positions) {

            QueryPosition qp = new QueryPosition();
            BeanUtils.copyProperties(queryPosition, qp);
            qp.setGatherDate(DateUtils.toDateStr(position.getGatherDate()));//汇总日期
            qp.setProductCode(position.getProductNo());//金飞镖产品代码
            qp.setProductName(position.getProductName()); //产品名称
            qp.setProductVol(position.getProductVol().toString());  //产品每份金额
            qp.setPositionAmount(position.getTotalPostionAmount().toString());  //持有金额
            qp.setPositionVol(position.getTotalPostionVol().toString()); //持有份额

            BigDecimal totalIncome = incomeDao.selectTotalIncome(position.getChnId(), position.getProductNo());
            qp.setTotalIncome(totalIncome.toString()); //单个产品的累计收益
            list.add(qp);
        }


        return list;
    }

    @Override
    public List<QueryIncome> queryALLIncome(QueryIncome queryIncome) {
        List<QueryIncome> list = new ArrayList();

        List<InvestorIncome> investorIncomes = incomeDao.selectAllByChnId(queryIncome.getChannelUserId(), queryIncome.getProductNo());
        for (InvestorIncome income : investorIncomes) {

            QueryIncome qc = new QueryIncome();
            BeanUtils.copyProperties(queryIncome, qc);

            qc.setIncomeDate(DateUtils.toDateStr(income.getGatherDate()));//收益日期
            qc.setProductNo(income.getProductNo());//金飞镖产品代码
            qc.setProductName(income.getProductName());//产品名称
            qc.setIncomeAmount(income.getIncomeAmount().toString()); //收益金额

            BigDecimal totalIncome = incomeDao.selectTotalIncome(queryIncome.getChannelUserId(), queryIncome.getProductNo());
            qc.setTotalIncome(totalIncome.toString()); //单个产品的累计收益

            list.add(qc);
        }

        return list;
    }

    @Override
    public List<QueryProduct> queryAllProduct(QueryProduct queryProduct) {
        List<QueryProduct> list = new ArrayList();

        List<ChnProduct> chnProducts = chnProductDao.selectByChnCode(queryProduct.getChannelCode());
        for (ChnProduct chnProduct : chnProducts) {

            Product productInfo = productDao.selectByCode(chnProduct.getProductNo());

            QueryProduct qp = new QueryProduct();
            BeanUtils.copyProperties(queryProduct, qp);

            qp.setProductName(chnProduct.getProductName()); //产品名称
            qp.setProductCode(chnProduct.getProductNo()); //产品代码
            qp.setExchangeCode(productInfo.getExchangeNo());//交易所代码
            qp.setProductType(productInfo.getProductType()); //产品类型
            qp.setCalIncomeWay(productInfo.getCalIncomeWay());//收益计算类型
            qp.setCalRateWay(productInfo.getCalRateWay());  //产品计息方式
            qp.setSetupDate(DateUtils.toDateStr(productInfo.getSetupDate()));//产品成立日
            qp.setIncomeRate(chnProduct.getIncomeRate().toString()); //产品收益率
            qp.setIpoStartDate(DateUtils.toDateStr(productInfo.getIpoStartDate())); //募集起始时间
            qp.setTotalLimit(productInfo.getTotalLimit().toString()); //产品总额度
            qp.setProductVol(productInfo.getProductVol().toString()); //产品每份金额
            qp.setSubsStartAmount(productInfo.getSubsStartAmount().toString()); //购买起始金额
            qp.setSubsRange(productInfo.getSubsRange().toString());//增减份数
            qp.setRiskAssess(productInfo.getRiskAssess()); //是否需要风险测评
            qp.setRiskLevel(productInfo.getRiskLevel()); //风险级别
            qp.setClientSubsToplimit(chnProduct.getClientSubsToplimit().toString());  //客户当日申购金额上限
            qp.setClientRedeemToplimit(chnProduct.getClientRedeemToplimit().toString()); //客户当日赎回金额上限
            qp.setClientPositionLimit(chnProduct.getClientPositionLimit().toString());  //客户持仓限额
            qp.setProductSubsToplimit(chnProduct.getProductSubsToplimit().toString());   //产品当日申购金额上限
            qp.setProductRedeemToplimit(chnProduct.getProductRedeemToplimit().toString()); //产品当日赎回金额上限
            qp.setPercentIncomeRate(chnProduct.getPercentIncomeRate().toString()); //产品万份收益
            list.add(qp);
        }

        return list;
    }

    @Override
    public QueryAssetSummary queryAssetSummary(QueryAssetSummary summary) {

        String chnUserId = summary.getChannelUserId();

        //账户余额=充值金额+定期赎回的金额(ps:系统目前没有余额，设为0)
        BigDecimal accountBalance = new BigDecimal("0");

        summary.setAccountBalance(accountBalance.toString());

        //持有金额=用户的全部持仓金额
        BigDecimal totalPosition = positionDao.selectTotalPositionByChnId(chnUserId);
        summary.setPositionAmount(totalPosition.toString());

        //累计收益=用户的总收益
        BigDecimal totalIncome = positionDao.selectTotalIncomeByChnId(chnUserId);
        summary.setTotalIncome(totalIncome.toString());

        //在途金额=资金划转表里申购的金额+资金划转表里赎回的金额
        BigDecimal totalUnderwaySubs = tradeConsignDao.selectTotalUnderwaySubs(chnUserId);//在途申购金额
        BigDecimal totalUnderwayReedem = tradeFundTransferDao.selectTotalUnderwayReedem(chnUserId);//在途赎回金额
        BigDecimal transitionalFund = totalUnderwaySubs.add(totalUnderwayReedem);//在途金额

        summary.setTransitionalFund(transitionalFund.toString());

        //账户总额=用户的当前持仓金额+在途金额+账户余额
        summary.setTotalAmount(totalPosition.add(transitionalFund).add(accountBalance).toString());
        summary.setGatherDate(DateUtils.toDateStr(new Date()));

        return summary;
    }
}
