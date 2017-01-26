package com.movit.study.servlet.base;

import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

/**
 * Created by admin on 2016/12/16.
 */
public abstract class AbstractHttpServlet extends HttpServlet{
    protected ObjectMapper objectMapper;

    public AbstractHttpServlet(){
        this.objectMapper = new ObjectMapper();
    }
}
