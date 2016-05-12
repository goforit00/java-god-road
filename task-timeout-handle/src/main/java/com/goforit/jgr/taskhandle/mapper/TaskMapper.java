package com.goforit.jgr.taskhandle.mapper;

import com.goforit.jgr.taskhandle.annotation.TaskMapperAnnotation;

/**
 * Created by junqingfjq on 16/5/12.
 */
public interface TaskMapper {

    @TaskMapperAnnotation(createMethodName = "create", tableName = "task", taskIdColumnName = "id", taskType = "ecs", taskCreateTimeColumnName = "gmtCreated", timeout = 20, finishStatusList = "CREATED_FINISH", timeoutCallbackProcessBeanName = "xxxxCallbackProcessBeanName")
    void create(Object obj);
}
