package com.movit.study.spring.proxy.CGLIB;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class RequestCtrlCallback implements MethodInterceptor {
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        if ("request".equals(method.getName())) {
            //此时可以进行log日志的记录, 或者对事物及权限的控制等操作
            System.out.println("requestable run before");
            Object invokeSuper = methodProxy.invokeSuper(object, args);
            System.out.println("requestable run after");
            return invokeSuper;
        }

        return null;
    }
}
