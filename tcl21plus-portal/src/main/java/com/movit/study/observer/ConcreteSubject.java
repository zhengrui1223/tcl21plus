package com.movit.study.observer;

/**
 * Created by Administrator on 2017/4/7.
 */
public class ConcreteSubject extends Subject {
    private String stage;

    public String getStage(){
        return stage;
    }

    public void change(String changeStage){
        stage = changeStage;
        System.out.println("主题状态更新为" + changeStage);
        this.nodifyObservers();
    }
}
