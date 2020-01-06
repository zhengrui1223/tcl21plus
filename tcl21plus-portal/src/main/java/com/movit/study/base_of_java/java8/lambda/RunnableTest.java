package com.movit.study.base_of_java.java8.lambda;

/************************************************************
 * @Description: TODO
 * @Author: jerry.zheng
 * @Date 2018-04-15 16:14
 ************************************************************/

public class RunnableTest {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                System.out.println("before java8 create a new thread.");
            }
        });

        new Thread(() -> System.out.println("1111111")).start();

    }
}
