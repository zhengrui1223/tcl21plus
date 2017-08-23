package com.movit.study.base_of_java.observer;

/**
 * Created by Administrator on 2017/4/7.
 */
public class ObserverTest {
    public static void main(String []args){
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();

        subject.attach(observer);
        subject.change("11111111111");
    }
}
