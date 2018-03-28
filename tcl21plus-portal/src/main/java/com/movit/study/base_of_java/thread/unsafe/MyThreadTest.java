package com.movit.study.base_of_java.thread.unsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/************************************************************
 * @Description: TODO
 * @Author: jerry.zheng
 * @Date Created in 18:12 2018\3\28 0028        
 ************************************************************/

public class MyThreadTest{
    public static void main(String[] args) {

        MyAtomicInteger atomicInteger = new MyAtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0; i<10; i++) {
            executorService.execute(new MyThread(atomicInteger));
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.yield();
        }

        System.out.println(atomicInteger.get());

    }
}

class MyThread extends Thread{
    private MyAtomicInteger atomicInteger;

    public MyThread(MyAtomicInteger atomicInteger) {
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
        for (int i=0; i<1000; i++) {
            atomicInteger.getAndIncrement();
        }
    }
}