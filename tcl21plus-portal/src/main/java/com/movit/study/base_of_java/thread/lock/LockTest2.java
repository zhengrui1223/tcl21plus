package com.movit.study.base_of_java.thread.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-12-08 19:20
 ************************************************************/

public class LockTest2 {

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();
        List<Thread> threadList = new ArrayList<>();
        for (int i=0; i<5; i++) {
            Thread thread = new TestThread2(lock);
            thread.start();
            threadList.add(thread);
        }

        threadList.forEach(Thread::interrupt);
    }

}

class TestThread2 extends Thread {
    private Lock lock;

    public TestThread2(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " start--------");
            long start = System.currentTimeMillis();
            long end = 0;

            while ((end - start) <= 30000) {
                end = System.currentTimeMillis();
            }
            System.out.println(Thread.currentThread().getName() + " end--------");
        }finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "---------" + Thread.currentThread().isInterrupted());
        }
    }
}