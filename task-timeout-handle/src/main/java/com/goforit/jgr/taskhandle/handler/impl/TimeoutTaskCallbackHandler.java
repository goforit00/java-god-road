package com.goforit.jgr.taskhandle.handler.impl;

import com.goforit.jgr.taskhandle.manager.TimeoutTaskManager;
import com.goforit.jgr.taskhandle.processor.CallbackResultType;
import com.goforit.jgr.taskhandle.processor.TaskTimeoutCallbackProcess;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goforit.jgr.taskhandle.factory.TimeoutCallbackProcessFactory;
import com.goforit.jgr.taskhandle.factory.TimeoutTaskHandlerFactory;
import com.goforit.jgr.taskhandle.filter.TaskTimeoutProcessInfo;
import com.goforit.jgr.taskhandle.handler.TimeoutTaskHandler;
import com.goforit.jgr.taskhandle.handler.type.TimeoutTaskHandlerType;
import com.goforit.jgr.taskhandle.model.TaskTimeoutInfo;

/**
 * Created by junqingfjq on 16/5/20.
 */

@Service(value = "timeoutTaskCallbackHandler")
public class TimeoutTaskCallbackHandler implements TimeoutTaskHandler,InitializingBean {

    private static final Logger LOGGER= LoggerFactory.getLogger(TimeoutTaskCallbackHandler.class);

    @Autowired
    private TimeoutTaskManager timeoutTaskManager;

    @Override
    public void handle(TaskTimeoutInfo taskTimeoutInfo) {
        //TODO 超时任务 回调 处理

        final String tableName=taskTimeoutInfo.getTableName();
        final String taskType=taskTimeoutInfo.getTaskType();

        if(StringUtils.isBlank(tableName) || StringUtils.isBlank(taskType)){
            final String msg=taskTimeoutInfo+". table name or task type can't be null.";
            LOGGER.error(msg);
            throw new RuntimeException(msg);
        }

        TaskTimeoutProcessInfo taskTimeoutProcessInfo= TimeoutCallbackProcessFactory.INSTANCE.getProcessor(tableName,taskType);
        if(null==taskTimeoutInfo){
            final String msg="not find TaskTimeoutProcessInfo by "+tableName+" "+taskType;
            LOGGER.error(msg);
            throw new RuntimeException(msg);
        }

        TaskTimeoutCallbackProcess callbackProcess=taskTimeoutProcessInfo.getTaskTimeoutCallbackProcess();
        if(null==callbackProcess){
            final String msg="not find callbackProcess by "+tableName+" "+taskType;
            LOGGER.error(msg);
            throw new RuntimeException(msg);
        }

        CallbackResultType resultType =callbackProcess.process(taskTimeoutInfo.getTaskId());
        if(resultType==CallbackResultType.RETRY){
            LOGGER.info("xxx");
            if(taskTimeoutInfo.getRemainHandleTimes()>0){
                taskTimeoutInfo.setRemainHandleTimes(taskTimeoutInfo.getRemainHandleTimes());
                timeoutTaskManager.updateTimeoutTaskInfo(taskTimeoutInfo);
            }else {
                taskTimeoutInfo.setMsg("no more time to retry");
                taskTimeoutInfo.setFinished(true);
                timeoutTaskManager.updateTimeoutTaskInfo(taskTimeoutInfo);
            }

        }else if(resultType==CallbackResultType.FINISH) {
            timeoutTaskManager.updateTimeoutTaskStatus(true,"");
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        TimeoutTaskHandlerFactory.INSTANCE.register(TimeoutTaskHandlerType.TIMEOUT_CALLBACK,this);
    }
}
