package com.goforit.jgr.taskhandle.model;

import java.util.Date;
import java.util.List;

/**
 * Created by junqingfjq on 16/5/12.
 */
public class TaskTimeoutInfo {

    private String id;

    private String tableName;

    private String taskType;

    private String taskId;

    private Date expireDate;

    private List<String> taskFinishedStatus;

    //是否结束（结束的标识有：超时已处理完毕，未超时状态已终止）
    private boolean isFinished;

    private String hostIp;

    //处理次数（默认为0）
    private int remainHandleTimes;

    private String msg;

    private Date gmtCreated;

    private Date gmtModified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public List<String> getTaskFinishedStatus() {
        return taskFinishedStatus;
    }

    public void setTaskFinishedStatus(List<String> taskFinishedStatus) {
        this.taskFinishedStatus = taskFinishedStatus;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public int getRemainHandleTimes() {
        return remainHandleTimes;
    }

    public void setRemainHandleTimes(int remainHandleTimes) {
        this.remainHandleTimes = remainHandleTimes;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
