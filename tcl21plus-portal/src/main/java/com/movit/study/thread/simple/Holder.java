package com.movit.study.thread.simple;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by admin on 2017/4/4.
 */
public class Holder extends Thread {

    static AtomicInteger n = new AtomicInteger(30);

    //################################################
    static int nn = 30;

    @Override
    public void run() {
        /*for (int i=0; i<10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + n);
            //n.decrementAndGet();
            n.getAndDecrement();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        for (int i=0; i<10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + nn);
            nn--;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TestDemo {
    public static void main(String[] args) {
        /*Holder holder = new Holder();

        Thread thread1 = new Thread(holder);
        Thread thread2 = new Thread(holder);
        Thread thread3 = new Thread(holder);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(holder.n);*/

        //################################################
        Holder holder = new Holder();

        Thread thread1 = new Thread(holder);
        Thread thread2 = new Thread(holder);
        Thread thread3 = new Thread(holder);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(holder.nn);

    }
}

class MyThread implements Runnable {
    //    static  int i = 0;如下面的列子
    static AtomicInteger ai = new AtomicInteger(0);


    public void run() {
        for (int m = 0; m < 1000000; m++) {
            ai.getAndIncrement();
        }
    }
}

class TestAtomicInteger {
    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();

        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        //Thread.sleep(500);
        System.out.println(MyThread.ai.get());
    }
}

class MyThread1 implements Runnable {
    static int i = 0;

    public void run() {
        for (int m = 0; m < 1000000; m++) {
            i++;
        }
    }
}

class TestAtomicInteger1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread1 mt = new MyThread1();

        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        t1.start();
        t2.start();
        Thread.sleep(500);
        System.out.println(MyThread1.i);
    }
}
