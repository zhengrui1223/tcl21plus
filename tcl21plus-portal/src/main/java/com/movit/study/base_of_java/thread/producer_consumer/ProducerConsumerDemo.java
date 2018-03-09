package com.movit.study.base_of_java.thread.producer_consumer;

/************************************************************  
 * @Description:
 * @Author: jerry.zheng
 * @Date Created in 15:49 2018\3\8 0008        
 ************************************************************/

/**
 * 生产者消费者模式， 我们使用 等待/通知 机制
 *
 * 每个对象的wait方法，notify()，notifyAll()方法
 *
 * 每个类其实都有一个对象监视器(monitor)，这个是我们看不见的，JVM规范定义了线程对内存的操作指令
 * read，load，use，assign，store，write，lock，unlock
 *
 * 然而lock，unlock并没有开放出来供使用， 但是java提供了更高级的字节码指令，monitorenter monitorexit，这两个字节码反映到java中就是synchronized
 *
 * 只有当我们的代码处于同步状态时， 才可以调用wait方法，notify()，notifyAll()
 *
 * 想象一下类似饭店中的场景， 厨师做菜， 服务员端菜， 当厨师没有叫服务员的时候， 服务员就在一旁等着， 厨师一旦喊 2号桌 糖醋排骨好了，那么服务员就要立马端过去。
 * 那么我们可以看成是两个线程， 一个做菜， 一个端菜， 端菜必须要等到有菜才可以进行。一次做太多菜容易凉， 我们规定最多有10道菜在等待服务员端送。
 */
public class ProducerConsumerDemo {

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();

        //厨师做菜线程
        Thread pthread = new PThread(restaurant);

        //服务员送菜线程
        Thread cthread = new CThread(restaurant);

        pthread.start();
        cthread.start();

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
    }

}

class Restaurant {
    private int food = 0;

    public synchronized void makeFood() throws InterruptedException {

        if (food < 10) {
            System.out.println("大厨做了第" + (++food) + " 道菜");

            //菜来了 ， 通知服务员送菜
            notifyAll();
        }
    }

    public synchronized void sendFood() throws InterruptedException {
        if (food == 0) {
            wait();
        }

        //端菜给客人
        System.out.println("服务员端了第" + (food--) + " 道菜");
    }
}

class PThread extends Thread {
    private Restaurant restaurant;

    public PThread(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((long) (Math.random() * 1000));
                restaurant.makeFood();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CThread extends Thread {
    private Restaurant restaurant;

    public CThread(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((long) (Math.random() * 1000));
                restaurant.sendFood();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}