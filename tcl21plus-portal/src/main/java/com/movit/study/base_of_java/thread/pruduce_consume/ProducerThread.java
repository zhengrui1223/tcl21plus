package com.movit.study.base_of_java.thread.pruduce_consume;

/**
 * Created by Administrator on 2017/2/17.
 */
public class ProducerThread implements Runnable {
    private PublicResource publicResource;

    public ProducerThread(PublicResource publicResource) {
        this.publicResource = publicResource;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publicResource.produce();
        }
    }
}
