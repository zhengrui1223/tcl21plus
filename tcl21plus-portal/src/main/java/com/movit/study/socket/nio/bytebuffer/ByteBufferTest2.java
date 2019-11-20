package com.movit.study.socket.nio.bytebuffer;

import java.io.FileNotFoundException;
import java.nio.ByteBuffer;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-10-28 14:57
 ************************************************************/

public class ByteBufferTest2 {

    public static void main(String args[]) throws FileNotFoundException {
        System.out.println("----------Test allocate--------");
        System.out.println("before alocate:"
                + Runtime.getRuntime().freeMemory());

        // 如果分配的内存过小，调用Runtime.getRuntime().freeMemory()大小不会变化？
        // 要超过多少内存大小JVM才能感觉到？
        ByteBuffer buffer = ByteBuffer.allocate(102400);
        System.out.println("buffer = " + buffer);

        System.out.println("after alocate:"
                + Runtime.getRuntime().freeMemory());

        // 这部分直接用的系统内存，所以对JVM的内存没有影响
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(102400);
        System.out.println("directBuffer = " + directBuffer);
        System.out.println("after direct alocate:"
                + Runtime.getRuntime().freeMemory());

        System.out.println("----------Test wrap--------");
        //把一个byte数组或byte数组的一部分包装成ByteBuffer。
        byte[] bytes = new byte[32];
        buffer = ByteBuffer.wrap(bytes);
        System.out.println(buffer);

        buffer = ByteBuffer.wrap(bytes, 10, 10);
        System.out.println(buffer);

    }

}
