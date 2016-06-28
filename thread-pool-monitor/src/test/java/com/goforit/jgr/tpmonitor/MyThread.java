package com.goforit.jgr.tpmonitor;

import java.util.Date;

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

        public  static void main(String argv[]){
//            Map<String,String> map=new HashMap<String, String>();
//            map.put("1","1");
//
//            Map<String,String> linkedMap=new LinkedHashMap<String, String>();
//            linkedMap.put("1","1");

            System.err.println(new Date(0));
    }
}
