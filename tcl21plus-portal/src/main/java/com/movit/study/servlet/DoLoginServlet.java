package com.movit.study.servlet;

import com.movit.study.servlet.base.AbstractHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by admin on 2016/12/21.
 */
public class DoLoginServlet extends AbstractHttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain");
        PrintWriter writer = resp.getWriter();

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        writer.write("name=" + name + "\r\n");
        writer.write("password=" + password + "\r\n");

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            saveCookie(name, "name", cookie, resp);
            saveCookie(password, "password", cookie, resp);
        }

        writer.write("cookie数目=" + cookies.length + "\r\n");
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                writer.write("\r\n name=" + cookie.getName() + "######value=" + cookie.getValue());
            }
        }

        File file = new File("");
    }

    private void saveCookie(String value, String nameInCookie, Cookie cookie, HttpServletResponse resp) {
        String cookieName = cookie.getName();
        if (nameInCookie.equals(cookieName)) {
            cookie.setValue(value);
            resp.addCookie(cookie);
        } else {
            Cookie newCookie = new Cookie(nameInCookie, value);
            resp.addCookie(newCookie);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
