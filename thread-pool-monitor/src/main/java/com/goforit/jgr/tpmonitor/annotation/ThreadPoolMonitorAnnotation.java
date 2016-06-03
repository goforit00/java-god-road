package com.goforit.jgr.tpmonitor.annotation;

import java.lang.annotation.*;

/**
 * Created by junqingfjq on 16/6/2.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ThreadPoolMonitorAnnotation {

    String threadPoolName() default "threadPoolName";

}
