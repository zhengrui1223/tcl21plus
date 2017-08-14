package com.movit.study.spring.proxy.simple_proxy;

public class SubjectServiceProxy implements ISubject{
    private ISubject subject;

    public String request() {

        System.out.println("do something before request");
        String originalResult = subject.request();
        System.out.println("do something after request");

        return "Proxy" + originalResult;
    }

    public void setSubject(ISubject subject) {
        this.subject = subject;
    }
}
