package com.movit.study.spring.aop.proxy.invocation_handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RequestCtrlInvocationHandler implements InvocationHandler {

    private Object target;

    public RequestCtrlInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if ("request".equals(method.getName())) {
            return method.invoke(target, args);
        }

        return null;
    }
}
