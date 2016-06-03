package com.goforit.jgr.tpmonitor.facade;

import com.goforit.jgr.tpmonitor.facade.model.ThreadPoolInformation;

import java.util.List;

/**
 * Created by junqingfjq on 16/6/2.
 */
public interface ThreadPoolMonitorFacade {

    ThreadPoolInformation getThreadPoolRunTimeInformation(String threadPoolName);

    List<ThreadPoolInformation> getAllThreadPoolRunTimeInformation();

    ThreadPoolInformation registerThreadPoolMonitor(String threadPoolName,String beanName);

}
