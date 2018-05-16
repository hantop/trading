package com.jinhui.zlrt.service.impl;

import com.jinhui.common.service.HolidayService;
import com.jinhui.zlrt.common.StatusCodeEnum;
import com.jinhui.zlrt.entity.domain.*;
import com.jinhui.zlrt.mapper.scheduler.*;
import com.jinhui.zlrt.mapper.trade.*;
import com.jinhui.zlrt.service.SyncDataServcie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 从清算系统同步数据到交易系统
 *
 * @autor wsc
 * @create 2018-02-08 10:57
 **/
@Service("syncDataService")
public class SyncDataServiceImpl implements SyncDataServcie{
    private static Logger logger = LoggerFactory.getLogger(SyncDataServiceImpl.class);

    @Autowired
    private ProductMapperScheduler productMapperScheduler;
    @Autowired
    private ProductMapperTrade productMapperTrade;
    @Autowired
    private ChnProductMapperScheduler chnProductMapperScheduler;
    @Autowired
    private ChnProductMapperTrade chnProductMapperTrade;
    @Autowired
    private BusinessGatherMapperScheduler businessGatherMapperScheduler;
    @Autowired
    private BusinessGatherMapperTrade businessGatherMapperTrade;
    @Autowired
    private InvestorPositionMapperScheduler investorPositionMapperScheduler;
    @Autowired
    private InvestorPositionMapperTrade investorPositionMapperTrade;
    @Autowired
    private InvestorIncomeMapperScheduler investorIncomeMapperScheduler;
    @Autowired
    private InvestorIncomeMapperTrade investorIncomeMapperTrade;
    @Autowired
    private ChnInfoMapperScheduler chnInfoMapperScheduler;
    @Autowired
    private ChnInfoMapperTrade chnInfoMapperTrade;
    @Autowired
    private ExchangeInfoMapperScheduler exchangeInfoMapperScheduler;
    @Autowired
    private ExchangeInfoMapperTrade exchangeInfoMapperTrade;
    @Autowired
    private BatchStateMapperScheduler batchStateMapperScheduler;
    @Autowired
    private BatchStateMapperTrade batchStateMapperTrade;
    @Autowired
    private TradeConsignMapperTrade tradeConsignMapperTrade;
    @Autowired
    private ExchangeOpenMapperTrade exchangeOpenMapperTrade;
    @Autowired
    private ChnOpenMapperScheduler chnOpenMapperScheduler;
    @Autowired
    private UserMapperTrade userMapperTrade;
    @Autowired
    private InvestorTransMapperScheduler investorTransMapperScheduler;
    @Autowired
    private TradeFundTransferMapperTrade tradeFundTransferMapperTrade;
    @Autowired
    private HolidayService holidayService;

    //同步产品数据
    public void syncProduct() {
        logger.info("......开始同步产品数据............");
        List<Product> productList = productMapperScheduler.selectAllProductList();
        logger.info("产品个数： "+ productList.size());

        productMapperTrade.deleteProducts();

        productMapperTrade.insertProductsBatch(productList);
        logger.info("......同步产品数据完成............");
    }

    //同步渠道产品数据
    public void syncChnProduct() {
        logger.info("......开始同步渠道产品数据............");
        List<ChnProduct> chnProductList = chnProductMapperScheduler.selectAllChnProductList();
        logger.info("渠道产品个数： "+ chnProductList.size());
        for(ChnProduct cp : chnProductList){
               ChnProduct chnProduct = chnProductMapperTrade.selectChnProduct(cp.getProductNo());
               if(chnProduct == null){
                   cp.setPurchaseLimit(new BigDecimal(cp.getTotalLimit()));
                   chnProductMapperTrade.insertChnProduct(cp);
               }else{
                   chnProduct.setIncomeRate(cp.getIncomeRate());
                   chnProduct.setPercentIncomeRate(cp.getPercentIncomeRate());
                   chnProduct.setSubsToplimit(cp.getSubsToplimit());
                   chnProduct.setRedeemToplimit(cp.getRedeemToplimit());
                   chnProduct.setPositionLimit(cp.getPositionLimit());
                   chnProduct.setProductSubsToplimit(cp.getProductSubsToplimit());
                   chnProduct.setProductRedeemToplimit(cp.getProductRedeemToplimit());
                   chnProductMapperTrade.updateChnProduct(chnProduct);
               }

        }
        //ChnProduct chnProduct = chnProductMapperTrade.selectChnProduct("GY0002");
        logger.info("......同步渠道产品数据完成............");
    }

    //同步汇总数据
    public void syncBussGather() {
        logger.info("......开始同步汇总数据............");
        List<BusinessGather> bussGatherList = businessGatherMapperScheduler.selectBussGatherList();
        logger.info("汇总数据个数： "+ bussGatherList.size());

        if(bussGatherList.size() != 0){
            businessGatherMapperTrade.delete();
            businessGatherMapperTrade.saveBatch(bussGatherList);
        }

        logger.info("......同步汇总数据完成............");
    }

    //同步收益数据
    public void syncIncome() {
        logger.info("......开始同步收益数据............");
        List<InvestorIncome> incomeList = investorIncomeMapperScheduler.selectAllIncome();
        logger.info("收益数据个数： "+ incomeList.size());

        if(incomeList.size() != 0){
            investorIncomeMapperTrade.delete();
            investorIncomeMapperTrade.saveBatch(incomeList);
        }

        logger.info("......同步收益数据完成............");
    }

    //同步持仓数据
    public void syncPosition() {
        logger.info("......开始同步持仓数据............");
        List<InvestorPosition> positionList = investorPositionMapperScheduler.selectAllPosition();
        logger.info("持仓数据个数： "+ positionList.size());

        if(positionList.size() != 0){
            investorPositionMapperTrade.delete();
            investorPositionMapperTrade.saveBatch(positionList);
        }

        logger.info("......同步持仓数据完成............");
    }

    //同步渠道数据
    public void syncChnInfo() {
        logger.info("......开始同步渠道数据............");
        List<ChnInfo> chnInfoList = chnInfoMapperScheduler.selectAllChnInfoList();
        logger.info("渠道数据个数： "+ chnInfoList.size());

        if(chnInfoList.size() != 0){
            chnInfoMapperTrade.delete();
            chnInfoMapperTrade.saveBatch(chnInfoList);
        }
        logger.info("......同步渠道数据完成............");
    }

    //同步交易所数据
    public void syncExchangeInfo() {
        logger.info("......开始同步交易所数据............");
        List<ExchangeInfo> exchangeInfoList = exchangeInfoMapperScheduler.selectAllExchangeInfoList();
        logger.info("交易所数据个数： "+ exchangeInfoList.size());

        if(exchangeInfoList.size() != 0){
            exchangeInfoMapperTrade.delete();
            exchangeInfoMapperTrade.saveBatch(exchangeInfoList);
        }
        logger.info("......同步交易所数据完成............");
    }
    //同步批次数据
    public void syncBatchDate() {
        logger.info("......开始同步批次数据............");
        List<BatchState> batchList = batchStateMapperScheduler.selectAllBatchStateList();
        logger.info("批次数据个数： "+ batchList.size());

        if(batchList.size() != 0){
            batchStateMapperTrade.delete();
            batchStateMapperTrade.saveBatch(batchList);
        }
        logger.info("......同步批次数据完成............");
    }

    @Override
    public void syncUserState() {
        logger.info("......开始同步用户状态和投资人ID............");
        //查询清算系统当前批次
        BatchState batchState = batchStateMapperScheduler.selectBatchStateCurrent();
        //查询清算系统最新批次的开户记录
        List<ChnOpen> chnOpenList = chnOpenMapperScheduler.selectOpenSuccessList(String.valueOf(batchState.getBatchCode()));
        logger.info(" 清算系统清算成的用户数： " + chnOpenList.size());
        Map map = new HashMap();
        for(ChnOpen chnOpen:chnOpenList){
            map.put(chnOpen.getAppSheetSerialNo(),chnOpen);
        }

        //查询“未上报”的开户记录
        List<ExchangeOpen> toHandingList = exchangeOpenMapperTrade.selecToHandingList();
        logger.info(" 交易系统待上报的用户数： " + toHandingList.size());
        for(ExchangeOpen exchangeOpen : toHandingList){
            //如果存在，说明清算系统清算成功，该用户已上报
             if(map.containsKey(exchangeOpen.getApplyNo())){
                 //更新该交易所用户表状态为“已上报”
                 exchangeOpenMapperTrade.updateToSuccess(exchangeOpen.getApplyNo());

                 //更新该用户表的投资人ID investor_id
                 ChnOpen co = (ChnOpen) map.get(exchangeOpen.getApplyNo());
                 userMapperTrade.updateInvestorId(co.getInvestorId(),exchangeOpen.getApplyNo());
             }
        }

        logger.info("......同步用户状态和投资人ID完成............");
    }

    @Override
    public void syncTransState() {
        logger.info("......开始同步交易委托记录的状态............");
        //查询清算系统当前批次
        BatchState batchState = batchStateMapperScheduler.selectBatchStateCurrent();
        //查询清算系统最新批次的交易记录
        List<InvestorTrans> transList = investorTransMapperScheduler.selectBatchTransList(String.valueOf(batchState.getBatchCode()));
        logger.info(" 清算系统清算的交易数： " + transList.size());
        Map map = new HashMap();
        for(InvestorTrans investorTrans:transList){
            map.put(investorTrans.getAppSheetSerialNo(),investorTrans);
        }

        //查询交易系统待同步的委托记录
        List<TradeConsign>  consignList = tradeConsignMapperTrade.selectToHandingTradeList();
        logger.info(" 交易系统待确认的委托数： " + consignList.size());
        for(TradeConsign tradeConsign:consignList){
              if(map.containsKey(tradeConsign.getApplyNo())){
                  InvestorTrans trans = (InvestorTrans) map.get(tradeConsign.getApplyNo());
                  tradeConsignMapperTrade.updateconsignStatus(StatusCodeEnum.StatusCode.getExchCode(trans.getTransState()),tradeConsign.getApplyNo());
              }
        }

        String batchDate = new SimpleDateFormat("yyyyMMdd").format(batchState.getDate());
        String preDate = holidayService.getPreWorkDay(batchDate);
        logger.info("起始日： " + preDate + "   结束日： "+batchDate);
        logger.info("------------------  更新资金划转表中赎回失败的记录 -----------------------");
        //更新资金划转表中赎回失败的记录
        tradeFundTransferMapperTrade.syncPayStatus(preDate,batchDate);

        logger.info("......同步交易委托记录的状态完成............");
    }

    @Scheduled(cron="1 1 0 * * *")
    public void syncAllData(){
        syncBatchDate();
        syncProduct();
        syncChnProduct();
        syncChnInfo();
        syncExchangeInfo();
        syncIncome();
        syncPosition();
    }

}
