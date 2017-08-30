package com.movit.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class GenericCRUDMultiActionController extends MultiActionController{

    /**
     * MultiActionController中, 会对list方法的参数做校验, 必须存在request, response参数
     * session参数可选, 但是一旦选择传入session参数, 则服务器之前必须已经为此请求分配了session,否则会报错
     * 看源码
       HttpSession session = request.getSession(false);
       if (session == null) {
        throw new HttpSessionRequiredException(
            "Pre-existing session required for handler method '" + methodName + "'");
       }
     * @param request
     * @param response
     * @throws IOException
     */
    public void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("-----------------list");
        Map map = new HashMap();
        map.put("key", "value");
        request.getSession().setAttribute("name", "jerry");

        PrintWriter writer = response.getWriter();
        writer.write(String.valueOf(map));
    }

    /**
     * 必须先执行list方法创建session后, insert方法才能成功执行.
     * @param request
     * @param response
     * @param session
     * @return
     */
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println("-----------------insert");
        System.out.println("-----------------" + session.getAttribute("name"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        return modelAndView;
    }

}
