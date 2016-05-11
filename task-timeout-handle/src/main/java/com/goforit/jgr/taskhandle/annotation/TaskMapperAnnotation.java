package com.goforit.jgr.taskhandle.annotation;

import java.lang.annotation.*;

/**
 * Created by junqingfjq on 16/5/11.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TaskMapperAnnotation {

    String createMethodName() default "create";

    String taskTypeName() default "";

    String timeoutColumnName() default "";

    String gmtCreateColumnName() default "";
}
