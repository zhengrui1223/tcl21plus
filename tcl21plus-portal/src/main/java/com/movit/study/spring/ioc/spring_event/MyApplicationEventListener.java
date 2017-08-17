package com.movit.study.spring.ioc.spring_event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyApplicationEventListener implements ApplicationListener {
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof MyApplicationEvent) {
            System.out.println("执行 MyApplicationEvent");
        }
    }
}
