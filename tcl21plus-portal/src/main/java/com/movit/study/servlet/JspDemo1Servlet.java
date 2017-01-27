package com.movit.study.servlet;

import com.movit.study.servlet.base.AbstractHttpServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by admin on 2016/12/23.
 */
public class JspDemo1Servlet extends AbstractHttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");

        //request作用域
        req.setAttribute("nameRequest", "test_request");

        //session作用域
        HttpSession session = req.getSession();
        session.setAttribute("nameSession", "test_session");

        //servletContext作用域
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("nameServletContext", "test_servletContext");

        req.getRequestDispatcher("/WEB-INF/page/jsp/EL_page.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
