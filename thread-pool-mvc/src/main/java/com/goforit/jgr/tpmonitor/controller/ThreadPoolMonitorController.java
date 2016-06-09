package com.goforit.jgr.tpmonitor.controller;

import com.goforit.jgr.tpmonitor.facade.ThreadPoolMonitorFacade;
import com.goforit.jgr.tpmonitor.facade.model.ThreadPoolInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by junqingfjq on 16/6/7.
 */

@Component
@Path("/tpmonitor")
public class ThreadPoolMonitorController {

    @Autowired
    private ThreadPoolMonitorFacade threadPoolMonitorFacade;

    @Path("/{threadPoolName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ThreadPoolInformation getThreadPoolInformation(@PathParam("threadPoolName") String threadPoolName){
        System.err.println("in getThreadPoolInformation. threadPoolName= "+threadPoolName);

//        ThreadPoolInformation information=new ThreadPoolInformation();
//        information.setCoreThreadNum(10);
//        return information;
        ThreadPoolInformation information= threadPoolMonitorFacade.getThreadPoolRunTimeInformation(threadPoolName);
        return information;
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ThreadPoolInformation> getAllThreadPoolInformation(){
        System.err.println("in getAllThreadPoolInformation.");

        return threadPoolMonitorFacade.getAllThreadPoolRunTimeInformation();
    }
}
