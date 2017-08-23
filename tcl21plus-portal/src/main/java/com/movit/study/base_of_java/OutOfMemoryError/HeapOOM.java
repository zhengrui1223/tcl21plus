package com.movit.study.base_of_java.OutOfMemoryError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MOVITECH-5-e450 on 2017/6/22.
 * JVM堆内存设置:    -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class HeapOOM {
    static class OOMObject{}

    public static void main(String args[]) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
