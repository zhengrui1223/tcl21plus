package com.movit.study.spring.proxy.simple_subject_proxy;

public class SubjectService implements ISubject{
    public String request() {
        System.out.println("request processed in SubjectService");
        return "OK";
    }
}
