package com.movit.study.exception;

/**
 * Created by admin on 2017/2/7.
 */
public class ExceptionDemo {
    public static void main(String [] args){
        try {
            throw new MyDemoException("############");
        } catch (MyDemoException e1) {
            e1.printStackTrace();
        }
    }
}

