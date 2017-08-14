package com.movit.study.spring.autowire;

/**
 * Created by Administrator on 2017/4/13.
 */
public class Bean1 {
    private String message;

    public Bean1(){
        this.message = "hello";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
