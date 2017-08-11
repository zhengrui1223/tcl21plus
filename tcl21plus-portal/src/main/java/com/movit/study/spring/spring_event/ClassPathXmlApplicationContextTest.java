package com.movit.study.spring.spring_event;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassPathXmlApplicationContextTest {

    public static void main(String []args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/study/spring/spring_event.xml");

        MyApplicationEventPublisher eventPublisher = (MyApplicationEventPublisher) context.getBean("myApplicationEventPublisher");
        eventPublisher.methodToMonitor();
    }
}
