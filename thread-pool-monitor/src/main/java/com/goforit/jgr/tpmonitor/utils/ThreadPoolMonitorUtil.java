package com.goforit.jgr.tpmonitor.utils;

import com.goforit.jgr.tpmonitor.monitor.ThreadPoolMonitorSet;

/**
 * Created by junqingfjq on 16/6/3.
 */
public class ThreadPoolMonitorUtil {

    public static boolean register(String threadPoolName,Object threadPoolObject){
        return ThreadPoolMonitorSet.INSTANCE.register(threadPoolName,threadPoolObject);
    }
}
