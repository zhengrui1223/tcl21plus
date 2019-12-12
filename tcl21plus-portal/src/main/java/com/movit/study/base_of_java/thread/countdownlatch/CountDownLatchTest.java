package com.movit.study.base_of_java.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-11-25 22:40
 ************************************************************/

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch downLatch = new CountDownLatch(2);

        new Thread(() -> {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1111");
            downLatch.countDown();
        }).start();

        new Thread(() -> {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2222");
            downLatch.countDown();
        }).start();

        downLatch.await();

        System.out.println("333333333");
    }

}
