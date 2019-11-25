package com.movit.study.base_of_java.thread.interrupt;

/************************************************************
 * @Description: interrupt来标记中断, isInterrupted和interrupted来获取中断标识
 *
 * isInterrupted:是指当前线程对象的中断标识
 * interrupted:当前运行该方法的线程的中断标识, 获取后会清除标识
 *
 * @Author: zhengrui
 * @Date 2019-11-23 2:23
 ************************************************************/

public class InterruptDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread threadB = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Thread B");
                    }
                }, "B");

                try {
                    threadB.join();
                } catch (InterruptedException e) {
                }
                threadB.start();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName());
                }

                System.out.println("是否停止: " + Thread.interrupted());
                System.out.println("是否停止: " + threadB.isInterrupted());
            }
        }, "A");

        threadA.join();
        threadA.start();
        threadA.interrupt();

        Thread.currentThread().interrupt();

        //System.out.println("A是否停止1: " + Thread.interrupted()); //因为是main线程为执行线程, 如果Thread.interrupt()则为true
        System.out.println("A是否停止1: " + threadA.isInterrupted());



        Thread.sleep(100);
        System.out.println("Main End");

    }

}
