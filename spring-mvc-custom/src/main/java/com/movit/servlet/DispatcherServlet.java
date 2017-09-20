package com.movit.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movit.annotation.ResponseBody;
import com.movit.util.*;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {
    private static final String JSP_PAGES_DIR = "/WEB-INF/pages/";
    private static final String RESOURCES_DIR = "/resources/";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(ServletConfig config) throws ServletException {

        Class<?>[] classes = new Class<?>[]{ClassHelper.class, BeanIocHelper.class, BeanDIHelper.class, HandlerMappingHelper.class};
        for (Class<?> clazz : classes) {
            ClassUtil.loadClass(clazz.getName(), true);
        }

        ServletContext servletContext = config.getServletContext();
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(JSP_PAGES_DIR + "*");

        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(RESOURCES_DIR + "*");

    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestMethod = request.getMethod().toUpperCase();
        String requestPath = request.getRequestURI().toUpperCase();

        Handler handler = HandlerMappingHelper.getHandler(requestMethod, requestPath);

        if (handler != null) {
            Object handlerInstance = handler.getHandler();
            Method handlerMethod = handler.getHandlerMethod();

            Map<String, Object> paramMap = new HashMap<String, Object>();
            Enumeration<String> parameterNames = request.getParameterNames();

            while (parameterNames.hasMoreElements()) {
                String parameterName = parameterNames.nextElement();
                String parameterValue = request.getParameter(parameterName);
                paramMap.put(parameterName, parameterValue);
            }

            Param param = new Param(paramMap);
            Class<?>[] parameterTypes = handlerMethod.getParameterTypes();
            Object[] args = null;
            if (ArrayUtils.isNotEmpty(parameterTypes)) {
                args = new Object[parameterTypes.length];
                int index = 0;
                for (Class<?> clazz : parameterTypes) {
                    if (clazz.isAssignableFrom(HttpServletRequest.class)) {
                        args[index] = request;
                    }
                    if (clazz.isAssignableFrom(HttpServletResponse.class)) {
                        args[index] = response;
                    }
                    if (clazz.isAssignableFrom(Param.class)) {
                        args[index] = param;
                    }
                    index++;
                }
            }

            Object result = ReflectionUtil.invokeMethod(handlerInstance, handlerMethod, args);
            if (handlerMethod.isAnnotationPresent(ResponseBody.class)) {
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                writer.write(objectMapper.writeValueAsString(result));
                writer.close();
            } else {
                View view = (View) result;
                String path = view.getPath();
                if (StringUtils.isNotEmpty(path)) {
                    if (path.startsWith("redirect:/")) {
                        response.sendRedirect(request.getContextPath() + "/" + path.replace("redirect:/", ""));
                    } else {
                        Map<String, Object> model = view.getModel();
                        for (Map.Entry<String, Object> entry : model.entrySet()) {
                            request.setAttribute(entry.getKey(), entry.getValue());
                        }
                        request.getRequestDispatcher(JSP_PAGES_DIR + view.getPath() + ".jsp").forward(request, response);
                    }
                }else {
                    response.sendError(404);
                }
            }
        }else {
            response.sendError(404);
        }
    }
}
