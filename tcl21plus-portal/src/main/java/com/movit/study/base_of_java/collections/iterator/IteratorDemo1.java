package com.movit.study.base_of_java.collections.iterator;

import java.util.*;

/**
 * Created by admin on 2017/1/31.
 */
public class IteratorDemo1 {

    List<Integer> ll = new LinkedList<Integer>();
    ListIterator li = ll.listIterator();

    public List getList() {
        if (!li.hasNext()) {
            li.add(1);
            // System.out.print(" "+li.nextIndex());
            //System.out.print(" "+li.previousIndex());

        }

        Random random = new Random();
        int max = random.nextInt(10);
        System.out.println("随机数为: " + max);

        for (int i = 1; i < max; i = i + 2) {
            if (li.hasNext()) {
                li.add(i);
            }
            if (li.hasPrevious()) {
                li.add(i + 1);
                li.previous();
            }
        }
        return ll;
    }

    public static void main(String[] args) {
        /*
        创建一个空的LinkedList<Integer>,通过使用ListIterator,
        将若干个Integer插入到list中,插入时,总是将他们插入到List的中间
         */
        IteratorDemo1 lld = new IteratorDemo1();
        List<Integer> l = lld.getList();
        for (Integer j : l)
            System.out.println(j + " ");
    }
}
