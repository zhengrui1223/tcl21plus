package com.movit.study.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by admin on 2017/2/1.
 */
public class ReverseArrayList<T> extends ArrayList<T> {
    public ReverseArrayList(Collection<T> c){
        super(c);
    }

    public Iterator<T> reversed(){
        return new Iterator<T>() {
            int current = size() - 1;
            public boolean hasNext() {
                return current > -1;
            }

            public T next() {
                return get(current--);
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String [] args){
        ReverseArrayList arrayList = new ReverseArrayList(Arrays.asList("to be or not to be".split(" ")));

        System.out.println(arrayList);

        Iterator iterator = arrayList.reversed();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.print(next+" ");
        }

    }
}
