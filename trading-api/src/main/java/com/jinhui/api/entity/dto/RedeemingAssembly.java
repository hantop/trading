package com.jinhui.api.entity.dto;

import com.jinhui.api.constants.BusinessCode;
import com.jinhui.api.constants.BussStatus;
import com.jinhui.api.constants.PayState;
import com.jinhui.api.entity.po.BussSerialRecord;
import com.jinhui.api.entity.po.TradeConsign;
import com.jinhui.api.entity.po.TradeFundTransfer;
import com.jinhui.api.utils.DateUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2018/2/1 0001.
 */
public class RedeemingAssembly {


    /**
     * 构造业务流水记录
     */
    public static BussSerialRecord toBussSerialRecord(Redeeming redeeming) {
        BussSerialRecord record = new BussSerialRecord();
        record.setName(redeeming.getUserNameText());//投资人姓名
        record.setApplyDate(DateUtils.toDate(redeeming.getFundDate()));//申请日期
        record.setApplyTime(DateUtils.toTime(redeeming.getFundTime()));//申请时间
        record.setApplyNo(redeeming.getFundSeqId());//申请单号
        record.setBussFlag(BusinessCode.REDEEM);//业务标识
        record.setChnCode(redeeming.getChannelCode());//渠道方代码
        record.setBussStatus(BussStatus.CONFIRM);//业务状态
        record.setChnId(redeeming.getChannelUserId());//渠道用户ID
        record.setCreateTime(new Date());
        return record;
    }


    /**
     * 构造交易委托
     */
    public static TradeConsign toTradeConsign(Redeeming redeeming) {
        TradeConsign record = new TradeConsign();

        record.setApplyDate(DateUtils.toDate(redeeming.getFundDate()));//申请日期
        record.setApplyTime(DateUtils.toTime(redeeming.getFundTime()));//申请时间
        record.setApplyNo(redeeming.getFundSeqId());//申请单号
        record.setName(redeeming.getUserNameText());//投资人姓名
        record.setChnCode(redeeming.getChannelCode());//渠道方代码
        record.setChnId(redeeming.getChannelUserId());//渠道用户ID
        record.setProductNo(redeeming.getProductCode());//金飞镖产品代码
        record.setProductName(redeeming.getProductName());//产品名称
        record.setBussCode(BusinessCode.REDEEM);//业务代码: 024-赎回
        record.setConsignStatus("0");//委托状态: 0-确认中
        record.setTransVol(new BigDecimal(redeeming.getAmount()));//交易份额
        record.setTransAmount(new BigDecimal(redeeming.getAmount()));//交易金额
        record.setTransBankCode(redeeming.getBankCode());//交易银行名称
        record.setTransBankAct(redeeming.getCardNo());//交易银行账号
        record.setRedeemFlag("0");//赎回方式: 0 赎回到用户银行卡
        record.setCreateTime(new Date());

        return record;
    }

    /**
     * 构造资金划转
     */
    public static TradeFundTransfer toTradeFundTransfer(Redeeming redeeming, String transferNo) {
        TradeFundTransfer record = new TradeFundTransfer();

        record.setApplyDate(DateUtils.toDate(redeeming.getFundDate()));//申请日期
        record.setApplyTime(DateUtils.toTime(redeeming.getFundTime()));//申请时间
        record.setApplyNo(redeeming.getFundSeqId());//申请单号
        record.setTransferNo(transferNo);   //资金划转流水号
        record.setName(redeeming.getUserNameText());//投资人姓名
        record.setChnCode(redeeming.getChannelCode());//渠道方代码
        record.setChnId(redeeming.getChannelUserId());//渠道用户ID
        record.setProductNo(redeeming.getProductCode());//金飞镖产品代码
        record.setProductName(redeeming.getProductName());//产品名称
        record.setBussCode(BusinessCode.REDEEM);//业务代码: 024-赎回
        record.setTransVol(new BigDecimal(redeeming.getAmount()));//交易份额
        record.setTransAmount(new BigDecimal(redeeming.getAmount()));//交易金额
        record.setPayAmount(new BigDecimal(redeeming.getAmount())); //pay_amount//支付金额
        record.setPayFlag("174"); //payFlag 业务标志:174-资金拨入
        record.setPayWay("1"); //payWay 支付方式:1-银行卡支付
        record.setPayStatus(PayState.NOT_SUBMIT); //支付状态 payStatus 1-已报
        record.setTransBankCode(redeeming.getBankCode());//交易银行名称
        record.setTransBankAct(redeeming.getCardNo());//交易银行账号
        record.setCreateTime(new Date());


        return record;
    }



}
