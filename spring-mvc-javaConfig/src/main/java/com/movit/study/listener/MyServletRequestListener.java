package com.movit.study.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-19 14:30
 ************************************************************/

@WebListener(value = "myListener")
public class MyServletRequestListener implements ServletRequestListener {
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest servletRequest = (HttpServletRequest)sre.getServletRequest();
        System.out.println("requestDestroyed #################" + servletRequest.getRequestURI());
    }

    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest servletRequest = (HttpServletRequest)sre.getServletRequest();
        System.out.println("requestInitialized #################" + servletRequest.getRequestURI());
    }
}
