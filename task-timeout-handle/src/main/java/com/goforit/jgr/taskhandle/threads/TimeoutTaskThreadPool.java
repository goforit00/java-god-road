package com.goforit.jgr.taskhandle.threads;

import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by junqingfjq on 16/5/20.
 */

@Service(value = "timeoutTaskThreadPool")
public class  TimeoutTaskThreadPool {

    private int corePoolSize=2;
    
    private int maxPoolSize=4;
    
    private int blockQueueSize=100;

    private ThreadPoolExecutor threadPoolExecutor=null;
    
    public TimeoutTaskThreadPool() {
        threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, 0, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(blockQueueSize));

    }

    public void execute(Runnable runnable){
        threadPoolExecutor.execute(runnable);
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public void setBlockQueueSize(int blockQueueSize) {
        this.blockQueueSize = blockQueueSize;
    }
}
