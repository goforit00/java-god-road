package com.goforit.jgr.taskhandle.factory;

import com.goforit.jgr.taskhandle.handler.TimeoutTaskHandler;
import com.goforit.jgr.taskhandle.handler.type.TimeoutTaskHandlerType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by junqingfjq on 16/5/21.
 */
public enum  TimeoutTaskHandlerFactory {

    INSTANCE {

        private Map<TimeoutTaskHandlerType, TimeoutTaskHandler> handlerMap = new ConcurrentHashMap<TimeoutTaskHandlerType, TimeoutTaskHandler>();

        @Override
        public void register(TimeoutTaskHandlerType type, TimeoutTaskHandler handler) {
            handlerMap.put(type,handler);
        }

        @Override
        public TimeoutTaskHandler getHandler(TimeoutTaskHandlerType type) {
            return handlerMap.get(type);
        }
    };

    abstract public void register(TimeoutTaskHandlerType type,TimeoutTaskHandler handler);

    abstract public TimeoutTaskHandler getHandler(TimeoutTaskHandlerType type);
}
