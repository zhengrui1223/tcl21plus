package com.movit.study.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-19 14:04
 ************************************************************/

@WebServlet(asyncSupported = true, name = "myServlet1", urlPatterns = "/my1")
public class MyServlet1 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("<h1>hello servlet 3.0 myServlet1<h1/>");

        // 创建 AsyncContext，开始异步调用
        AsyncContext actx = req.startAsync();
        // 设置异步调用的超时时长
        actx.setTimeout(60 * 1000);
        // 启动异步调用的线程
        actx.start(new Task(actx));

        System.out.println("end----------");
        writer.flush();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

class Task extends Thread{
    private AsyncContext actx;

    public Task(AsyncContext actx) {
        this.actx = actx;
    }

    @Override
    public void run() {
        try {
            // 等待 5 秒，以模拟业务的方法执行
            Thread.sleep(5 * 1000);
            ServletRequest request = actx.getRequest();
            List<String> books = new ArrayList<String>();
            books.add("book 1");
            books.add("book 2");
            books.add("book 3");
            request.setAttribute("books", books);
            actx.dispatch("/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
