package com.movit.study.base_of_java.thread.example_atomic;

import java.util.concurrent.atomic.AtomicLong;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-10-27 9:30
 ************************************************************/
public class DemoSafe {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws InterruptedException {
        final WithAtomic withAtomic = new WithAtomic();

        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                withAtomic.service();
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }


}

class WithAtomic {
    private AtomicLong count = new AtomicLong(0);

    public long getCount() {
        return count.get();
    }

    public void service() {
        //do some thing
        System.out.println("执行自增 " + count.incrementAndGet());
    }
}
