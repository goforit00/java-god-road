package com.goforit.jgr.tpmonitor.spring;

import com.goforit.jgr.tpmonitor.annotation.ThreadPoolMonitorAnnotation;
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
    public Object postProcessBeforeInitialization(Object bean, String beanName)
                                                                               throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
                                                                              throws BeansException {

        try {
            //类上的注解
            Object annClassValue = AnnotationUtil.loadClassAnnotationValues(ThreadPoolMonitorAnnotation.class.getClass(),
                    "threadPoolName", bean.getClass().getName());
            if (null!=annClassValue) {
                ThreadPoolMonitorSet.INSTANCE.register((String) annClassValue, bean);
            }

            //属性上的注解
            Map<String, Object> annFieldMap = AnnotationUtil.loadFieldsAnnotationValues(
                ThreadPoolMonitorAnnotation.class, "threadPoolName", bean.getClass().getName());
            if(!CollectionUtils.isEmpty(annFieldMap)){
                for(Map.Entry<String,Object> entry:annFieldMap.entrySet()){

                    String fieldName=entry.getKey();
                    Object objRef=bean.getClass().getField(fieldName).get(bean);
                    if(null!=objRef){
                        ThreadPoolMonitorSet.INSTANCE.register((String)entry.getValue(),objRef);
                    }else {
                        //TODO Log
                    }
                }
            }
        } catch (Exception e) {
            //TODO log

        }

        return bean;
    }
}
