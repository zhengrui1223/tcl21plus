package com.movit.study.singleton;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/7/11.
 * 线程安全写法
 */
public class Singleton3 {
    private Map<String, Object> map = new HashMap<String, Object>();
    private static Singleton3 ourInstance = null;

    public static synchronized Singleton3 getInstance() {
        if (ourInstance == null) {
            ourInstance = new Singleton3();
        }
        return ourInstance;
    }

    private Singleton3() {
        map.put("Singleton3 timestamp", new Date().getTime());
    }

    @Override
    public String toString() {
        return String.valueOf(this.map.get("Singleton3 timestamp")) ;
    }
}
