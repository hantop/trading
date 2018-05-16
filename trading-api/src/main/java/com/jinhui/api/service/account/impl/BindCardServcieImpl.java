package com.jinhui.api.service.account.impl;

import com.jinhui.api.constants.BusinessCode;
import com.jinhui.api.constants.BussStatus;
import com.jinhui.api.constants.RespCode;
import com.jinhui.api.entity.po.BindCardInfo;
import com.jinhui.api.entity.po.BussSerialRecord;
import com.jinhui.api.entity.dto.BindCard;
import com.jinhui.api.entity.dto.BindCardAssembly;
import com.jinhui.api.mapper.trade.BindCardInfoDao;
import com.jinhui.api.mapper.trade.BussSerialRecordDao;
import com.jinhui.api.mapper.trade.UserDao;
import com.jinhui.api.service.account.BindCardService;
import com.jinhui.api.utils.DateUtils;
import com.jinhui.common.service.IdService;
import com.jinhui.common.utils.ResultResp;
import com.jinhui.zlrt.entity.dto.*;
import com.jinhui.zlrt.service.ZlrtBussService;
import com.zlink.zlpay.commonofs.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/1/25 0025.
 */

@Service
public class BindCardServcieImpl implements BindCardService {

    private static Logger logger = LoggerFactory.getLogger(ModifyPhoneServiceImpl.class);

    @Autowired
    private BussSerialRecordDao bussSerialRecordDao;

    @Autowired
    private BindCardInfoDao bindCardInfoDao;

    @Autowired
    private IdService idService;

    @Autowired
    private ZlrtBussService zlrtBussService;

    @Autowired
    private UserDao userDao;

    @Override
    public BindCard addCard(BindCard bindCard) {

        BindCardInfo bindCardInfo = BindCardAssembly.toBindCardInfo(bindCard);
        bindCardInfo.setStatus("0");//卡状态：正常

        //检查银行卡是否已经绑定过
        BindCardInfo cardInfo = bindCardInfoDao.selectByParam(bindCardInfo);
        if (cardInfo != null) {
            bindCard.setErrorMsg("该卡已经绑定过，不能重复绑定");
            bindCard.setRespCode(RespCode.CARD_IS_BIND);
            return bindCard;
        }

        //保存业务流水
        BussSerialRecord serialRecord = BindCardAssembly.toBussSerialRecord(bindCard, BusinessCode.ADD_BANK_CARD);
        bussSerialRecordDao.insert(serialRecord);

        //证联交互
        String transferNo = idService.generateTransferNo();
        String zlrtUserId = userDao.selectZlrtUserIdByChnId(bindCard.getChannelUserId());
        AddBankCardRequest addBankCardRequest = BindCardAssembly.toAddBankCardRequest(bindCard, transferNo, zlrtUserId);

        ResultResp<AddBankCardResponse> resultResp = zlrtBussService.addBankCard(addBankCardRequest);

        if (resultResp.isException()) {//异常
            logger.info("添加银行卡失败");
            serialRecord.setBussStatus(BussStatus.FAIL);
            serialRecord.setZlRespMsg(resultResp.getMsg());
            bussSerialRecordDao.updateStateByApplyNo(serialRecord);

            bindCard.setRespCode(RespCode.SYSTEM_ERROR);
            bindCard.setErrorMsg(resultResp.getMsg());
            return bindCard;
        }

        AddBankCardResponse response = resultResp.getData();

        if (resultResp.isSuccess()) {
            //成功则保存用户绑卡信息表
            bindCardInfo.setZlUserId(zlrtUserId);
            bindCardInfoDao.insert(bindCardInfo);

            //成功根据申请单号更新业务流水
            updateSerialRecord(BussStatus.SUCCESS, serialRecord, response);

        }
        if (resultResp.isFail()) {
            //失败根据申请单号更新业务流水
            updateSerialRecord(BussStatus.FAIL, serialRecord, response);
        }

        bindCard.setRespCode(response.getRespCode());
        bindCard.setErrorMsg(response.getRespDesc());

        return bindCard;
    }

    @Override
    public BindCard cancelCard(BindCard bindCard) {

        //用户至少有两张银行卡的情况下，才能解绑其中一张卡，换言之，用户只有一张银行卡，就不能进行解绑操作
        BindCardInfo bindCardInfo = BindCardAssembly.toBindCardInfo(bindCard);
        bindCardInfo.setStatus("0");//卡状态：正常
        int count = bindCardInfoDao.selectCountByParam(bindCardInfo);
        if (count == 1) {
            bindCard.setErrorMsg("用户只有一张银行卡时，不允许解绑");
            bindCard.setRespCode(RespCode.CARD_NOT_UNBIND);
            return bindCard;
        }

        //保存业务流水
        BussSerialRecord serialRecord = BindCardAssembly.toBussSerialRecord(bindCard, BusinessCode.CANCEL_BANK_CARD);
        bussSerialRecordDao.insert(serialRecord);

        //证联交互
        String transferNo = idService.generateTransferNo();
        String zlrtUserId = userDao.selectZlrtUserIdByChnId(bindCard.getChannelUserId());
        CancelBankCardRequest cancelBankCardRequest = BindCardAssembly.toCancelBankCardRequest(bindCard, transferNo, zlrtUserId);

        ResultResp<CancelBankCardResponse> resultResp = zlrtBussService.cancelBankCard(cancelBankCardRequest);

        if (resultResp.isException()) {//异常
            logger.info("解除银行卡失败");
            serialRecord.setBussStatus(BussStatus.FAIL);
            serialRecord.setZlRespMsg(resultResp.getMsg());
            bussSerialRecordDao.updateStateByApplyNo(serialRecord);

            bindCard.setRespCode(RespCode.SYSTEM_ERROR);
            bindCard.setErrorMsg(resultResp.getMsg());
            return bindCard;
        }

        CancelBankCardResponse response = resultResp.getData();
        if (resultResp.isSuccess()) {

            //成功则更新用户绑卡信息表
            bindCardInfo.setStatus("1");//1-已解绑
            bindCardInfoDao.updateByParam(bindCardInfo);

            //成功根据申请单号更新业务流水
            updateSerialRecord(BussStatus.SUCCESS, serialRecord, response);
        }

        if (resultResp.isFail()) {//失败
            //失败根据申请单号更新业务流水
            updateSerialRecord(BussStatus.FAIL, serialRecord, response);
        }


        bindCard.setRespCode(response.getRespCode());
        bindCard.setErrorMsg(response.getRespDesc());

        return bindCard;
    }


    /**
     * 更新流水状态
     */
    private void updateSerialRecord(String bussStatus, BussSerialRecord record, AddBankCardResponse response) {

        if (StringUtils.isNotEmpty(response.getPnrDate())) {
            record.setZlHandelDate(DateUtils.toDate(response.getPnrDate()));
        }
        if (StringUtils.isNotEmpty(response.getPnrDate())) {
            record.setZlHandleTime(DateUtils.toTime(response.getPnrDate() + response.getPnrTime()));
        }
        if (StringUtils.isNotEmpty(response.getPnrSeqId())) {
            record.setZlSerialNo(response.getPnrSeqId());
        }
        record.setTransferNo(response.getFundSeqId());
        record.setZlRespCode(response.getRespCode());
        record.setZlRespMsg(response.getRespDesc());
        record.setBussStatus(bussStatus);
        bussSerialRecordDao.updateStateByApplyNo(record);
    }


    /**
     * 更新流水状态
     */
    private void updateSerialRecord(String bussStatus, BussSerialRecord record, CancelBankCardResponse response) {
        System.out.println();

        if (StringUtils.isNotEmpty(response.getPnrDate())) {
            record.setZlHandelDate(DateUtils.toDate(response.getPnrDate()));
        }
        if (StringUtils.isNotEmpty(response.getPnrDate())) {
            record.setZlHandleTime(DateUtils.toTime(response.getPnrDate() + response.getPnrTime()));
        }
        if (StringUtils.isNotEmpty(response.getPnrSeqId())) {
            record.setZlSerialNo(response.getPnrSeqId());
        }

        record.setTransferNo(response.getFundSeqId());
        record.setZlRespCode(response.getRespCode());
        record.setZlRespMsg(response.getRespDesc());
        record.setBussStatus(bussStatus);
        bussSerialRecordDao.updateStateByApplyNo(record);
    }

}
