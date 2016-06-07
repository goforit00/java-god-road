package com.goforit.jgr.tpmonitor;

import com.goforit.jgr.tpmonitor.facade.register.AbstractThreadPoolMonitorRegister;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by junqingfjq on 16/6/7.
 */

@Service
public class MyThreadPoolRegister extends AbstractThreadPoolMonitorRegister{
    @Override
    protected Map<String, Object> addThreadPool() {
        Map<String,Object> threadPoolMap=new HashMap<String, Object>();
        threadPoolMap.put("myThreadPool",MyThreadPool.getInstance());
        return threadPoolMap;
    }
}
