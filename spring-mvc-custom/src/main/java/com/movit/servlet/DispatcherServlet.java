package com.movit.servlet;

import com.movit.util.FileUtil;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DispatcherServlet extends GenericServlet {
    private List<Class<?>> allClasses = new ArrayList<Class<?>>();

    @Override
    public void init() throws ServletException {

        //读取classpath路径下所有的类
        //List<File> files = FileUtil.readClassPathFile();


    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        PrintWriter writer = response.getWriter();
        writer.write("hello spring mvc custom");
    }
}
