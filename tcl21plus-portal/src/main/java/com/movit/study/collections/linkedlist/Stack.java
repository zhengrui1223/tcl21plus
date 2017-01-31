package com.movit.study.collections.linkedlist;

import java.util.LinkedList;

/**
 * Created by admin on 2017/1/31.
 * 栈 通常是指 [后进先出]
 * 最后压入栈的元素,第一个弹出来
 */
public class Stack<T> {

    private LinkedList<T> storage = new LinkedList<T>();

    public void push(T obj) {
        storage.addFirst(obj);
    }

    public T get() {
        return storage.getFirst();
    }

    public T pop() {
        return storage.removeFirst();
    }

    public boolean empty() {
        return storage.isEmpty();
    }

    public String toString() {
        return storage.toString();
    }

    public static void main(String[] args) {
        /*Stack<String> stack = new Stack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        System.out.println(stack.toString());

        System.out.println("获取第一个" + stack.get());

        System.out.println("移除一个");
        stack.pop();

        System.out.println(stack.toString());*/

        /**
         * 表达式求值, 其中 "+" 便是 "将后面的字母压进栈", 而"-" 表示 "弹出栈顶字母并打印它"
         */
        Stack<String> stack = new Stack<String>();
        String str = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+s---";

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+') {
                stack.push(chars[i + 1] + "");
                System.out.println("当前栈: " + stack.toString());
            }

            if (chars[i] == '-' && !stack.empty()) {
                String pop = stack.pop();
                System.out.println("弹出栈顶元素:" + pop);
                System.out.println("当前栈: " + stack.toString());
            }
        }
    }
}
