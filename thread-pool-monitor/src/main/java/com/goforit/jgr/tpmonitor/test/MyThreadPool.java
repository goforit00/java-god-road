package com.goforit.jgr.tpmonitor.test;

import org.springframework.stereotype.Service;

import com.goforit.jgr.tpmonitor.annotation.ThreadPoolMonitorAnnotation;

/**
 * Created by junqingfjq on 16/6/3.
 */

@ThreadPoolMonitorAnnotation(threadPoolName = "myThreadPool")
@Service
public class MyThreadPool {
}
