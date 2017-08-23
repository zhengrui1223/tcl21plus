package com.movit.study.base_of_java.singleton;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/7/11.
 * 懒汉式
 * 懒汉式在类第一次被调用的时候再产生实例对象, 会有线程安全问题。
 */
public class Singleton2 {
    private Map<String, Object> map = new HashMap<String, Object>();
    private static Singleton2 ourInstance = null;

    public static Singleton2 getInstance() {
        if (ourInstance == null) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ourInstance = new Singleton2();
        }
        return ourInstance;
    }

    private Singleton2() {
        map.put("Singleton2 timestamp", new Date().getTime());
    }

    @Override
    public String toString() {
        return String.valueOf(this.map.get("Singleton2 timestamp")) ;
    }
}
