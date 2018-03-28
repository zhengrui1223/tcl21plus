package com.movit.study.base_of_java.thread.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/************************************************************
 * @Description:
 * @Author: jerry.zheng
 * @Date Created in 18:03 2018\3\28 0028        
 ************************************************************/

public class MyAtomicInteger {
    private static final Unsafe unsafe = getUnsafe();

    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(MyAtomicInteger.class.getDeclaredField("value"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    private static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    private volatile int value;

    public Integer get() {
        return this.value;
    }

    public MyAtomicInteger() {
    }

    public MyAtomicInteger(int value) {
        this.value = value;
    }

    public int getAndIncrement() {
        for (; ; ) {
            int current = get();
            int next = current + 1;
            if (compareAndSetValue(current, next)) {
                return current;
            }
        }
    }


    private final boolean compareAndSetValue(int expect, int update) {
        // See below for intrinsics setup to support this
        return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }
}
