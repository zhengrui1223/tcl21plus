package com.movit.study.base_of_java.thread.pruduce_consume;

/**
 * Created by Administrator on 2017/2/17.
 */
public class ProduceConsumeTest {
    public static void main(String[] args) {
        PublicResource publicResource = new PublicResource();

        ProducerThread producer = new ProducerThread(publicResource);
        ConsumerThread consumer = new ConsumerThread(publicResource);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

    }
}
