package com.goforit.jgr.tpmonitor.spring;

import com.goforit.jgr.tpmonitor.monitor.ThreadPoolMonitorSet;
import com.goforit.jgr.tpmonitor.utils.AnnotationUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * Created by junqingfjq on 16/6/3.
 */

//TODO bean写入到配置文件
@Service
public class ThreadPoolMonitorAnnotationProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        try{
            Map<String,Object> annMap=AnnotationUtil.loadClassAnnotationValues(bean.getClass(), "threadPoolName", bean.getClass().getName());

            if(!CollectionUtils.isEmpty(annMap) ){
                ThreadPoolMonitorSet.INSTANCE.register((String)annMap.get("threadPoolName"),bean);
            }
        }catch (Exception e){
            //TODO log

        }

        return bean;
    }
}
