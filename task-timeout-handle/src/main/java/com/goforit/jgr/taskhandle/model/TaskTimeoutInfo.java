package com.goforit.jgr.taskhandle.model;

import java.util.Date;

/**
 * Created by junqingfjq on 16/5/12.
 */
public class TaskTimeoutInfo {

    private String id;

    private String tableName;

    private String taskId;

    private Date expireDate;

    private String taskStatus;

    private String taskType;

    //是否结束（结束的标识有：超时已处理完毕，未超时状态已终止）
    private boolean isFinished;

    private String hostIp;

    //处理次数（默认为0）
    private String handleTimes;

    private Date gmtCreated;

    private Date gmtModified;

}
