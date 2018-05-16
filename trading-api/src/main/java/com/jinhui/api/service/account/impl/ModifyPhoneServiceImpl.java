package com.jinhui.api.service.account.impl;

import com.jinhui.api.constants.BussStatus;
import com.jinhui.api.constants.RespCode;
import com.jinhui.api.entity.po.BussSerialRecord;
import com.jinhui.api.entity.po.User;
import com.jinhui.api.entity.dto.ModifyPhone;
import com.jinhui.api.entity.dto.ModifyPhoneAssembly;
import com.jinhui.api.mapper.trade.BussSerialRecordDao;
import com.jinhui.api.mapper.trade.UserDao;
import com.jinhui.api.service.account.ModifyPhoneService;
import com.jinhui.api.utils.DateUtils;
import com.jinhui.common.service.IdService;
import com.jinhui.common.utils.ResultResp;
import com.jinhui.zlrt.entity.dto.ChangeMobileNoRequest;
import com.jinhui.zlrt.entity.dto.ChangeMobileNoResponse;
import com.jinhui.zlrt.service.ZlrtBussService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/1/25 0025.
 */
@Service
public class ModifyPhoneServiceImpl implements ModifyPhoneService {


    private static Logger logger = LoggerFactory.getLogger(ModifyPhoneServiceImpl.class);

    @Autowired
    private BussSerialRecordDao bussSerialRecordDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ZlrtBussService zlrtBussService;

    @Autowired
    private IdService idService;


    @Override
    public ModifyPhone modifyPhone(ModifyPhone modifyPhone) {

        //检查是否有这个用户
        User user = userDao.selectByChnId(modifyPhone.getChannelUserId());
        if (user == null) {
            modifyPhone.setRespCode(RespCode.USER_NO_EXIST);
            modifyPhone.setErrorMsg("该用户不存在");
            return modifyPhone;
        }

        //保存业务流水
        BussSerialRecord serialRecord = ModifyPhoneAssembly.toBussSerialRecord(modifyPhone);
        bussSerialRecordDao.insert(serialRecord);


        //证联交互
        String transferNo = idService.generateTransferNo();
        String zlrtUserId = userDao.selectZlrtUserIdByChnId(modifyPhone.getChannelUserId());
        ChangeMobileNoRequest changeMobileNoRequest = ModifyPhoneAssembly.toChangeMobileNoRequest(modifyPhone, transferNo, zlrtUserId);
        ResultResp<ChangeMobileNoResponse> resultResp = zlrtBussService.changeMobileNo(changeMobileNoRequest);


        if (resultResp.isException()) {//异常

            logger.info("修改手机号失败");
            serialRecord.setBussStatus(BussStatus.FAIL);
            serialRecord.setZlRespMsg(resultResp.getMsg());
            bussSerialRecordDao.updateStateByApplyNo(serialRecord);

            modifyPhone.setRespCode(RespCode.SYSTEM_ERROR);
            modifyPhone.setErrorMsg(resultResp.getMsg());
            return modifyPhone;
        }


        ChangeMobileNoResponse response = resultResp.getData();

        if (resultResp.isSuccess()) {//成功
            //成功则更新用户的手机号
            userDao.updatePhoneByChnId(modifyPhone.getOriginPhoneNo(), modifyPhone.getModifyPhoneNo(), modifyPhone.getChannelUserId());

            //成功根据申请单号更新业务流水
            serialRecord.setBussStatus(BussStatus.SUCCESS);
            bussSerialRecordDao.updateStateByApplyNo(serialRecord);
        }
        if (resultResp.isFail()) {//失败
            //失败根据申请单号更新业务流水
            serialRecord.setBussStatus(BussStatus.FAIL);
            bussSerialRecordDao.updateStateByApplyNo(serialRecord);
        }

        modifyPhone.setRespCode(response.getRespCode());
        modifyPhone.setErrorMsg(response.getRespDesc());


        return modifyPhone;

    }


}
