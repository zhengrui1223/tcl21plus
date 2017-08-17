package com.movit.study.spring.aop.proxy.simple_request_proxy;

/**
 * 通过代理类来达到横切业务类的目的
 */
public class RequestableTest {

    public static void main(String[] args) {
        IRequestable requestable = new ServiceRequestableProxy(new RequestableImpl());
        requestable.request();
    }
}
