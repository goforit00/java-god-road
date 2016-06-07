package com.goforit.jgr.tpmonitor;

/**
 * Created by junqingfjq on 16/6/7.
 */

public class MyThreadPool {

    public static MyThreadPool getInstance(){
        return new MyThreadPool();
    }

    private MyThreadPool(){

    }

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
