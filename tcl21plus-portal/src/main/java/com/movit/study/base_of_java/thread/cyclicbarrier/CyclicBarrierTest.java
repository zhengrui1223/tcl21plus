package com.movit.study.base_of_java.thread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/************************************************************
 * @Description: 回环栅栏, 计算器可重用, 底层用lock, condition实现
 * @Author: zhengrui
 * @Date 2019-12-06 14:14
 ************************************************************/

@SuppressWarnings("Duplicates")
public class CyclicBarrierTest {

    public static synchronized void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(2);
        new Thread(() -> {
            System.out.println("1111");
            try {
                barrier.await();
                System.out.println("1111: " + System.nanoTime());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.println("2222");
            try {
                barrier.await();
                System.out.println("2222: " + System.nanoTime());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        while (barrier.getNumberWaiting() >0) Thread.yield();

        //while (barrier.isBroken()) Thread.yield();

        System.out.println("main end");
    }

}
