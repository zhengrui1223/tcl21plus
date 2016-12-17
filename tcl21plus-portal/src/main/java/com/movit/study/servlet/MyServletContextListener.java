package com.movit.study.servlet;

import org.springframework.util.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by admin on 2016/12/16.
 */
public class MyServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ServletContext servletContext = servletContextEvent.getServletContext();
            InputStream inputStream = this.getClass().getResourceAsStream("count.txt");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String countStr = bufferedReader.readLine();
            if(!StringUtils.isEmpty(countStr)){
                int count = Integer.parseInt(countStr);
                servletContext.setAttribute("count", count);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("###########################项目启动了");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        Integer count = (Integer) servletContext.getAttribute("count");
        System.out.println("###########################count=" + count);

        if(count != null){
            String realPath = servletContext.getRealPath("count.txt");
            System.out.println("###################realPath=" + realPath);
            File file  = new File(realPath);
            System.out.println("###################file=" + file.getAbsolutePath());

            try {
//                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
//                outputStream.write(new Integer(5).toString().getBytes());
//                outputStream.write("hello".getBytes());

                PrintWriter printWriter = new PrintWriter(realPath);
                printWriter.write(3);
                printWriter.flush();
                printWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("########################### fds项目关闭了");
    }

}
