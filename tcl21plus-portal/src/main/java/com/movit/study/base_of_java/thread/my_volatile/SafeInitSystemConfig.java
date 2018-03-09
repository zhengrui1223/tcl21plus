package com.movit.study.base_of_java.thread.my_volatile;

import java.util.ArrayList;
import java.util.List;

/************************************************************
 * @Description:
 * @Author: jerry.zheng
 * @Date Created in 15:07 2018\3\8 0008        
 ************************************************************/

/**
 * volatile 保证了可见性和有序性。
 * 当一个线程对一个volatile变量做了更新， 会导致其他线程的工作内存中保存的该变量的值失效。
 *
 */
public class SafeInitSystemConfig {
    volatile public boolean initSystemConfigFlag = false;


    public synchronized void init() {
        while (!initSystemConfigFlag) {
            System.out.println("init system config。。。");
            initSystemConfigFlag = true;
        }
    }

    public static void main(String[] args) {
        SafeInitSystemConfig initSystemConfig = new SafeInitSystemConfig();

        List<Thread> threadList = new ArrayList<Thread>();
        for (int i=0; i<100; i++) {
            ClientThread2 thread = new ClientThread2();
            thread.setInitSystemConfig(initSystemConfig);
            threadList.add(thread);
        }

        for (Thread thread : threadList) {
            thread.start();
        }

        while (Thread.activeCount() >1) {
            System.out.println(Thread.currentThread().getName());
            Thread.yield();
        }
    }

}

class ClientThread2 extends Thread {
    private SafeInitSystemConfig initSystemConfig;

    public void setInitSystemConfig(SafeInitSystemConfig initSystemConfig) {
        this.initSystemConfig = initSystemConfig;
    }

    @Override
    public void run() {
        this.initSystemConfig.init();
    }
}
