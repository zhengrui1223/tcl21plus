package com.movit.study.servlet;

import com.movit.study.servlet.base.AbstractHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 2016/12/21.
 */
public class ToLoginServlet extends AbstractHttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if(cookies != null && cookies.length >0){
            for (Cookie cookie: cookies){
                String cookieName = cookie.getName();
                String cookieValue = cookie.getValue();
                if("name".equals(cookieName)){
                    req.setAttribute("name", cookieValue);
                }
                if("password".equals(cookieName)){
                    req.setAttribute("password", cookieValue);
                }
            }
            if(cookies !=null && cookies.length>0){
                for (Cookie cookie: cookies){
                    System.out.println(cookie.getName() + "\r\n");
                    System.out.println(cookie.getValue() + "\r\n");
                }
            }
        }

        req.getRequestDispatcher("/WEB-INF/page/login.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
