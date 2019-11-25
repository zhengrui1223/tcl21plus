package com.movit.study.base_of_java.thread.lock;

import java.util.concurrent.locks.LockSupport;

/************************************************************
 * @Description: TODO
 * @Author: zhengrui
 * @Date 2019-11-23 13:36
 ************************************************************/

public class LockSupportTest {

    public static void main(String[] args) {

        Thread thread = Thread.currentThread();
        LockSupport.park();

        LockSupport.unpark(thread);
        System.out.println("--");

    }

}
