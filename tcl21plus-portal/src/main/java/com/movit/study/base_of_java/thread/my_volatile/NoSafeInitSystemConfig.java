package com.movit.study.base_of_java.thread.my_volatile;

import java.util.ArrayList;
import java.util.List;

/************************************************************
 * @Description:
 * @Author: jerry.zheng
 * @Date Created in 15:07 2018\3\8 0008        
 ************************************************************/

/**
 * 假设这是一个系统配置初始化类， 当该类第一次被调用时， 就执行初始化动作， 如果执行过， 则之后就不执行。
 * 显然该类不是线程安全的， 因为在多线程下， initSystemConfigFlag被修改为true， 已经获取了initSystemConfigFlag值得线程
 * 却不知道， 继续执行了初始化方法。
 */
public class NoSafeInitSystemConfig {
    public boolean initSystemConfigFlag = false;

    public void init() {
        while (!initSystemConfigFlag) {
            System.out.println("init system config");
            initSystemConfigFlag = true;
        }
    }

    public static void main(String[] args) {
        NoSafeInitSystemConfig initSystemConfig = new NoSafeInitSystemConfig();

        List<Thread> threadList = new ArrayList<Thread>();
        for (int i=0; i<100; i++) {
            ClientThread thread = new ClientThread();
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

class ClientThread extends Thread {
    private NoSafeInitSystemConfig initSystemConfig;

    public void setInitSystemConfig(NoSafeInitSystemConfig initSystemConfig) {
        this.initSystemConfig = initSystemConfig;
    }

    @Override
    public void run() {
        this.initSystemConfig.init();
    }
}
