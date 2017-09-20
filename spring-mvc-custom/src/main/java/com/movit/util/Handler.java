package com.movit.util;

import java.lang.reflect.Method;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-20 9:02
 ************************************************************/
public class Handler {
    private Object handler;

    private Method handlerMethod;

    public Handler(Object handler, Method handlerMethod) {
        this.handler = handler;
        this.handlerMethod = handlerMethod;
    }

    public Object getHandler() {
        return handler;
    }

    public Method getHandlerMethod() {
        return handlerMethod;
    }
}
