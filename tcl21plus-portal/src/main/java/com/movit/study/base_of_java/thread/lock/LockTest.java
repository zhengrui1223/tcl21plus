package com.movit.study.base_of_java.thread.lock;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-12-08 19:20
 ************************************************************/

public class LockTest {

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();
        CyclicBarrier barrier = new CyclicBarrier(2);

        List<Thread> threadList = new ArrayList<>();
        for (int i=0; i<2; i++) {
            Thread thread = new TestThread(lock, barrier);
            thread.start();
            threadList.add(thread);
        }

        Thread.sleep(100);
        threadList.forEach(Thread::interrupt);

        //threadList.forEach(thread -> System.out.println(thread.getName() + ": " + thread.isInterrupted()));
    }

}
class TestThread extends Thread {
    private Lock lock;
    private CyclicBarrier barrier;

    public TestThread(Lock lock, CyclicBarrier barrier) {
        this.lock = lock;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            this.barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        lock.lock();
        try {

            long start = System.currentTimeMillis();
            long end = 0;

            while ((end - start) <= 1000) {
                end = System.currentTimeMillis();
            }

        }finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "---------" + Thread.currentThread().isInterrupted());
        }
    }
}