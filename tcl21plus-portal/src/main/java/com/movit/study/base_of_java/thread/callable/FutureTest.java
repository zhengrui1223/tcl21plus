package com.movit.study.base_of_java.thread.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/************************************************************
 * @Description: TODO
 * @Author: jerry.zheng
 * @Date Created in 12:21 2018\3\28 0028        
 ************************************************************/

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Future<List<String>>> futures = new ArrayList<Future<List<String>>>();
        for (int i = 1; i <= 3; i++) {
            futures.add(executorService.submit(new Thread2GetData(100, i)));
        }

        List<String> list = new ArrayList<String>();
        for (Future<List<String>> future : futures) {
            list.addAll(future.get());
        }

        System.out.println(list);
        System.out.println(list.size());

        executorService.shutdown();

    }
}

class Thread2GetData implements Callable<List<String>> {

    private Integer pageSize;
    private Integer pageNum;

    public Thread2GetData(Integer pageSize, Integer pageNum) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }

    public List<String> call() throws Exception {
        return DataBase.getData(pageSize, pageNum);
    }
}
