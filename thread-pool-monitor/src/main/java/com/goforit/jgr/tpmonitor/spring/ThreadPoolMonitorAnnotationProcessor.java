package com.goforit.jgr.tpmonitor.spring;

import com.goforit.jgr.tpmonitor.annotation.ThreadPoolMonitorAnnotation;
import com.goforit.jgr.tpmonitor.monitor.ThreadPoolMonitorSet;
import com.goforit.jgr.tpmonitor.utils.AnnotationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by junqingfjq on 16/6/3.
 */

//TODO bean写入到配置文件
@Service
public class ThreadPoolMonitorAnnotationProcessor implements BeanPostProcessor {

    private static final Logger LOGGER= LoggerFactory.getLogger(ThreadPoolMonitorAnnotationProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
                                                                               throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
                                                                              throws BeansException {

        try {
            //类上的注解
            System.err.println("in postProcessAfterInitialization bean name="+beanName);

            Object annClassValue = AnnotationUtil.loadClassAnnotationValues(ThreadPoolMonitorAnnotation.class,
                    "threadPoolName", bean.getClass().getName());
            if (null!=annClassValue) {
                System.err.println("in postProcessAfterInitialization to register bean ="+beanName);

                ThreadPoolMonitorSet.INSTANCE.register((String) annClassValue, bean);
            }

            //属性上的注解
            Map<String, Object> annFieldMap = AnnotationUtil.loadFieldsAnnotationValues(
                ThreadPoolMonitorAnnotation.class, "threadPoolName", bean.getClass().getName());
            if(!CollectionUtils.isEmpty(annFieldMap)){
                for(Map.Entry<String,Object> entry:annFieldMap.entrySet()){

                    String fieldName=entry.getKey();
                    System.err.println("class:"+bean.getClass().getName());
                    Field field=bean.getClass().getDeclaredField(fieldName);
                    field.setAccessible(true);
                    Object objRef=field.get(bean);
                    if(null!=objRef){
                        ThreadPoolMonitorSet.INSTANCE.register((String)entry.getValue(),objRef);
                    }else {
                        //TODO Log
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            LOGGER.error("in postProcessAfterInitialization exception",e);
            //TODO log

        }

        return bean;
    }
}
