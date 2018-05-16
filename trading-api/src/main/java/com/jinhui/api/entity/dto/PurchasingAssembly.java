package com.jinhui.api.entity.dto;

import com.jinhui.api.constants.*;
import com.jinhui.api.entity.po.BussSerialRecord;
import com.jinhui.api.entity.po.ExchangeOpen;
import com.jinhui.api.entity.po.TradeConsign;
import com.jinhui.api.entity.po.TradeFundTransfer;
import com.jinhui.api.utils.DateUtils;
import com.jinhui.common.service.HolidayService;
import com.jinhui.common.utils.SpringContextUtils;
import com.jinhui.zlrt.entity.dto.PurchaseRequest;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2018/1/31 0031.
 */
public class PurchasingAssembly {

    private final static BigDecimal hundred = new BigDecimal("100");


    /**
     * 得到业务流水记录
     */
    public static BussSerialRecord toBussSerialRecord(Purchasing purchasing) {
        BussSerialRecord record = new BussSerialRecord();
        record.setName(purchasing.getUserNameText());//投资人姓名
        record.setApplyDate(DateUtils.toDate(purchasing.getFundDate()));//申请日期
        record.setApplyTime(DateUtils.toTime(purchasing.getFundTime()));//申请时间
        record.setApplyNo(purchasing.getFundSeqId());//申请单号
        record.setBussFlag(BusinessCode.PURCHASE);//业务标识
        record.setChnCode(purchasing.getChannelCode());//渠道方代码
        record.setBussStatus(BussStatus.CONFIRM);//业务状态
        record.setChnId(purchasing.getChannelUserId());//渠道用户ID
        record.setCreateTime(new Date());
        return record;
    }


    /**
     * 构造证联申购请求
     */
    public static PurchaseRequest toPurchaseRequest(Purchasing purchasing, String transferNo, String zlrtUserId) {
        PurchaseRequest record = new PurchaseRequest();

        //要求传结算商户号，不同的交易所不一样，从数据库中取
        String instCode = ZlrtInstCode.getZlrtInstCodeByProduct(purchasing.getProductCode());

        record.setInstuId(instCode);//证联支付分配给商户的机构代码
        record.setFundDate(purchasing.getFundDate());//商户的系统日期(YYYYMMDD)
        record.setFundTime(purchasing.getFundTime().substring(8));//商户的时间戳(HHMMSS)
        record.setFundSeqId(transferNo);//商户系统流水号
        record.setUserId(zlrtUserId);//用户在证联支付平台里的客户号
        record.setUserNameText(purchasing.getUserNameText());//客户的姓名
        record.setCertType(IDType.transform(purchasing.getCertType()));//证件类型
        record.setCertId(purchasing.getCertId());//证件号码
        record.setBankCode(purchasing.getBankCode()); //银行代码
        record.setCardNo(purchasing.getCardNo());//银行卡号
        record.setFlag("0");  //申购方式:0 协议支付（银行卡为必填）

        //渠道传过来的交易金额带小数点后两位，给证联传输的金额以分为单位
        record.setTransAmt(convertAmount(purchasing.getAmount())); //基金交易金额

        //结算日期要根据工作日来获取，如果在当天的15:00之前，结算日期是当天，如果15:00之后，是下一次结算日
        String liqDate = convertLiqDate(purchasing.getFundDate(), purchasing.getFundTime());
        record.setLiqDate(liqDate);

        record.setFundCode(purchasing.getProductCode());//基金代码
        record.setFundType("10");//基金类型: 10 公募其他
        record.setBusiType("0002");//业务类型-申购
//        record.setPhoneNo(purchasing.getPhoneNo());//客户手机号
//        record.setIdentifyCode(purchasing.getIdentifyingCode());//手机短信验证码

        return record;
    }


    /**
     * 构造交易委托
     */
    public static TradeConsign toTradeConsign(Purchasing purchasing) {
        TradeConsign record = new TradeConsign();

        record.setApplyDate(DateUtils.toDate(purchasing.getFundDate()));//申请日期
        record.setApplyTime(DateUtils.toTime(purchasing.getFundTime()));//申请时间
        record.setApplyNo(purchasing.getFundSeqId());//申请单号
        record.setName(purchasing.getUserNameText());//投资人姓名
        record.setChnCode(purchasing.getChannelCode());//渠道方代码
        record.setChnId(purchasing.getChannelUserId());//渠道用户ID
        record.setProductNo(purchasing.getProductCode());//金飞镖产品代码
        record.setProductName(purchasing.getProductName());//产品名称
        record.setBussCode(BusinessCode.PURCHASE);//业务代码: 022-申购
        record.setConsignStatus(TransState.CONFIRM);//委托状态: 0-确认中
        record.setTransVol(new BigDecimal(purchasing.getAmount()));//交易份额
        record.setTransAmount(new BigDecimal(purchasing.getAmount()));//交易金额
        record.setTransBankCode(purchasing.getBankCode());//交易银行名称
        record.setTransBankAct(purchasing.getCardNo());//交易银行账号
        record.setCreateTime(new Date());

        return record;
    }

    /**
     * 构造资金划转
     */
    public static TradeFundTransfer toTradeFundTransfer(Purchasing purchasing, String transferNo) {
        TradeFundTransfer record = new TradeFundTransfer();

        record.setApplyDate(DateUtils.toDate(purchasing.getFundDate()));//申请日期
        record.setApplyTime(DateUtils.toTime(purchasing.getFundTime()));//申请时间
        record.setApplyNo(purchasing.getFundSeqId());//申请单号
        record.setTransferNo(transferNo);   //资金划转流水号
        record.setName(purchasing.getUserNameText());//投资人姓名
        record.setChnCode(purchasing.getChannelCode());//渠道方代码
        record.setChnId(purchasing.getChannelUserId());//渠道用户ID
        record.setProductNo(purchasing.getProductCode());//金飞镖产品代码
        record.setProductName(purchasing.getProductName());//产品名称
        record.setBussCode(BusinessCode.PURCHASE);//业务代码: 022-申购
        record.setTransVol(new BigDecimal(purchasing.getAmount()));//交易份额
        record.setTransAmount(new BigDecimal(purchasing.getAmount()));//交易金额
        record.setPayAmount(new BigDecimal(purchasing.getAmount())); //pay_amount//支付金额
        record.setPayFlag("173"); //payFlag 业务标志:173-资金拨出
        record.setPayWay("1"); //payWay 支付方式:1-银行卡支付
        record.setPayStatus(PayState.SUBMIT); //支付状态 payStatus 1-已报
        record.setTransBankCode(purchasing.getBankCode());//交易银行名称
        record.setTransBankAct(purchasing.getCardNo());//交易银行账号
        record.setCreateTime(new Date());


        return record;
    }


    /**
     * 构造交易所开户记录
     */
    public static ExchangeOpen toExchangeOpen(Purchasing purchasing, String exchangeCode, String applyNo) {
        ExchangeOpen exchangeOpen = new ExchangeOpen();

        exchangeOpen.setApplyDate(DateUtils.toDate(purchasing.getFundDate()));//申请日期
        exchangeOpen.setApplyTime(DateUtils.toTime(purchasing.getFundTime()));//申请时间
        exchangeOpen.setApplyNo(applyNo);//申请单号
        exchangeOpen.setBussCode(BusinessCode.FIRST_OPEN);//业务代码: 001-开户'
        exchangeOpen.setChnCode(purchasing.getChannelCode());//渠道方代码
        exchangeOpen.setChnId(purchasing.getChannelUserId());//渠道用户ID
        exchangeOpen.setCreateTime(new Date());//创建时间
        exchangeOpen.setExchangeCode(exchangeCode);//交易所代码
        exchangeOpen.setName(purchasing.getUserNameText());//投资人姓名
        exchangeOpen.setState("0");//上报状态：0-未上报


        return exchangeOpen;

    }


    private static String convertAmount(String transAmount) {

        BigDecimal amount = new BigDecimal(transAmount).setScale(2, BigDecimal.ROUND_DOWN);
        BigDecimal zlrtAmount = amount.multiply(hundred).setScale(0, BigDecimal.ROUND_DOWN);

        return zlrtAmount.toString();
    }

    private static String convertLiqDate(String fundDate, String fundTime) {
        LocalTime transTime = LocalTime.parse(fundTime.substring(8), DateTimeFormat.forPattern("HHmmss"));
        LocalTime threeClock = LocalTime.parse("150000", DateTimeFormat.forPattern("HHmmss"));
        String liqDate = "";
        if (transTime.compareTo(threeClock) > 0) {//15:00之后
            HolidayService holidayService = SpringContextUtils.getBean("holidayService", HolidayService.class);
            liqDate = holidayService.getNextWorkDay(fundDate);
        }
        if (transTime.compareTo(threeClock) < 0) {//15:00之前
            liqDate = fundDate;
        }

        return liqDate;
    }


//    public static void main(String[] args) {
//
//        LocalTime localTime = LocalTime.parse("123550", DateTimeFormat.forPattern("HHmmss"));
//        System.out.println(localTime.toString());
//        LocalTime localTime2 = LocalTime.parse("150000", DateTimeFormat.forPattern("HHmmss"));
//        System.out.println(localTime.compareTo(localTime2) > 0);
//    }

}
