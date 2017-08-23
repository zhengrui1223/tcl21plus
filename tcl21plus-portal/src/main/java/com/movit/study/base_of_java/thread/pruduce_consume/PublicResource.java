package com.movit.study.base_of_java.thread.pruduce_consume;

/**
 * Created by Administrator on 2017/2/16.
 */
public class PublicResource {
    private int product;
    private static final int MAX_PRODUCT = 10;
    private static final int MIN_PRODUCT = 0;

    public synchronized void produce() {
        if (product >= MAX_PRODUCT) {
            try {
                wait();
                System.out.println("产品已满,停止生产");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.product++;
        System.out.println(Thread.currentThread().getName() + " 生产者生产第" + this.product + "个产品.");
        //通知消费者可以取货了
        notifyAll();
    }

    public synchronized void consume() {
        if (product <= MIN_PRODUCT) {
            try {
                wait();
                System.out.println("缺货,稍候再取");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " 消费者取走了第" + this.product + "个产品.");
        this.product--;
        //通知等待去的生产者可以生产产品了
        notifyAll();
    }
}
