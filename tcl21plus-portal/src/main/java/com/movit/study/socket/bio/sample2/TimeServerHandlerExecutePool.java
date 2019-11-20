package com.movit.study.socket.bio.sample2;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-10-26 17:58
 ************************************************************/

public class TimeServerHandlerExecutePool {

    private ThreadPoolExecutor threadPoolExecutor;

    public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
        this.threadPoolExecutor = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                maxPoolSize,
                120L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueSize));
    }

    public void execute(Runnable task) {
        threadPoolExecutor.execute(task);
    }
}
