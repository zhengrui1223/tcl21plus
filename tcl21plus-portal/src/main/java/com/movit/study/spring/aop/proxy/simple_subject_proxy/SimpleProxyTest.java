package com.movit.study.spring.aop.proxy.simple_subject_proxy;

/**
 *
 */
public class SimpleProxyTest {

    public static void main(String[] args) {

        SubjectServiceProxy proxy = new SubjectServiceProxy();
        proxy.setSubject(new SubjectService());
        proxy.request();

    }

}
