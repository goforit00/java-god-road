package com.goforit.jgr.taskhandle.quartz;

import com.goforit.jgr.taskhandle.handler.TimeoutCallbackProcessFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by junqingfjq on 16/5/12.
 */
public class TaskTimeoutCheckerJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        TimeoutCallbackProcessFactory.INSTANCE.getProcessor("xx","xx");
    }
}
