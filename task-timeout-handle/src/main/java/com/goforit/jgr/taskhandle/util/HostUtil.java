package com.goforit.jgr.taskhandle.util;

import java.net.InetAddress;

/**
 * Created by junqingfjq on 16/5/20.
 */
public class HostUtil {

    public static String getIp() {
        try{
            InetAddress inet = InetAddress.getLocalHost();
            return inet.getHostAddress();
        }catch (Exception e){
            return null;
        }
    }
}
