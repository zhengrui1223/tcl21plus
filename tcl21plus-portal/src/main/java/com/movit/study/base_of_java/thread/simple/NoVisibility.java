package com.movit.study.base_of_java.thread.simple;

/**
 * Created by Administrator on 2017/2/16.
 */
public class NoVisibility {
    private static boolean ready = false;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
