package com.goforit.jgr.tpmonitor;

import com.goforit.jgr.tpmonitor.annotation.ThreadPoolMonitorAnnotation;
import org.springframework.stereotype.Service;

/**
 * Created by junqingfjq on 16/6/7.
 */
@ThreadPoolMonitorAnnotation(threadPoolName = "myThreadPool2")
@Service(value = "myThreadPool2")
public class MyThreadPool2 {

    public int getActiveCount(){
        return 10;
    }

    public int getCorePoolSize(){
        return 10;
    }

    public int getCompletedTaskCount(){
        return 10;
    }

    public int getMaximumPoolSize(){
        return 10;
    }
    public int getPoolSize(){
        return 10;
    }
    public Queue getQueue(){
        return new Queue();
    }
    public int getLargestPoolSize(){
        return 10;
    }
}
