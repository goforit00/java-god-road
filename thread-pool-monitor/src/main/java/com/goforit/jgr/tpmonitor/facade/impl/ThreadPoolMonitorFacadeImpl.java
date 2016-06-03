package com.goforit.jgr.tpmonitor.facade.impl;

import com.goforit.jgr.tpmonitor.facade.ThreadPoolMonitorFacade;
import com.goforit.jgr.tpmonitor.facade.model.ThreadPoolInformation;
import com.goforit.jgr.tpmonitor.manager.ThreadPoolMonitorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by junqingfjq on 16/6/3.
 */

@Service
public class ThreadPoolMonitorFacadeImpl implements ThreadPoolMonitorFacade {

    @Autowired
    private ThreadPoolMonitorManager threadPoolMonitorManager;

    @Override
    public ThreadPoolInformation getThreadPoolRunTimeInformation(String threadPoolName) {
        return threadPoolMonitorManager.getInformationByName(threadPoolName);
    }

    @Override
    public List<ThreadPoolInformation> getAllThreadPoolRunTimeInformation() {
        return threadPoolMonitorManager.getAllInformation();
    }

    @Override
    public ThreadPoolInformation registerThreadPoolMonitor(String threadPoolName, String beanId) {
        return threadPoolMonitorManager.registerThreadPoolMonitor(threadPoolName,beanId);
    }
}
