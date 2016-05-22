package com.goforit.jgr.taskhandle.quartz;

import java.util.List;

import com.goforit.jgr.taskhandle.threads.TaskTimeoutInfoHandler;
import com.goforit.jgr.taskhandle.threads.TimeoutTaskThreadPool;
import org.apache.commons.lang3.StringUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goforit.jgr.taskhandle.manager.TimeoutTaskManager;
import com.goforit.jgr.taskhandle.model.TaskTimeoutInfo;
import com.goforit.jgr.taskhandle.util.HostUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by junqingfjq on 16/5/12.
 */
public class TaskTimeoutCheckerJob implements Job {

    private static final Logger LOGGER= LoggerFactory.getLogger(TaskTimeoutCheckerJob.class);

    @Autowired
    private TimeoutTaskManager timeoutTaskManager;

    @Autowired
    private TimeoutTaskThreadPool timeoutTaskThreadPool;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        String localIp=HostUtil.getIp();
        if(StringUtils.isBlank(localIp)){
            LOGGER.error("not find local ip");
            return;
        }
        //1. 扫描表，检录出超时的任务
        List<TaskTimeoutInfo> taskTimeoutInfos= timeoutTaskManager.findTimeoutTasksByHost(localIp);

        //2. 分发任务进行处理（使用队列）
        for(TaskTimeoutInfo task:taskTimeoutInfos){
            timeoutTaskThreadPool.execute(new TaskTimeoutInfoHandler(task,timeoutTaskManager));
        }

    }
}
