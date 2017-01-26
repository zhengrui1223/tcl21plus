package com.movit.study.servlet;

import com.movit.study.model.User;
import com.movit.study.servlet.base.AbstractHttpServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by admin on 2016/12/16.
 */
public class Hello1Servlet extends AbstractHttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("gbk");

        ServletContext servletContext = getServletConfig().getServletContext();
        User user = (User) servletContext.getAttribute("user");

        PrintWriter writer = resp.getWriter();

        /*Enumeration<String> names = servletContext.getInitParameterNames();
        writer.write("ServletContext Init Parameter Names and Values:");
        while (names.hasMoreElements()){
            String name = names.nextElement();
            String value = servletContext.getInitParameter(name);
            writer.write("<br/> name:" + name + " value:" + value);
        }

        Enumeration<String> names1 = req.getServletContext().getInitParameterNames();
        writer.write("<br/> Servlet Init Parameter Names and Values:");
        while (names1.hasMoreElements()){
            String name = names1.nextElement();
            String value = servletContext.getInitParameter(name);
            writer.write("<br/> name:" + name + " value:" + value);
        }*/

        String test = getInitParameter("testParam");
        String test1 = getInitParameter("testParam1");
        writer.write("<br/> name:test " + " value:" + test);
        writer.write("<br/> name:test1 " + " value:" + test1);

        String asString = objectMapper.writeValueAsString(user);
        String contextPath = servletContext.getContextPath();
        writer.write("<br/>" + asString);
        writer.write("<br/> " + contextPath);

        log("###############################");

        int count;
        Object countObj = servletContext.getAttribute("count");
        if (countObj == null) {
            count = 1;
            servletContext.setAttribute("count", new Integer(count));
        } else {
            count = (Integer) countObj;
            count++;
            servletContext.setAttribute("count", new Integer(count));
        }

        writer.write("<br/> 网站被访问了第 " + count + "次");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
