package com.movit.study.base_of_java.singleton;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/7/11.
 * 高效线程安全写法
 */
public class Singleton4 {
    private Map<String, Object> map = new HashMap<String, Object>();
    private static volatile Singleton4 ourInstance = null;

    public static Singleton4 getInstance() {
        if (ourInstance == null) {
            synchronized (Singleton4.class) {
                if (ourInstance == null) {
                    ourInstance = new Singleton4();
                }
            }
        }
        return ourInstance;
    }

    private Singleton4() {
        map.put("Singleton4 timestamp", new Date().getTime());
    }

    @Override
    public String toString() {
        return String.valueOf(this.map.get("Singleton4 timestamp")) ;
    }
}
