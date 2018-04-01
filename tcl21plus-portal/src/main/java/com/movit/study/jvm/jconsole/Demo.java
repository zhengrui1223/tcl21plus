package com.movit.study.jvm.jconsole;

import java.util.ArrayList;
import java.util.List;

/************************************************************
 * @Description:
 *
 *  启动时， 虚拟机参数设置为  -Xms100m -Xmx100m -XX:+UseSerialGC
 * 1,对象创建后起初在eden space中
 * 2,因为对象一直在创建，当eden space内存使用完后，会触发Minor GC
 * 3,Minor GC后，对象没有被回收，jvm将eden space中的对象复制到survivor space中，而survivor space内存不足，jvm将将其余的对象复制到tenured space中
 * 4,survivor space内存一直是爆满状态的，jvm会将经历几次GC的对象复制到tenured space中
 * 5,survivor space， tenured space都满了， 而eden space还是不停的有对象进来，此时没有多余的空间分配了， 就会报错
        Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at com.movit.study.jvm.jconsole.Demo$OOMObject.<init>(Demo.java:33)
        at com.movit.study.jvm.jconsole.Demo.main(Demo.java:26)

 *
 * @Author: jerry.zheng
 * @Date 2018-04-01 1:50
 ************************************************************/

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();

        for (int i=0; i<2000; i++) {
            Thread.sleep(30);
            list.add(new OOMObject());
        }

        System.gc();
    }

    static class OOMObject {
        private byte[] placeholder = new byte[1024*64];
    }
}
