package com.goforit.jgr.tpmonitor;

/**
 * Created by junqingfjq on 16/6/7.
 */
public class MyThread implements Runnable {
    @Override
    public void run() {
        try{
            Thread.sleep(10);
            System.err.println("thread id:"+Thread.currentThread().getId());
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
