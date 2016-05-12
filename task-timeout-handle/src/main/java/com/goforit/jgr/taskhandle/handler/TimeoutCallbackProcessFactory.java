package com.goforit.jgr.taskhandle.handler;

import com.goforit.jgr.taskhandle.filter.TaskTimeoutProcessInfo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by junqingfjq on 16/5/11.
 */
public enum TimeoutCallbackProcessFactory {

    INSTANCE{

        private Map<String,TaskTimeoutProcessInfo> callbackMap=new ConcurrentHashMap<String, TaskTimeoutProcessInfo>();

        @Override
        public void register(String tableName,String taskType,TaskTimeoutProcessInfo taskTimeoutProcessInfo) throws Exception{

        }

        @Override
        public TaskTimeoutProcessInfo getProcessor(String tableName,String taskType) {
            return null;
        }
    };

    abstract public void register(String tableName,String taskType,TaskTimeoutProcessInfo taskTimeoutProcessInfo) throws Exception;

    abstract public TaskTimeoutProcessInfo getProcessor(String tableName,String taskType);

}
