package com.movit.study.base_of_java.thread.deadlock;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-11-01 8:44
 ************************************************************/

/**
 * 死锁产生的条件：
 *      1 要有两个或两个以上的线程
 *      2 至少有两个共享资源的锁
 *      3 至少存在两个线程各自拥有一个锁
 *      4 现在这两个线程在等待获取彼此的锁,这就出现死锁了
 * 无有效解决死锁的方案，编程时注意不要满足第四点即不会产生死锁
 */
public class DeadLockDemo {
    private static Object lockA = new Object();
    private static Object lockB = new Object();

    public static void main(String[] args) {
        System.out.println("-----------start");

        Thread threadA = new Thread(new Runnable() {
            public void run() {
                synchronized (lockA) {
                    System.out.println("----------- A start");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockB) {
                        System.out.println("----------- A end");
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            public void run() {
                synchronized (lockB) {
                    System.out.println("----------- B start");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockA) {
                        System.out.println("----------- B end");
                    }
                }
            }
        });
        threadA.start();
        threadB.start();

        if (Thread.activeCount() >1) {
            Thread.yield();
        }

        System.out.println("----------- main end");
    }
}