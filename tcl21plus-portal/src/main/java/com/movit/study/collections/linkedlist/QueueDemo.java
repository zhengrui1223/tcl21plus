package com.movit.study.collections.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by admin on 2017/2/1.
 */
public class QueueDemo {

    public static void  main(String [] args){
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);


        //返回队列队头
        Integer peek = queue.peek();
        System.out.println(queue);
        System.out.println("peek :" + peek);
        System.out.println("------------------------------------");

        //返回队列队头
        Integer element = queue.element();
        System.out.println(queue);
        System.out.println("element :" + element);
        System.out.println("------------------------------------");

        //返回队列队头并取出来(即移除)
        Integer poll = queue.poll();
        System.out.println("poll :" + poll);
        System.out.println(queue);
        System.out.println("------------------------------------");

        //清空队列
        while (queue.peek() != null){
            System.out.println("移除了 " + queue.peek());
            queue.remove();
        }
    }
}
