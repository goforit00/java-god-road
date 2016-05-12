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

    String tableName() default "task";

    String taskIdColumnName() default "id";

    String taskType() default "";

    String taskCreateTimeColumnName() default "gmtCreated";

    int timeout() default 10;

    String statusColumnName() default "status";

    //多个以逗号分隔
    String finishStatusList() default "FINISH";

    String timeoutCallbackProcessBeanName() default "";
}
