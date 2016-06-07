package com.goforit.jgr.tpmonitor.proxy;


import com.goforit.jgr.tpmonitor.facade.model.ThreadPoolInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by junqingfjq on 16/6/3.
 */
public class ThreadPoolProxy {

    private static final Logger LOGGER= LoggerFactory.getLogger(ThreadPoolProxy.class);

    private Object threadPoolObject;

    public ThreadPoolProxy(Object threadPoolObject){
        this.threadPoolObject=threadPoolObject;
    }

    public int getThreadNum(){
        try{
            Object threadNum=invokeFunc(threadPoolObject,"getPoolSize").invoke(threadPoolObject);
            return (Integer)threadNum;
        }catch (Exception e){
            //TODO log
            LOGGER.error("",e);
            return -1;
        }
    }

    public int getCoreThreadNum(){
        try{
            Object coreThreadNum=invokeFunc(threadPoolObject,"getCorePoolSize").invoke(threadPoolObject);
            return (Integer)coreThreadNum;
        }catch (Exception e){
            //TODO log
            LOGGER.error("",e);
            return -1;
        }
    }

    public int getMaxThreadNum(){
        try{
            Object maxThreadNum = invokeFunc(threadPoolObject,"getMaximumPoolSize").invoke(threadPoolObject);
            return (Integer)maxThreadNum;
        }catch (Exception e){
            //TODO log
            LOGGER.error("",e);
            return -1;
        }
    }

    public int getQueueLength(){
        try{
            Object queue=invokeFunc(threadPoolObject,"getQueue").invoke(threadPoolObject);
            Object queueLength=invokeFunc(queue,"size").invoke(queue);
            return (Integer)queueLength;
        }catch (Exception e){
            //TODO log
            LOGGER.error("",e);
            e.printStackTrace();

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



    private Method invokeFunc(Object obj,String funcName,Class<?>... parameterTypes) throws NoSuchMethodException{
            return obj.getClass().getMethod(funcName,parameterTypes);
    }
}
