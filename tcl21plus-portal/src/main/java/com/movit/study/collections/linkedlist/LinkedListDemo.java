package com.movit.study.collections.linkedlist;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by admin on 2017/1/31.
 */
public class LinkedListDemo {
    public static void main(String [] args){

        Collection collection = Arrays.asList("a","b","c","d");

        LinkedList<String> list = new LinkedList<String>(collection);
        list.addFirst("1111");
        list.addLast("2222");
        list.add("3333");

        System.out.println(list);



    }
}
