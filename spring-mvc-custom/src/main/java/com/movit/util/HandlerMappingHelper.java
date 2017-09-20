package com.movit.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movit.annotation.Controller;
import com.movit.annotation.RequestMapping;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-20 9:04
 ************************************************************/
public class HandlerMappingHelper {
    private static final Logger logger = LoggerFactory.getLogger(HandlerMappingHelper.class);
    private static final Map<Request, Handler> handlerMappings = new HashMap<Request, Handler>();

    static {
        Map<Class<?>, Object> beanMap = BeanIocHelper.getBeanMap();
        if (beanMap != null && !beanMap.isEmpty()) {
            for (Map.Entry<Class<?>, Object> entry : beanMap.entrySet()) {
                Class<?> beanClass = entry.getKey();
                Object beanInstance = entry.getValue();
                if (beanClass.isAnnotationPresent(Controller.class)) {
                    Method[] methods = beanClass.getDeclaredMethods();
                    if (ArrayUtils.isNotEmpty(methods)) {
                        for (Method method : methods) {
                            if (method.isAnnotationPresent(RequestMapping.class)) {
                                RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                                String requestPath = requestMapping.path().toUpperCase();
                                String requestMethod = requestMapping.method().toUpperCase();
                                Request request = new Request(requestMethod, requestPath);
                                Handler handler = new Handler(beanInstance, method);
                                handlerMappings.put(request, handler);
                                logger.info("[ requestPath= " + requestPath + " requestMethod= " + requestMethod + " ]");
                            }
                        }
                    }
                }
            }
        }
    }

    public static Handler getHandler(String requestMethod, String requestPath) {
        return handlerMappings.get(new Request(requestMethod, requestPath));
    }

    public static void main(String[] args) throws JsonProcessingException {
        Handler handler = getHandler("GET", "/user/getAll");
        System.out.println(new ObjectMapper().writeValueAsString(handler));
    }

}
