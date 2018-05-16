package com.jinhui.api.entity.po;

import java.util.Date;

public class BussSerialRecord {
    /**
     * 表主键
     */
    private Integer id;

    /**
     * 申请日期
     */
    private Date applyDate;

    /**
     * 申请时间
     */
    private Date applyTime;

    /**
     * 申请单号
     */
    private String applyNo;

    private String transferNo;

    /**
     * 证联处理日期
     */
    private Date zlHandelDate;

    /**
     * 证联处理时间
     */
    private Date zlHandleTime;

    /**
     * 证联流水号
     */
    private String zlSerialNo;

    /**
     * 用户证联客户号
     */
    private String zlUserId;

    private String zlRespCode;

    private String zlRespMsg;

    /**
     * 投资人姓名
     */
    private String name;

    /**
     * 渠道用户ID
     */
    private String chnId;

    /**
     * 渠道方代码(渠道在平台中的代码标识)
     */
    private String chnCode;

    /**
     * 业务标识: 001-首次开户绑卡 002-新增银行卡 003-取消银行卡 006-变更客户手机号 022-申购 024-赎回 111-发送短信
     */
    private String bussFlag;

    /**
     * 业务状态: 0-确认中 1-成功 2-失败
     */
    private String bussStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 获取表主键
     *
     * @return id - 表主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置表主键
     *
     * @param id 表主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取申请日期
     *
     * @return apply_date - 申请日期
     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * 设置申请日期
     *
     * @param applyDate 申请日期
     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * 获取申请时间
     *
     * @return apply_time - 申请时间
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * 设置申请时间
     *
     * @param applyTime 申请时间
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 获取申请单号
     *
     * @return apply_no - 申请单号
     */
    public String getApplyNo() {
        return applyNo;
    }

    /**
     * 设置申请单号
     *
     * @param applyNo 申请单号
     */
    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo == null ? null : applyNo.trim();
    }

    /**
     * @return transfer_no
     */
    public String getTransferNo() {
        return transferNo;
    }

    /**
     * @param transferNo
     */
    public void setTransferNo(String transferNo) {
        this.transferNo = transferNo == null ? null : transferNo.trim();
    }

    /**
     * 获取证联处理日期
     *
     * @return zl_handel_date - 证联处理日期
     */
    public Date getZlHandelDate() {
        return zlHandelDate;
    }

    /**
     * 设置证联处理日期
     *
     * @param zlHandelDate 证联处理日期
     */
    public void setZlHandelDate(Date zlHandelDate) {
        this.zlHandelDate = zlHandelDate;
    }

    /**
     * 获取证联处理时间
     *
     * @return zl_handle_time - 证联处理时间
     */
    public Date getZlHandleTime() {
        return zlHandleTime;
    }

    /**
     * 设置证联处理时间
     *
     * @param zlHandleTime 证联处理时间
     */
    public void setZlHandleTime(Date zlHandleTime) {
        this.zlHandleTime = zlHandleTime;
    }

    /**
     * 获取证联流水号
     *
     * @return zl_serial_no - 证联流水号
     */
    public String getZlSerialNo() {
        return zlSerialNo;
    }

    /**
     * 设置证联流水号
     *
     * @param zlSerialNo 证联流水号
     */
    public void setZlSerialNo(String zlSerialNo) {
        this.zlSerialNo = zlSerialNo == null ? null : zlSerialNo.trim();
    }

    /**
     * 获取用户证联客户号
     *
     * @return zl_user_id - 用户证联客户号
     */
    public String getZlUserId() {
        return zlUserId;
    }

    /**
     * 设置用户证联客户号
     *
     * @param zlUserId 用户证联客户号
     */
    public void setZlUserId(String zlUserId) {
        this.zlUserId = zlUserId == null ? null : zlUserId.trim();
    }

    /**
     * @return zl_resp_code
     */
    public String getZlRespCode() {
        return zlRespCode;
    }

    /**
     * @param zlRespCode
     */
    public void setZlRespCode(String zlRespCode) {
        this.zlRespCode = zlRespCode == null ? null : zlRespCode.trim();
    }

    /**
     * @return zl_resp_msg
     */
    public String getZlRespMsg() {
        return zlRespMsg;
    }

    /**
     * @param zlRespMsg
     */
    public void setZlRespMsg(String zlRespMsg) {
        this.zlRespMsg = zlRespMsg == null ? null : zlRespMsg.trim();
    }

    /**
     * 获取投资人姓名
     *
     * @return name - 投资人姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置投资人姓名
     *
     * @param name 投资人姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取渠道用户ID
     *
     * @return chn_id - 渠道用户ID
     */
    public String getChnId() {
        return chnId;
    }

    /**
     * 设置渠道用户ID
     *
     * @param chnId 渠道用户ID
     */
    public void setChnId(String chnId) {
        this.chnId = chnId == null ? null : chnId.trim();
    }

    /**
     * 获取渠道方代码(渠道在平台中的代码标识)
     *
     * @return chn_code - 渠道方代码(渠道在平台中的代码标识)
     */
    public String getChnCode() {
        return chnCode;
    }

    /**
     * 设置渠道方代码(渠道在平台中的代码标识)
     *
     * @param chnCode 渠道方代码(渠道在平台中的代码标识)
     */
    public void setChnCode(String chnCode) {
        this.chnCode = chnCode == null ? null : chnCode.trim();
    }

    /**
     * 获取业务标识: 001-首次开户绑卡 002-新增银行卡 003-取消银行卡 006-变更客户手机号 022-申购 024-赎回 111-发送短信
     *
     * @return buss_flag - 业务标识: 001-首次开户绑卡 002-新增银行卡 003-取消银行卡 006-变更客户手机号 022-申购 024-赎回 111-发送短信
     */
    public String getBussFlag() {
        return bussFlag;
    }

    /**
     * 设置业务标识: 001-首次开户绑卡 002-新增银行卡 003-取消银行卡 006-变更客户手机号 022-申购 024-赎回 111-发送短信
     *
     * @param bussFlag 业务标识: 001-首次开户绑卡 002-新增银行卡 003-取消银行卡 006-变更客户手机号 022-申购 024-赎回 111-发送短信
     */
    public void setBussFlag(String bussFlag) {
        this.bussFlag = bussFlag == null ? null : bussFlag.trim();
    }

    /**
     * 获取业务状态: 0-确认中 1-成功 2-失败
     *
     * @return buss_status - 业务状态: 0-确认中 1-成功 2-失败
     */
    public String getBussStatus() {
        return bussStatus;
    }

    /**
     * 设置业务状态: 0-确认中 1-成功 2-失败
     *
     * @param bussStatus 业务状态: 0-确认中 1-成功 2-失败
     */
    public void setBussStatus(String bussStatus) {
        this.bussStatus = bussStatus == null ? null : bussStatus.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}