package com.goforit.jgr.tpmonitor.test;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by junqingfjq on 16/6/3.
 */
public class ThreadPoolTest {

    public static void main(String argv[]){
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(1,1,1, TimeUnit.SECONDS,null);
        threadPoolExecutor.getActiveCount();
        threadPoolExecutor.getCorePoolSize();
        threadPoolExecutor.getCompletedTaskCount();
        threadPoolExecutor.getMaximumPoolSize();
        threadPoolExecutor.getPoolSize();
        threadPoolExecutor.getQueue().size();
        threadPoolExecutor.getLargestPoolSize();
    }
}
