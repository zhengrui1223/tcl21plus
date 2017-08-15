package com.movit.study.spring.proxy.CGLIB;

/**
 * 不实现任何接口的业务类
 */
public class Requestable {

    public void request() {
        System.out.println("request in requestable without implement any interface");
    }

}
