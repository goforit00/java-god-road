package com.goforit.jgr.tpmonitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by junqingfjq on 16/6/7.
 */

@Controller
@RequestMapping("/")
public class ThreadPoolMonitorController {

    @RequestMapping(value = "threadpoolmonitor",method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "thread pool monitor!");
        return "hello";
    }
}
