package com.movit.study.spring.ioc.spring_event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class MyApplicationEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher eventPublisher;

    public void methodToMonitor() {
        MyApplicationEvent event = new MyApplicationEvent(this);

        this.eventPublisher.publishEvent(event);
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.eventPublisher = publisher;
    }

}
