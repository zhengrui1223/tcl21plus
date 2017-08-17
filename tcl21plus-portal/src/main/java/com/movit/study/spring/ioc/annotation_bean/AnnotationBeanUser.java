package com.movit.study.spring.ioc.annotation_bean;

import org.springframework.stereotype.Component;

@Component
public class AnnotationBeanUser {
    private Integer id;
    private String name;
    private String passWord;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
