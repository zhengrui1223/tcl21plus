package com.movit.study.base_of_java.thread.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/************************************************************
 * @Description: TODO
 * @Author: jerry.zheng
 * @Date Created in 17:54 2018\3\28 0028        
 ************************************************************/

public class TestUnsafe {
    private static final Unsafe unsafe = getUnsafe();

    public static void main(String[] args) throws NoSuchFieldException {
        long state = unsafe.objectFieldOffset(MyAtomicInteger.class.getDeclaredField("count"));
        System.out.println(state);
    }

    public static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe)f.get(null);
        } catch (Exception e) {
            /* ... */
        }
        return null;
    }

}
