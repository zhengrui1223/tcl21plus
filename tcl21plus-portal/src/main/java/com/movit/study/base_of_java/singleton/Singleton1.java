package com.movit.study.base_of_java.singleton;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/7/11.
 * 饿汉式
 * 饿汉式没有线程安全问题
 * 饿汉式的缺点是类一加载就实例化，提前占用系统资源
 */
public class Singleton1 {
    private Map<String, Object> map = new HashMap<String, Object>();
    private static Singleton1 ourInstance = new Singleton1();

    public static Singleton1 getInstance() {
        return ourInstance;
    }

    private Singleton1() {
        map.put("Singleton1 timestamp", new Date().getTime());
    }

    @Override
    public String toString() {
        return String.valueOf(this.map.get("Singleton1 timestamp")) ;
    }
}
