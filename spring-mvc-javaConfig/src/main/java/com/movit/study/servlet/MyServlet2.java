package com.movit.study.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-19 14:04
 ************************************************************/

//@WebServlet(asyncSupported = true, name = "myServlet2", urlPatterns = "/my2")
public class MyServlet2 extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 3903580630389463919L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().write("hello, async test");
        resp.getWriter().println("start：" + new Date() + ".<br/>");
        resp.getWriter().flush();
        final AsyncContext async = req.startAsync(req, resp);
        async.setTimeout(3000);
        async.start(new Runnable() {
            public void run() {
                ServletRequest request = async.getRequest();
                try {
                    Thread.sleep(2000);
                    async.getResponse().getWriter().write("aync thread processing");
                    async.getResponse().getWriter().flush();
                    async.getResponse().getWriter().println("async end：" + new Date() + ".<br/>");
                    async.getResponse().getWriter().flush();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        async.addListener(new AsyncListener() {

            public void onTimeout(AsyncEvent arg0) throws IOException {
                // TODO Auto-generated method stub

            }

            public void onStartAsync(AsyncEvent arg0) throws IOException {
                // TODO Auto-generated method stub

            }

            public void onError(AsyncEvent arg0) throws IOException {
                // TODO Auto-generated method stub

            }

            public void onComplete(AsyncEvent arg0) throws IOException {
                // TODO Auto-generated method stub

            }
        });
        resp.getWriter().println("end：" + new Date() + ".<br/>");
        resp.getWriter().flush();
    }
}