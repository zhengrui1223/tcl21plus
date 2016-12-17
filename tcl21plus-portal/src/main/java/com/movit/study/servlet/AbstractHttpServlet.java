package com.movit.study.servlet;

import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.http.HttpServlet;

/**
 * Created by admin on 2016/12/16.
 */
public abstract class AbstractHttpServlet extends HttpServlet{
    public ObjectMapper objectMapper;

    public AbstractHttpServlet(){
        this.objectMapper = new ObjectMapper();
    }
}
