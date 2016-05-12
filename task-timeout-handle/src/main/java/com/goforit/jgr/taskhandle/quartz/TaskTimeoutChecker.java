package com.goforit.jgr.taskhandle.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * Created by junqingfjq on 16/5/12.
 */

@Service
public class TaskTimeoutChecker implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        try{
            SchedulerFactory schedulerFactory=new StdSchedulerFactory();

            Scheduler scheduler=schedulerFactory.getScheduler();

            JobDetail jobDetail= JobBuilder.newJob(TaskTimeoutCheckerJob.class).withIdentity("JobName","JobGroupName").build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("CronTrigger1", "CronTriggerGroup")
                    .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?")).startNow().build();

            scheduler.scheduleJob(jobDetail,trigger);

            scheduler.start();

        }catch (Exception e){
            //TODO
            e.printStackTrace();
        }
    }
}
