package com.movit.study.base_of_java.thread.vector_test;

import java.util.Vector;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-10-31 9:31
 ************************************************************/
public class VectorDemo {
    private static Vector<Integer> vector = new Vector();

    public static void main(String[] args) {

        for (int i = 0; i < 1000000; i++) {
            vector.add(i);
        }

        Thread removeThread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < vector.size(); i++) {
                    System.out.println("remove " + vector.get(i));
                    vector.remove(i);
                }
            }
        });

        Thread printThread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < vector.size(); i++) {
                    System.out.println("get " + vector.get(i));
                }
            }
        });

        removeThread.start();
        printThread.start();

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
    }

}
