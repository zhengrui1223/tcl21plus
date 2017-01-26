package com.movit.study.servlet;

import com.movit.study.servlet.base.AbstractHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by admin on 2016/12/21.
 * 线程安全问题
 */
public class AdderServlet extends AbstractHttpServlet {

    private int sum = 100;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        int increase = Integer.parseInt(req.getParameter("a"));
        PrintWriter writer = resp.getWriter();

        //未使用线程同步处理
        /*writer.write("<h1>" + sum + "+" + increase + "=");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sum += increase;
        writer.write(sum + "</h1>");*/

        //使用线程同步处理
        synchronized (this) {
            writer.write("<h1>" + sum + "+" + increase + "=");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum += increase;
            writer.write(sum + "</h1>");
        }
        writer.flush();
        writer.close();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
