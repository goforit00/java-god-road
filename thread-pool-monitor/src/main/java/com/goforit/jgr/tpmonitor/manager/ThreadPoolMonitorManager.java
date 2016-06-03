package com.goforit.jgr.tpmonitor.manager;

import com.goforit.jgr.tpmonitor.facade.model.ThreadPoolInformation;

import java.util.List;

/**
 * Created by junqingfjq on 16/6/3.
 */
public interface ThreadPoolMonitorManager {

    ThreadPoolInformation getInformationByName(String name);

    List<ThreadPoolInformation> getAllInformation();

    ThreadPoolInformation registerThreadPoolMonitor(String threadPoolName,String beanId);
}
