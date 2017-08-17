package com.movit.study.spring.aop.proxy.invocation_handler;

import com.movit.study.spring.aop.proxy.simple_request_proxy.IRequestable;
import com.movit.study.spring.aop.proxy.simple_request_proxy.RequestableImpl;
import com.movit.study.spring.aop.proxy.simple_subject_proxy.ISubject;
import com.movit.study.spring.aop.proxy.simple_subject_proxy.SubjectService;

import java.lang.reflect.Proxy;

/**
 * 我们通过InvocationHandler来拦截所有的request方法
 *  JDK动态代理方式.基于接口
 */
public class InvocationHandlerTest {

    public static void main(String[] args) {
        ISubject subject = (ISubject) Proxy.newProxyInstance(InvocationHandlerTest.class.getClassLoader(),
                new Class[]{ISubject.class}, new RequestCtrlInvocationHandler(new SubjectService()));
        String response = subject.request();
        System.out.println("subject " + response);

        IRequestable request = (IRequestable) Proxy.newProxyInstance(InvocationHandlerTest.class.getClassLoader(),
                new Class[]{IRequestable.class}, new RequestCtrlInvocationHandler(new RequestableImpl()));
        request.request();
    }

}
