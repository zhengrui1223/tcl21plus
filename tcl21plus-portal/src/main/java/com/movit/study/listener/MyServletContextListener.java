package com.movit.study.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by admin on 2016/12/16.
 */
public class MyServletContextListener implements ServletContextListener {
    private static Logger log = LoggerFactory.getLogger(MyServletContextListener.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info("#######################################项目启动了");
        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@项目启动了");
        log.info("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&项目启动了");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("#######################################项目关闭了");
        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@项目关闭了");
        log.info("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&项目关闭了");
    }

}
