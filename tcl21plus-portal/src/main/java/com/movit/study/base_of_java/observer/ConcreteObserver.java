package com.movit.study.base_of_java.observer;

/**
 * Created by Administrator on 2017/4/7.
 */
public class ConcreteObserver extends Observer {

    private String observerState;

    public void update(Subject subject) {
        ConcreteSubject concreteSubject = (ConcreteSubject) subject;
        observerState = concreteSubject.getStage();
        System.out.println("观察者状态为:" + observerState);
    }
}
