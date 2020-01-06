package com.movit.study.spring.componet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicationContextTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.movit.study.spring.componet");
        context.start();

        BeanConfig bean = context.getBean(BeanConfig.class);

    }
}
