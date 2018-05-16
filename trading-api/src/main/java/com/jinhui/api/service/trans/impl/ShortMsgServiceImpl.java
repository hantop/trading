package com.jinhui.api.service.trans.impl;

import com.jinhui.api.constants.BusinessCode;
import com.jinhui.api.constants.BussStatus;
import com.jinhui.api.constants.RespCode;
import com.jinhui.api.entity.dto.ShortMessage;
import com.jinhui.api.entity.dto.ShortMessageAssembly;
import com.jinhui.api.entity.po.BussSerialRecord;
import com.jinhui.api.mapper.trade.BussSerialRecordDao;
import com.jinhui.api.mapper.trade.UserDao;
import com.jinhui.api.service.trans.ShortMsgService;
import com.jinhui.api.utils.DateUtils;
import com.jinhui.common.utils.ResultResp;
import com.jinhui.zlrt.entity.dto.SendCodeRequest;
import com.jinhui.zlrt.entity.dto.SendCodeResponse;
import com.jinhui.zlrt.service.ZlrtBussService;
import com.zlink.zlpay.commonofs.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/2/27 0027.
 */
@Service
public class ShortMsgServiceImpl implements ShortMsgService {

    private static Logger logger = LoggerFactory.getLogger(ShortMsgServiceImpl.class);

    @Autowired
    private ZlrtBussService zlrtBussService;

    @Autowired
    private BussSerialRecordDao bussSerialRecordDao;

    @Autowired
    private UserDao userDao;


    @Override
    public ShortMessage sendCode(ShortMessage shortMessage) {

        //保存业务流水
        BussSerialRecord serialRecord = ShortMessageAssembly.toBussSerialRecord(shortMessage, BusinessCode.SEND_CODE);
        bussSerialRecordDao.insert(serialRecord);

        SendCodeRequest request = ShortMessageAssembly.toSendCodeRequest(shortMessage);

        //查询用户证联客户号
        String zlrtUserId = userDao.selectZlrtUserIdByChnId(shortMessage.getChannelUserId());
        if (zlrtUserId != null) {
            request.setUserId(zlrtUserId);
        }

        ResultResp<SendCodeResponse> resultResp = zlrtBussService.sendCode(request);

        if (resultResp.isException()) {//异常
            logger.info("发送短信失败");
            serialRecord.setBussStatus(BussStatus.FAIL);
            serialRecord.setZlRespMsg(resultResp.getMsg());
            bussSerialRecordDao.updateStateByApplyNo(serialRecord);

            shortMessage.setRespCode(RespCode.SYSTEM_ERROR);
            shortMessage.setErrorMsg(resultResp.getMsg());
            return shortMessage;
        }

        SendCodeResponse response = resultResp.getData();
        if (resultResp.isSuccess()) {//成功

            //更新业务流水
            updateSerialRecord(BussStatus.SUCCESS, serialRecord, response);
        }

        if (resultResp.isFail()) {//失败
            //更新业务流水
            updateSerialRecord(BussStatus.FAIL, serialRecord, response);
        }

        shortMessage.setRespCode(response.getRespCode());
        shortMessage.setErrorMsg(response.getRespDesc());

        return shortMessage;
    }


    /**
     * 更新流水状态
     */
    private void updateSerialRecord(String bussStatus, BussSerialRecord record, SendCodeResponse response) {

        if (StringUtils.isNotEmpty(response.getPnrDate())) {
            record.setZlHandelDate(DateUtils.toDate(response.getPnrDate()));
        }
        if (StringUtils.isNotEmpty(response.getPnrDate())) {
            record.setZlHandleTime(DateUtils.toTime(response.getPnrDate() + response.getPnrTime()));
        }
        if (StringUtils.isNotEmpty(response.getPnrSeqId())) {
            record.setZlSerialNo(response.getPnrSeqId());
        }
        record.setTransferNo(response.getMerchantSeqId());
        record.setZlRespCode(response.getRespCode());
        record.setZlRespMsg(response.getRespDesc());
        record.setBussStatus(bussStatus);
        bussSerialRecordDao.updateStateByApplyNo(record);
    }
}
