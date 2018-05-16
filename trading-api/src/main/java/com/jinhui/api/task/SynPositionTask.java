package com.jinhui.api.task;


import com.jinhui.api.entity.po.InvestorPosition;
import com.jinhui.api.entity.po.PositionTemp;
import com.jinhui.api.mapper.trade.InvestorPositionDao;
import com.jinhui.api.mapper.trade.PositionTempDao;
import com.jinhui.api.mapper.trade.TradeConsignDao;
import com.jinhui.common.service.HolidayService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * 清算平台把数据同步到临时持仓表后
 * 1.要把临时持仓表的数据同步到持仓表
 * 2.然后把每个用户的持仓减去用户15：00到24：00的赎回金额
 */

@Component
public class SynPositionTask {


    private static Logger logger = LoggerFactory.getLogger(SynPositionTask.class);

    @Autowired
    private TradeConsignDao tradeConsignDao;

    @Autowired
    private PositionTempDao positionTempDao;

    @Autowired
    private InvestorPositionDao investorPositionDao;

    @Autowired
    private HolidayService holidayService;



    public void SynPositionTask() {


        //查询前一个工作日
        String batchDate = positionTempDao.queryDate();
        DateTime dt = DateTime.parse(batchDate, DateTimeFormat.forPattern("yyyy-MM-dd"));
        String PreWorkDay = holidayService.getPreWorkDay(dt.toString("yyyyMMdd"));
        String date = PreWorkDay + "150000";

        List<PositionTemp> positionTemps = positionTempDao.selectAll();

        for (PositionTemp positionTemp : positionTemps) {
            //持仓表有存量数据先删除
            investorPositionDao.deleteByChnIdAndProduct(positionTemp.getChnId(),positionTemp.getProductNo());

            //插入新记录
            InvestorPosition investorPosition = new InvestorPosition();
            BeanUtils.copyProperties(positionTemp, investorPosition);
            investorPositionDao.insert(investorPosition);

            //查询出该用户15：00到24：00的赎回总金额
            BigDecimal redeemSum = tradeConsignDao.selectRedeemSum(date, positionTemp.getChnId(), positionTemp.getProductNo());
            //更新有赎回的持仓记录
            if (redeemSum != null) {
                BigDecimal productVol = positionTemp.getProductVol();
                InvestorPosition position = new InvestorPosition();
                BeanUtils.copyProperties(positionTemp, position);
                position.setTotalPostionAmount(position.getTotalPostionAmount().subtract(redeemSum));
                position.setTotalRedemedAmount(position.getTotalRedemedAmount().add(redeemSum));
                position.setTotalPostionVol(position.getTotalPostionAmount().divide(productVol));

                //更新
                investorPositionDao.updateByChnIdAndProduct(position);
            }
        }



    }


}
