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
 * Created by junqingfjq on 16/5/20.
 */

@Service(value = "finishTaskHandler")
public class FinishTaskHandler implements TimeoutTaskHandler,InitializingBean {

    @Autowired
    private TimeoutTaskManager timeoutTaskManager;

    @Override
    public void handle(TaskTimeoutInfo taskTimeoutInfo) {
        //TODO 更新状态到完成

        timeoutTaskManager.updateTimeoutTaskStatus(true,"");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        TimeoutTaskHandlerFactory.INSTANCE.register(TimeoutTaskHandlerType.FINISHED,this);
    }
}
