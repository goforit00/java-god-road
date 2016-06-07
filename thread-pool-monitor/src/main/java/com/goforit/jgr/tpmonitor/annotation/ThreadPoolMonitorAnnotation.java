package com.goforit.jgr.tpmonitor.annotation;

import java.lang.annotation.*;

/**
 * Created by junqingfjq on 16/6/2.
 */

//注解可以打在类名上（保证要是bean）,或者是bean中的一个ThreadPool实例的属性上

@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ThreadPoolMonitorAnnotation {

    public String threadPoolName() default "threadPoolName";

}
