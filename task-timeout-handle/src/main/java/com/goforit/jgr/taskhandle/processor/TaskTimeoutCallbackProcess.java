package com.goforit.jgr.taskhandle.processor;

/**
 * Created by junqingfjq on 16/5/11.
 */
public interface TaskTimeoutCallbackProcess {

    CallbackResultType process(String taskId);
}
