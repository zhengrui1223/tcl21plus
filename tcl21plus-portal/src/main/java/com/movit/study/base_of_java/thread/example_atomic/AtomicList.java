package com.movit.study.base_of_java.thread.example_atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-11-01 13:57
 ************************************************************/
public class AtomicList {
    private static AtomicReference<List<Integer>> listAtomicReference = new AtomicReference<List<Integer>>();

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<Integer>();
        listAtomicReference.set(list);

        Runnable runnable = new Runnable() {
            public void run() {
                for (int i=0; i<100; i++) {
                    List<Integer> integers = listAtomicReference.get();
                    integers.add(i);
                    listAtomicReference.set(integers);
                }
            }
        };

        for (int i=0; i<10; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }

        while (Thread.activeCount() >1) {
            //System.out.println(Thread.currentThread().getName());
            Thread.yield();
        }

        List<Integer> integerList = listAtomicReference.get();
        System.out.println(integerList.size());
    }

}
