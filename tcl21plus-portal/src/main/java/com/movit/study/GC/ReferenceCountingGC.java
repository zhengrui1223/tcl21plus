package com.movit.study.GC;

/**
 * Created by MOVITECH-5-e450 on 2017/6/22.
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024*1024;
    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     *  java采用 [可达性分析]算法 方式实现内存回收:
            这个算法的基本思路就是通过一系列的称为“GC Roots”的对象作为起始点，从这些节点开始向下搜索，搜索所
            走过的路径称为引用链（Reference Chain），当一个对象到GC Roots没有任何引用链相连
            (用图论的话来说，就是从GC Roots到这个对象不可达)时，则证明此对象是不可用的。
     */

    //这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否被回收过
    private byte[] bigSize = new byte[2*_1MB];

    public static void main(String []args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        //循环引用
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        //假设在这行发生GC,objA和objB是否能被回收？
        System.gc();
    }
}
