package com.movit.study.base_of_java.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/************************************************************
 * @Description:
 * @Author: jerry.zheng
 * @Date Created in 15:10 2018\3\28 0028        
 ************************************************************/

public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(1000);
                return Math.random()*1000 + "";
            }
        };

        FutureTask<String> futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println(futureTask.get());
    }

}
