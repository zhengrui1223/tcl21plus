package com.movit.study.collections.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by admin on 2017/1/31.
 */
public class IteratorDemo {
    public static void main(String [] args){
        List<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        ListIterator<String> listIterator = list.listIterator();
        //ListIterator<String> listIterator = list.listIterator(2);
        while (listIterator.hasNext()){
            String next = listIterator.next();
            System.out.println(next);
            listIterator.set("111111");
        }


        ListIterator<String> listIterator1 = list.listIterator();
        while (listIterator1.hasNext()){
            String next = listIterator1.next();
            System.out.println(next);
        }

    }
}
