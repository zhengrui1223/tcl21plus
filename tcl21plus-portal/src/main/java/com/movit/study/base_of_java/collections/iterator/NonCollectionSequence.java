package com.movit.study.base_of_java.collections.iterator;

import java.util.Iterator;

/**
 * Created by admin on 2017/2/1.
 */
public class NonCollectionSequence implements Iterable<String>{
    private String[] str = {"a", "b", "c", "d"};

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            public boolean hasNext() {

                return index < str.length;
            }

            public String next() {
                System.out.println("index=" + index);
                return str[index++];
            }

            public void remove() {

            }
        };
    }

    public static void main(String[] args) {
        NonCollectionSequence sequence = new NonCollectionSequence();
        Iterator<String> iterator = sequence.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

        System.out.println("---------------------------");

        for (String str: new NonCollectionSequence()){
            System.out.println(str);
        }

    }
}
