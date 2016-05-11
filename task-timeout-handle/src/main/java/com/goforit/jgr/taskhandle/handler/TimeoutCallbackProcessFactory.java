package com.goforit.jgr.taskhandle.handler;

import com.goforit.jgr.taskhandle.processor.CallbackProcess;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by junqingfjq on 16/5/11.
 */
public enum TimeoutCallbackProcessFactory {

    INSTANCE{

        private Map<String,CallbackProcess> callbackMap=new ConcurrentHashMap<String, CallbackProcess>();

        @Override
        void register(String tableName,String taskType,CallbackProcess process) throws Exception{
            String key=tableName+"+"+taskType;
            if(null!=callbackMap.get(key)){
                throw new RuntimeException("");
            }
        }

        @Override
        CallbackProcess getProcessor(String tableName,String taskType) {
            return null;
        }
    };

    abstract void register(String tableName,String taskType,CallbackProcess process) throws Exception;

    abstract CallbackProcess getProcessor(String tableName,String taskType);
}
