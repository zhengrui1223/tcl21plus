package com.movit.study.base_of_java.thread.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-11-22 17:36
 ************************************************************/

public class BlockQueueTest {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        threadPool.execute(() -> {
            try {
                queue.put("a");
                queue.put("b");
                queue.put("c");
                queue.put("d");
            } catch (InterruptedException e) {
            }
        });

        threadPool.execute(() -> {
            queue.poll();
        });

    }

}
