package com.goforit.jgr.taskhandle.filter;

import com.goforit.jgr.taskhandle.annotation.AnnotationUtil;
import com.goforit.jgr.taskhandle.annotation.TaskMapperAnnotation;
import com.goforit.jgr.taskhandle.factory.TimeoutCallbackProcessFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.Map;

/**
 * Created by junqingfjq on 16/5/11.
 */
public class TimeoutTaskBeanPostProcessor implements BeanPostProcessor {

    private static final Logger LOGGER= LoggerFactory.getLogger(TimeoutTaskBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        try{
            Map<String,Object> proMap=AnnotationUtil.INSTANCE.loadMethodAnnotationValues(TaskMapperAnnotation.class,bean.getClass().getName());

            TaskTimeoutProcessInfo taskTimeoutProcessInfo=new TaskTimeoutProcessInfo();
            //TODO 设置属性
            taskTimeoutProcessInfo.setCreateTaskMethodName((String)proMap.get(""));

            TimeoutCallbackProcessFactory.INSTANCE.register("xxx","xxx",taskTimeoutProcessInfo);


            //TODO 返回一个代理bean

        }catch (Exception e){
            LOGGER.error("");
        }

        return bean;
    }
}
