package com.movit.study.base_of_java.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by admin on 2017/2/1.
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");

        System.out.println("遍历方法1 map.keySet()------------------------------------");
        for (String key : map.keySet()) {
            System.out.print("key :" + key);
            System.out.println(" value :" + map.get(key));
        }

        System.out.println("遍历方法2 map.entrySet()------------------------------------");
        for (Map.Entry<String, String> entity : map.entrySet()) {
            System.out.print("key :" + entity.getKey());
            System.out.println(" value :" + entity.getValue());
        }

        System.out.println("遍历方法3 map.keySet().iterator()------------------------------------");
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = map.get(key);
            System.out.print("key :" + key);
            System.out.println(" value :" + value);
        }

        System.out.println("遍历方法4 map.entrySet().iterator()------------------------------------");
        Iterator<Map.Entry<String, String>> iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, String> entry = iterator1.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.print("key :" + key);
            System.out.println(" value :" + value);
        }

        System.out.println("遍历获取value values------------------------------------");
        Collection<String> values = map.values();
        for (String value : values) {
            System.out.println(value);
        }

        System.out.println("遍历获取value iterator------------------------------------");
        Iterator<String> iterator2 = map.values().iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

    }
}
