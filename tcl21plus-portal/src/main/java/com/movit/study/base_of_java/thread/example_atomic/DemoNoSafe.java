package com.movit.study.base_of_java.thread.example_atomic;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-10-27 9:30
 ************************************************************/
@SuppressWarnings("Duplicates")
public class DemoNoSafe {

    public static void main(String[] args) throws InterruptedException {
        final WithNoAtomic withNoAtomic = new WithNoAtomic();

        int index = 0;
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                withNoAtomic.service();
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }

    }
}

class WithNoAtomic {
    private long count = 0;

    public long getCount() {
        return count;
    }

    public void service() {
        //do some thing
        System.out.println("执行自增 " + (++count));
    }
}
