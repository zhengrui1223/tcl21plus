package com.movit.study.spring.proxy.simple_request_proxy;

public class ServiceRequestableProxy implements IRequestable {

    private IRequestable requestable;

    public ServiceRequestableProxy(IRequestable requestable) {
        this.requestable = requestable;
    }

    public void request() {
        //添加相应的业务逻辑
        System.out.println("代理类中添加相应的业务逻辑");
        requestable.request();
    }

}
