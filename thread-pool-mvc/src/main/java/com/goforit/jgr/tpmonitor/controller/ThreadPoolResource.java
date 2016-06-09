package com.goforit.jgr.tpmonitor.controller;

import com.goforit.jgr.tpmonitor.facade.model.ThreadPoolInformation;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by junqingfjq on 16/6/8.
 */

@Component
@Path("/threadpool")
public class ThreadPoolResource {

    @Path("/one")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ThreadPoolInformation getThreadPoolMonitor(){
        System.err.println("in ThreadPoolResource restful ");
        ThreadPoolInformation information=new ThreadPoolInformation();
        information.setCoreThreadNum(10);
        return information;
    }
}
