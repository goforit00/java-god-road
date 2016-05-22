package com.goforit.jgr.taskhandle.mapper;

import com.goforit.jgr.taskhandle.model.TaskTimeoutInfo;

import java.util.List;

/**
 * Created by junqingfjq on 16/5/20.
 */
public interface TimeoutTaskMapper {

    List<TaskTimeoutInfo> findTimeoutTaskByHost(String ip);

    int updateTimeoutTask(TaskTimeoutInfo taskTimeoutInfo);

    String findTaskStatus(String taskId);
}
