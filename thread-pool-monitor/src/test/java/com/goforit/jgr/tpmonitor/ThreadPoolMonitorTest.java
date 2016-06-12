package com.goforit.jgr.tpmonitor;

import com.goforit.jgr.tpmonitor.annotation.ThreadPoolMonitorAnnotation;
import com.goforit.jgr.tpmonitor.facade.ThreadPoolMonitorFacade;
import com.goforit.jgr.tpmonitor.facade.model.ThreadPoolInformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by junqingfjq on 16/6/7.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:core-service.xml" })
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ThreadPoolMonitorTest {

    private static final Logger LOGGER= LoggerFactory.getLogger(ThreadPoolMonitorTest.class);

//    private static final Logger LOGGER= Logger.getLogger(ThreadPoolMonitorTest.class);
    @Autowired
    private ThreadPoolMonitorFacade threadPoolMonitorFacade;

    @ThreadPoolMonitorAnnotation(threadPoolName = "normal")
    private ThreadPoolExecutor      normalThreadPool = new ThreadPoolExecutor(15, 25, 1000,
                                                         TimeUnit.SECONDS,
                                                         new LinkedBlockingQueue<Runnable>(100));

//    @DirtiesContext
//    @Transactional
    @Test
    public void testMonitor(){


        ThreadPoolInformation information=threadPoolMonitorFacade.getThreadPoolRunTimeInformation("normal");

        System.err.println(information);

        try{
            for(int i=0;i<120;i++){

                normalThreadPool.execute(new MyThread());
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        while(true){
            try{
                Thread.sleep(50);
                information=threadPoolMonitorFacade.getThreadPoolRunTimeInformation("normal");

                System.err.println(information);

                Thread.sleep(100);
            }catch (Exception e){

            }
        }

//        System.err.println("end");


    }

}
