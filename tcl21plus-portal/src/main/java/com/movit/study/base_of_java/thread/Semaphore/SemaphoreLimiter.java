package com.movit.study.base_of_java.thread.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/************************************************************
 * @Description: 信号量
 * @Author: zhengrui
 * @Date 2020-01-06 19:24
 ************************************************************/

public class SemaphoreLimiter {

    private final Semaphore permit = new Semaphore(10, true);
    public void process(int i) {
        try {
            permit.acquire(); // 阻塞的方式
            System.out.println("处理逻辑" + i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void processTry(int i) {
        boolean acquired = permit.tryAcquire();

        if (acquired) {
            try {
                System.out.println("处理业务逻辑" + i);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("释放信号量");
                permit.release();
            }
        } else {
            System.out.println("降级处理");
        }
    }

    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(50);
        SemaphoreLimiter sl = new SemaphoreLimiter();

        for (int i = 0; i < 1000; i++) {
            final int num = i;
            executors.execute(new Runnable() {
                @Override
                public void run() {
                    //sl.process(num);
                    sl.processTry(num);
                }
            });
        }

        executors.shutdown();
    }

}
