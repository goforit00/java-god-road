package com.goforit.jgr.taskhandle.manager;

import com.goforit.jgr.taskhandle.model.TaskTimeoutInfo;

import java.util.List;

/**
 * Created by junqingfjq on 16/5/20.
 */
public interface TimeoutTaskManager {

    List<TaskTimeoutInfo> findTimeoutTasksByHost(String ip);

    TaskTimeoutInfo updateTimeoutTaskInfo(TaskTimeoutInfo taskTimeoutInfo);

    void updateTimeoutTaskStatus(boolean status,String msg);

    //TODO 参数缺少，需要加入table name , status column name;
    String findTaskStatus(String taskId);

}
