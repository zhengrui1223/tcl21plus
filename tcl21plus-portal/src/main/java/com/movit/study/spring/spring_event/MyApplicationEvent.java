package com.movit.study.spring.spring_event;

import org.springframework.context.ApplicationEvent;

public class MyApplicationEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MyApplicationEvent(Object source) {
        super(source);
        System.out.println("my event start");
    }
}
