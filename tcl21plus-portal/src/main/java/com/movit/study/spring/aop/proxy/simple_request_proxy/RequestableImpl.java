package com.movit.study.spring.aop.proxy.simple_request_proxy;

public class RequestableImpl implements IRequestable {
    public void request() {
        System.out.println("request processed in RequestableImpl");
    }
}
