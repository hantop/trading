package com.jinhui.zlrt.entity.domain;

import java.util.Date;

public class BatchState {
    private Integer batchCode;

    private Date date;

    private Date createTime;

    public Integer getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(Integer batchCode) {
        this.batchCode = batchCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BatchState{" +
                "batchCode=" + batchCode +
                ", date=" + date +
                ", createTime=" + createTime +
                '}';
    }
}