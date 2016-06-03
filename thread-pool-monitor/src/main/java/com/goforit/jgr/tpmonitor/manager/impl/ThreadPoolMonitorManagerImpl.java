package com.goforit.jgr.tpmonitor.manager.impl;

import com.goforit.jgr.tpmonitor.facade.model.ThreadPoolInformation;
import com.goforit.jgr.tpmonitor.manager.ThreadPoolMonitorManager;
import com.goforit.jgr.tpmonitor.monitor.ThreadPoolMonitorSet;
import com.goforit.jgr.tpmonitor.proxy.ThreadPoolProxy;
import com.goforit.jgr.tpmonitor.spring.SpringContextUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by junqingfjq on 16/6/3.
 */

@Service(value = "threadPoolMonitorManager")
public class ThreadPoolMonitorManagerImpl implements ThreadPoolMonitorManager {

    @Override
    public ThreadPoolInformation getInformationByName(String name) {

        Object threadPoolObject=ThreadPoolMonitorSet.INSTANCE.getThreadPoolObject(name);
        if(null==threadPoolObject){
            //TODO log
            return null;
        }

        return buildThreadPoolInformation(name,threadPoolObject);
    }

    @Override
    public List<ThreadPoolInformation> getAllInformation() {
        Map<String,Object> threadPoolMap=ThreadPoolMonitorSet.INSTANCE.getAllThreadPools();
        List<ThreadPoolInformation> threadPoolInformationList=new ArrayList<ThreadPoolInformation>();

        for(Map.Entry<String,Object> entry:threadPoolMap.entrySet()){

            ThreadPoolInformation threadPoolInformation=buildThreadPoolInformation(entry.getKey(),entry.getValue());
            threadPoolInformationList.add(threadPoolInformation);
        }
        return threadPoolInformationList;
    }

    @Override
    public ThreadPoolInformation registerThreadPoolMonitor(String threadPoolName, String beanId) {

        Object threadPoolObject=ThreadPoolMonitorSet.INSTANCE.getThreadPoolObject(threadPoolName);
        if(null!=threadPoolObject){
            //已经注册
            //TODO log
            return null;
        }

        //TODO get thread pool bean
        threadPoolObject=SpringContextUtil.getBeanById(beanId);
        if(null==threadPoolObject){
            //未获得bean
            //TODO log
            return null;
        }

        ThreadPoolMonitorSet.INSTANCE.register(threadPoolName,threadPoolObject);

        return getInformationByName(threadPoolName);
    }

    private ThreadPoolInformation buildThreadPoolInformation(String name,Object threadPoolObject){
        ThreadPoolProxy threadPoolProxy=new ThreadPoolProxy(threadPoolObject);
        ThreadPoolInformation threadPoolInformation=threadPoolProxy.buildThreadPoolInformation();
        threadPoolInformation.setName(name);

        return threadPoolInformation;
    }
}
