package com.movit.study.spi.jdk;

/************************************************************
 * @Description: TODO
 * @Author: zhengrui
 * @Date 2019-12-12 21:09
 ************************************************************/

public class Bumblebee implements Robot {
    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}
