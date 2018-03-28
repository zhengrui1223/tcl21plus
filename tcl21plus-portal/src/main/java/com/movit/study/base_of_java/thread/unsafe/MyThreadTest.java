package com.movit.study.base_of_java.thread.unsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/************************************************************
 * @Description: TODO
 * @Author: jerry.zheng
 * @Date Created in 18:12 2018\3\28 0028        
 ************************************************************/

public class MyThreadTest{
    public static void main(String[] args) throws InterruptedException {

        MyAtomicInteger atomicInteger = new MyAtomicInteger(0);

//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        for (int i=0; i<10; i++) {
//            executorService.execute(new MyThread(atomicInteger));
//        }

        MyThread myThread1 = new MyThread(atomicInteger);
        MyThread myThread2 = new MyThread(atomicInteger);

        myThread1.start();
        myThread2.start();

        myThread1.join();
        myThread2.join();

        //executorService.shutdown();
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
