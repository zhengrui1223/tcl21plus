package com.movit.study.spring.ioc.autowire;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/4/13.
 */
public class Bean2 {
    @Autowired
    private Bean1 bean;

    /*@Autowired
    public Bean2(Bean1 bean){
        this.bean = bean;
    }*/

    public Bean1 getBean() {
        return bean;
    }

    public void setBean(Bean1 bean) {
        this.bean = bean;
    }
}
