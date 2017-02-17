package com.movit.study.thread.pruduce_consume;

/**
 * Created by Administrator on 2017/2/17.
 */
public class ConsumerThread implements Runnable {
    private PublicResource publicResource;

    public ConsumerThread(PublicResource publicResource) {
        this.publicResource = publicResource;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publicResource.consume();
        }
    }
}
