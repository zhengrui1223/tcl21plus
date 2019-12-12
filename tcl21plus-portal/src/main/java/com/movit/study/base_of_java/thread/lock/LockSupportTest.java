package com.movit.study.base_of_java.thread.lock;

import java.util.concurrent.locks.LockSupport;

/************************************************************
 * @Description: LockSupport相应中断, 但是不会抛出InterruptedException异常
 * @Author: zhengrui
 * @Date 2019-11-23 13:36
 ************************************************************/

public class LockSupportTest {

    public static void main(String[] args) throws InterruptedException {
        /*Thread thread = Thread.currentThread();
        LockSupport.park();

        LockSupport.unpark(thread);
        System.out.println("--");*/

        Thread t = new Thread(new Runnable() {
            private int count = 0;

            @Override
            public void run() {
                long start = System.currentTimeMillis();
                long end = 0;

                while ((end - start) <= 1000) {
                    count++;
                    end = System.currentTimeMillis();
                }
                System.out.println("after 1 second, count=" + count);
                //等待或许许可
                LockSupport.park();

                System.out.println("thread t over: " + Thread.currentThread().isInterrupted());

            }
        });
        t.start();
        Thread.sleep(2000);

        // 中断线程
        t.interrupt();

        //Thread.sleep(1000);
        //System.out.println("thread t over2: " + Thread.currentThread().isInterrupted());

        System.out.println("main over");
    }

}
