package com.movit.study.servlet.base;


import com.fasterxml.jackson.databind.ObjectMapper;
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
