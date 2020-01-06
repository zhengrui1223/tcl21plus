package com.movit.study.spring.ioc.annotation_bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicationContextTest {

    public static void main(String[] args) {
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.movit.study.spring.ioc.annotation_bean");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.start();
        AnnotationBeanUser annotationBeanUser = context.getBean(AnnotationBeanUser.class);
        System.out.println(annotationBeanUser);

    }
}
