package com.goforit.jgr.taskhandle.threads;

import com.goforit.jgr.taskhandle.handler.type.TimeoutTaskHandlerType;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goforit.jgr.taskhandle.factory.TimeoutTaskHandlerFactory;
import com.goforit.jgr.taskhandle.manager.TimeoutTaskManager;
import com.goforit.jgr.taskhandle.model.TaskTimeoutInfo;

/**
 * Created by junqingfjq on 16/5/20.
 */
public class TaskTimeoutInfoHandler implements Runnable {

    private static final Logger LOGGER= LoggerFactory.getLogger(TaskTimeoutInfoHandler.class);

    private TaskTimeoutInfo taskTimeoutInfo;

    private TimeoutTaskManager timeoutTaskManager;

    public TaskTimeoutInfoHandler(TaskTimeoutInfo taskTimeoutInfo,TimeoutTaskManager timeoutTaskManager){
        this.taskTimeoutInfo=taskTimeoutInfo;
        this.timeoutTaskManager=timeoutTaskManager;
    }

    @Override
    public void run() {
        String status=timeoutTaskManager.findTaskStatus(taskTimeoutInfo.getTaskId());

        //如果task 不存在
        if(StringUtils.isBlank(status)){
            LOGGER.error("not find task by id "+taskTimeoutInfo.getTaskId());

            TimeoutTaskHandlerFactory.INSTANCE.getHandler(TimeoutTaskHandlerType.TASK_NOT_FIND)
                .handle(taskTimeoutInfo);
            return;
        }


        //如果任务已经处理完成
        if(taskTimeoutInfo.getTaskFinishedStatus().contains(status)){
            TimeoutTaskHandlerFactory.INSTANCE.getHandler(TimeoutTaskHandlerType.FINISHED).handle(taskTimeoutInfo);
            return;
        }else {
            //如果 task未处理完，则调用回调
            TimeoutTaskHandlerFactory.INSTANCE.getHandler(TimeoutTaskHandlerType.TIMEOUT_CALLBACK).handle(taskTimeoutInfo);
        }



    }
}
