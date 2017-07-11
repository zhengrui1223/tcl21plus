package com.movit.study.servlet.base;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServlet;

/**
 * Created by admin on 2016/12/16.
 */
public abstract class AbstractHttpServlet extends HttpServlet{
    @Autowired
    protected ObjectMapper objectMapper;

    public AbstractHttpServlet(){
    }
}
