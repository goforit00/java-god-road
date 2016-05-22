package com.goforit.jgr.taskhandle.handler;

import com.goforit.jgr.taskhandle.model.TaskTimeoutInfo;

/**
 * Created by junqingfjq on 16/5/20.
 */
public interface TimeoutTaskHandler {

    void handle(TaskTimeoutInfo taskTimeoutInfo);
}
