package com.movit.study.collections;

import java.util.*;

/**
 * Created by admin on 2017/1/30.
 */
public class ListDemo {
    public static void main(String [] args){
        Collection collection1 = Arrays.asList(new Integer(1),new Integer(2),new Integer(3));

        List collection2 = new ArrayList(collection1);
        Collections.addAll(collection2, 4, 5);

        for (Object collection: collection2){
            System.out.println(collection);
        }

    }
}
