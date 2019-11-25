package com.movit.study.base_of_java.thread.join_wait;

/************************************************************
 * @Description: 见笔记的sleep() 、join（）、yield（）、wait（）
 * @Author: zhengrui
 * @Date 2019-11-24 14:34
 ************************************************************/

public class TestDemo1 {

    static class Thread1 extends Thread {
        private final Thread2 thread2;

        public Thread1(Thread2 thread2) {
            this.thread2 = thread2;
        }

        @Override
        public void run() {
            System.out.println("Thread1 start...");
            long start = System.currentTimeMillis();
            try {
                thread2.join();
                System.out.println("thread2 wait over, wait: " + (System.currentTimeMillis() - start) / 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread1 end...");
        }
    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            System.out.println("Thread2 start...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread2 end...");
        }
    }

    public static void main(String[] args) {

        Thread2 thread2 = new Thread2();
        Thread1 thread1 = new Thread1(thread2);

        thread2.start();
        thread1.start();
    }

}
