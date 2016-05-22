package com.goforit.jgr.taskhandle.handler.impl;

import com.goforit.jgr.taskhandle.factory.TimeoutTaskHandlerFactory;
import com.goforit.jgr.taskhandle.handler.TimeoutTaskHandler;
import com.goforit.jgr.taskhandle.handler.type.TimeoutTaskHandlerType;
import com.goforit.jgr.taskhandle.manager.TimeoutTaskManager;
import com.goforit.jgr.taskhandle.model.TaskTimeoutInfo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by junqingfjq on 16/5/21.
 */

@Service(value = "notFindTaskHandler")
public class NotFindTaskHandler implements TimeoutTaskHandler,InitializingBean {

    @Autowired
    private TimeoutTaskManager timeoutTaskManager;

    @Override
    public void handle(TaskTimeoutInfo taskTimeoutInfo) {
        //更新 taskInfo 状态
        timeoutTaskManager.updateTimeoutTaskStatus(true,"not find task by id");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        TimeoutTaskHandlerFactory.INSTANCE.register(TimeoutTaskHandlerType.TASK_NOT_FIND,this);
    }
}
