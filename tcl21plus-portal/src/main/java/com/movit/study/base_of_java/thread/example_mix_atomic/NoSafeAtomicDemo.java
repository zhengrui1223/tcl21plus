package com.movit.study.base_of_java.thread.example_mix_atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-10-27 9:30
 ************************************************************/

/**
 * 因为保证不了原子性， 即使各自的对象是线程安全的，
 * 但是在混合操作中， 需要用其它的手段来保证混合操作的原子性。
 */
public class NoSafeAtomicDemo {
    public static void main(String[] args) throws InterruptedException {
        final NoSafeAtomic noSafeAtomic = new NoSafeAtomic();
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                noSafeAtomic.service(new Random().nextInt(10));
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}

class NoSafeAtomic {
    private AtomicReference<Integer> lastNumber = new AtomicReference<Integer>();
    private AtomicReference<List<Integer>> cache = new AtomicReference<List<Integer>>();

    public synchronized void service(Integer i) {
        if (i.equals(lastNumber.get())) {
            System.out.println(cache.get());
        } else {
            lastNumber.set(i);
            List<Integer> integers = cache.get();
            if (integers == null) {
                integers = new ArrayList<Integer>();
            }
            integers.add(i);
            cache.set(integers);
        }
    }
}