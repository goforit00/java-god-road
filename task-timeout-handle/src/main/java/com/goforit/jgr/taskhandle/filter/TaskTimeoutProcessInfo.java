package com.goforit.jgr.taskhandle.filter;

import java.util.List;

/**
 * Created by junqingfjq on 16/5/12.
 */
public class TaskTimeoutProcessInfo {

    private String createTaskMethodName;

    private String taskTableName;

    private String taskIdColumnName;

    private String taskCreateTimeColumnName;

    //单位秒
    private int timeout;

    private String statusColumnName;

    private List<String> finishStatusList;

    private String taskType;

    private String timeoutCallbackProcessBeanName;

    //TODO constructor

    public String getCreateTaskMethodName() {
        return createTaskMethodName;
    }

    public void setCreateTaskMethodName(String createTaskMethodName) {
        this.createTaskMethodName = createTaskMethodName;
    }

    public String getTaskTableName() {
        return taskTableName;
    }

    public void setTaskTableName(String taskTableName) {
        this.taskTableName = taskTableName;
    }

    public String getTaskIdColumnName() {
        return taskIdColumnName;
    }

    public void setTaskIdColumnName(String taskIdColumnName) {
        this.taskIdColumnName = taskIdColumnName;
    }

    public String getTaskCreateTimeColumnName() {
        return taskCreateTimeColumnName;
    }

    public void setTaskCreateTimeColumnName(String taskCreateTimeColumnName) {
        this.taskCreateTimeColumnName = taskCreateTimeColumnName;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getStatusColumnName() {
        return statusColumnName;
    }

    public void setStatusColumnName(String statusColumnName) {
        this.statusColumnName = statusColumnName;
    }

    public List<String> getFinishStatusList() {
        return finishStatusList;
    }

    public void setFinishStatusList(List<String> finishStatusList) {
        this.finishStatusList = finishStatusList;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTimeoutCallbackProcessBeanName() {
        return timeoutCallbackProcessBeanName;
    }

    public void setTimeoutCallbackProcessBeanName(String timeoutCallbackProcessBeanName) {
        this.timeoutCallbackProcessBeanName = timeoutCallbackProcessBeanName;
    }
}
