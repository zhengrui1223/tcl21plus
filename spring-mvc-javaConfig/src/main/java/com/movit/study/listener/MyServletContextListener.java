package com.movit.study.listener;

import com.movit.study.servlet.MyServlet3;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-19 14:35
 ************************************************************/

@WebListener(value = "myServletContextListener")
public class MyServletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        ServletRegistration.Dynamic my3 = context.addServlet("my3", new MyServlet3());
        my3.addMapping("/my3");

        System.out.println("################### " + context.getServerInfo() + " running...");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        System.out.println("################### " + context.getServerInfo() + " stopping...");
    }
}
