package com.movit.study.collections;

import java.util.*;

/**
 * Created by admin on 2017/1/30.
 */
public class ListDemo {
    public static void main(String [] args){
        /*Collection collection1 = Arrays.asList(new Integer(1),new Integer(2),new Integer(3));

        List collection2 = new ArrayList(collection1);
        Collections.addAll(collection2, 4, 5);

        for (Object collection: collection2){
            System.out.println(collection);
        }*/

        List<Apple> apples = new ArrayList<Apple>();
        List<? extends Fruit> list1 = new ArrayList<Fruit>(apples);
        System.out.println(list1);

        List<? super Fruit> list2 = new ArrayList<Fruit>();
        list2.add(new Apple("apple"));
        list2.add(new Orange("orange"));
        System.out.println(list2);

        List<? super Apple> list3 = new ArrayList<Apple>();
        list3.add(new Apple("apple"));

        Object[] objects = list3.toArray();
        System.out.println(objects);

        Apple[] applesArray = list3.toArray(new Apple[0]);

    }
}
