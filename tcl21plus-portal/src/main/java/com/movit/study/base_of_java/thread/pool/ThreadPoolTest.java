package com.movit.study.base_of_java.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/************************************************************
 * @Description: 线程池
 * @Author: zhengrui
 * @Date 2019-11-22 16:57
 ************************************************************/

public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                5,
                10,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(20),
                new MyThreadFactory(),

                //CallerRunsPolicy:放入任务队列中继续执行
                //AbortPolicy:抛出异常
                //DiscardPolicy:丢弃任务
                //DiscardOldestPolicy:丢弃老任务, 将该任务添加进任务队列
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 1000; i++) {
            threadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        threadPool.shutdown();
    }

}

class MyThreadFactory implements ThreadFactory {
    private AtomicInteger counter = new AtomicInteger(1);
    private final String prefix = "threadPool-";

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, prefix + counter.getAndIncrement());
        System.out.println("new Thread: " + counter.get());
        return thread;
    }
}
