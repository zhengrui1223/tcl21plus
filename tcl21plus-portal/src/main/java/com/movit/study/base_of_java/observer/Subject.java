package com.movit.study.base_of_java.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void nodifyObservers(){
        for(Observer observer : observers){
            observer.update(this);
        }
    }
}
