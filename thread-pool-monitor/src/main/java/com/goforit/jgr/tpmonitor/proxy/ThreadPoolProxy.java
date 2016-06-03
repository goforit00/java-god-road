package com.goforit.jgr.tpmonitor.proxy;


import com.goforit.jgr.tpmonitor.facade.model.ThreadPoolInformation;

import java.lang.reflect.Method;

/**
 * Created by junqingfjq on 16/6/3.
 */
public class ThreadPoolProxy {

    private Object threadPoolObject;

    public ThreadPoolProxy(Object threadPoolObject){
        this.threadPoolObject=threadPoolObject;
    }

    public int getThreadNum(){
        try{
            Object threadNum=invokeFunc("getPoolSize").invoke(threadPoolObject);
            return (Integer)threadNum;
        }catch (Exception e){
            //TODO log
            return -1;
        }
    }

    public int getCoreThreadNum(){
        try{
            Object coreThreadNum=invokeFunc("getCorePoolSize").invoke(threadPoolObject);
            return (Integer)coreThreadNum;
        }catch (Exception e){
            //TODO log
            return -1;
        }
    }

    public int getMaxThreadNum(){
        try{
            Object maxThreadNum = invokeFunc("getMaximumPoolSize").invoke(threadPoolObject);
            return (Integer)maxThreadNum;
        }catch (Exception e){
            //TODO log
            return -1;
        }
    }

    public int getQueueLength(){
        try{
            Object queue=invokeFunc("getQueue").invoke(threadPoolObject);
            Object queueLength=invokeFunc("size").invoke(queue);
            return (Integer)queueLength;
        }catch (Exception e){
            //TODO log
            return -1;
        }
    }

    public ThreadPoolInformation buildThreadPoolInformation(){
        ThreadPoolInformation threadPoolInformation=new ThreadPoolInformation();
        threadPoolInformation.setCoreThreadNum(getCoreThreadNum());
        threadPoolInformation.setMaxThreadNum(getMaxThreadNum());
        threadPoolInformation.setQueueLength(getQueueLength());
        threadPoolInformation.setThreadNum(getThreadNum());
        return threadPoolInformation;
    }



    private Method invokeFunc(String funcName,Class<?>... parameterTypes) throws NoSuchMethodException{
            return threadPoolObject.getClass().getMethod(funcName,parameterTypes);
    }
}
