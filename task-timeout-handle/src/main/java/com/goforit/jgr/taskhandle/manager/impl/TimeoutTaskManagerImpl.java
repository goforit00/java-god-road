package com.goforit.jgr.taskhandle.manager.impl;

import com.goforit.jgr.taskhandle.manager.TimeoutTaskManager;
import com.goforit.jgr.taskhandle.model.TaskTimeoutInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by junqingfjq on 16/5/20.
 */

@Service(value = "timeoutTaskManager")
public class TimeoutTaskManagerImpl implements TimeoutTaskManager {
    @Override
    public List<TaskTimeoutInfo> findTimeoutTasksByHost(String ip) {
        return null;
    }

    @Override
    public TaskTimeoutInfo updateTimeoutTaskInfo(TaskTimeoutInfo taskTimeoutInfo) {
        return null;
    }

    @Override
    public void updateTimeoutTaskStatus(boolean status, String msg) {

    }

//    @Override
    public void updateTimeoutTaskStatus(boolean status) {

    }

    @Override
    public String findTaskStatus(String taskId) {
        return null;
    }
}
