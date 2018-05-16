package com.jinhui.api.service.account.impl;

import com.jinhui.api.constants.BussStatus;
import com.jinhui.api.constants.RespCode;
import com.jinhui.api.controller.AccountController;
import com.jinhui.api.entity.po.BindCardInfo;
import com.jinhui.api.entity.po.BussSerialRecord;
import com.jinhui.api.entity.po.User;
import com.jinhui.api.entity.dto.OpenAccount;
import com.jinhui.api.entity.dto.OpenAccountAssembly;
import com.jinhui.api.mapper.trade.BindCardInfoDao;
import com.jinhui.api.mapper.trade.BussSerialRecordDao;
import com.jinhui.api.mapper.trade.UserDao;
import com.jinhui.api.service.account.OpenAccountService;
import com.jinhui.api.utils.DateUtils;
import com.jinhui.common.service.IdService;
import com.jinhui.common.utils.ResultResp;
import com.jinhui.zlrt.entity.dto.OpenAccountRequest;
import com.jinhui.zlrt.entity.dto.OpenAccountResponse;
import com.jinhui.zlrt.service.ZlrtBussService;
import com.zlink.zlpay.commonofs.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/1/24 0024.
 */
@Service
public class OpenAccountServiceImpl implements OpenAccountService {

    private static Logger logger = LoggerFactory.getLogger(OpenAccountServiceImpl.class);

    @Autowired
    private BussSerialRecordDao bussSerialRecordDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BindCardInfoDao bindCardInfoDao;

    @Autowired
    private ZlrtBussService zlrtBussService;

    @Autowired
    private IdService idService;


    @Override
    public OpenAccount openAccount(OpenAccount openAccountVo) {

        //检查是否已经开过户
        User user = userDao.selectByChnCodeAndIDNo(openAccountVo.getChannelCode(), openAccountVo.getCertId());
        if (user != null) {
            openAccountVo.setRespCode(RespCode.USER_IS_OPEN_ACCOUNT);
            openAccountVo.setErrorMsg("该用户已开户，不能重复开户");
            return openAccountVo;
        }

        //保存业务流水
        BussSerialRecord bussSerialRecord = OpenAccountAssembly.toBussSerialRecord(openAccountVo);
        bussSerialRecordDao.insert(bussSerialRecord);

        //与证联交互
        String transferNo = idService.generateTransferNo();//生成资金划转流水号
        OpenAccountRequest openAccountRequest = OpenAccountAssembly.toOpenAccountRequest(openAccountVo, transferNo);

        ResultResp<OpenAccountResponse> resultResp = zlrtBussService.openAccount(openAccountRequest);

        if (resultResp.isException()) {//异常

            logger.info("开户失败");
            bussSerialRecord.setBussStatus(BussStatus.FAIL);
            bussSerialRecord.setZlRespMsg(resultResp.getMsg());
            bussSerialRecordDao.updateStateByApplyNo(bussSerialRecord);

            openAccountVo.setRespCode(RespCode.SYSTEM_ERROR);
            openAccountVo.setErrorMsg(resultResp.getMsg());
            return openAccountVo;
        }

        OpenAccountResponse response = resultResp.getData();
        if (resultResp.isSuccess()) {//成功
            //成功则保存用户信息
            User userInfo = OpenAccountAssembly.toUser(openAccountVo);
            userInfo.setZlUserId(response.getUserId());
            userDao.insert(userInfo);

            //保存到用户绑卡信息表
            BindCardInfo bindCardInfo = OpenAccountAssembly.toBindCardInfo(openAccountVo);
            bindCardInfo.setZlUserId(response.getUserId());
            bindCardInfo.setCounterNo(response.getCounterNo());
            bindCardInfoDao.insert(bindCardInfo);

            //根据申请单号更新业务流水
            updateSerialRecord(BussStatus.SUCCESS, bussSerialRecord, response);
        }

        if (resultResp.isFail()) {//失败
            updateSerialRecord(BussStatus.FAIL, bussSerialRecord, response);
        }

        openAccountVo.setRespCode(response.getRespCode());
        openAccountVo.setErrorMsg(response.getRespDesc());

        return openAccountVo;
    }


    /**
     * 更新流水状态
     */
    private void updateSerialRecord(String bussStatus, BussSerialRecord record, OpenAccountResponse response) {

        if (StringUtils.isNotEmpty(response.getUserId())) {
            record.setZlUserId(response.getUserId());
        }
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
