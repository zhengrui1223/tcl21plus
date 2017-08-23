package com.movit.study.base_of_java.collections.linkedlist;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by admin on 2017/2/1.
 */
public class PriorityQueueDemo {
    public static void  main(String [] args){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        Random random = new Random(47);
        for (int i=0; i<10; i++){
            int rand = random.nextInt(10);
            //queue.add(rand);

            //用offer方法添加元素时,会进行排序,默认使用对象在队列中的自然顺序
            queue.offer(rand);
        }


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
