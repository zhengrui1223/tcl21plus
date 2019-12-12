package com.movit.study.base_of_java.thread.lock;

import java.util.concurrent.locks.LockSupport;

/************************************************************
 * @Description: LockSupport相应中断, 但是不会抛出InterruptedException异常
 * @Author: zhengrui
 * @Date 2019-11-23 13:36
 ************************************************************/

public class LockSupportTest2 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = Thread.currentThread();
        thread.interrupt();
        LockSupport.park();

        System.out.println("thread over1: " + Thread.currentThread().isInterrupted());

        long start = System.currentTimeMillis();
        long end = 0;

        while ((end - start) <= 1000) {
            end = System.currentTimeMillis();
        }

        System.out.println("thread over2: " + Thread.currentThread().isInterrupted());

        Thread.sleep(1000);
    }

}
