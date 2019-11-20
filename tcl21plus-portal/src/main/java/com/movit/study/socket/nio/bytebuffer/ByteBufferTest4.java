package com.movit.study.socket.nio.bytebuffer;

import java.nio.ByteBuffer;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-10-28 14:57
 ************************************************************/

public class ByteBufferTest4 {

    public static void main(String args[]) {
        ByteBuffer buffer = ByteBuffer.allocate(20);
        String s = "hello";
        buffer.put(s.getBytes());
        buffer.clear();

        byte[] bytes = new byte[20];
        buffer.get(bytes);
        String s1 = new String(bytes);

        System.out.println("--------Test clear----------buffer: " + buffer);
        System.out.println("--------Test clear----------s1: " + s1);
        System.out.println("--------Test clear----------buffer: " + buffer);

    }

}
