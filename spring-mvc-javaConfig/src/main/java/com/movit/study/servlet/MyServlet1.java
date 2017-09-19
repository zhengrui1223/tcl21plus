package com.movit.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-19 14:04
 ************************************************************/

@WebServlet(asyncSupported = false, name = "myServlet1", urlPatterns = "/my1")
public class MyServlet1 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("<h1>hello servlet 3.0 myServlet1<h1/>");
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
