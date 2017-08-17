package com.movit.study.spring.ioc.annotation_bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassPathXmlApplicationContextTest {

    public static void main(String []args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/study/spring/annotation_bean.xml");

        AnnotationBeanUser annotationBeanUser = (AnnotationBeanUser) context.getBean("annotationBeanUser");
        System.out.println(annotationBeanUser);

    }
}
