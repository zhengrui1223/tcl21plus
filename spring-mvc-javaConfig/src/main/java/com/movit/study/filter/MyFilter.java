package com.movit.study.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-19 14:19
 ************************************************************/

@WebFilter(asyncSupported = false, filterName = "/myFilter", urlPatterns = {"/*"})
public class MyFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("myFilter init........");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("myFilter start........");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if (req.getRequestURI().contains("my")) {
            System.out.println("###################");
        }

        System.out.println("myFilter end........");
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
