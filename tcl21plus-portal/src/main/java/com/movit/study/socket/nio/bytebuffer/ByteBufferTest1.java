package com.movit.study.socket.nio.bytebuffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-10-28 14:57
 *
 *      position    当前读取的位置。
 *      mark        为某一读过的位置做标记，便于某些时候回退到该位置。
 *      capacity    初始化时候的容量。
 *      limit       当写数据到buffer中时，limit一般和capacity相等，当读数据时，limit代表buffer中有效数据的长度。
 *
 *      Buffer clear()  把position设为0，把limit设为capacity，一般在把数据写入Buffer前调用。
 *      Buffer flip() 　把limit设为当前position，把position设为0，一般在从Buffer读出数据前调用。
 *      Buffer rewind() 把position设为0，limit不变，一般在把数据重写入Buffer前调用。
 *      compact()       将 position 与 limit之间的数据复制到buffer的开始位置，复制后 position = limit -position,limit = capacity,
 *          但如果position 与limit 之间没有数据的话发，就不会进行复制。
 *      mark() & reset()     通过调用Buffer.mark()方法，可以标记Buffer中的一个特定position。之后可以通过调用Buffer.reset()方法恢复到这个position。
 *      https://blog.csdn.net/xialong_927/article/details/81044759
 ************************************************************/

public class ByteBufferTest1 {

    public static void main(String args[]) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("E:/test.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        int size = (int) inChannel.size();
        byte [] all = new byte[size];

        ByteBuffer buf = ByteBuffer.allocate(2);
        int count = 0;
        int position = 0;
        while ((count = inChannel.read(buf) )!= -1) {

            buf.flip();
            byte [] b = new byte[count];
            buf.get(b);
            System.arraycopy(b, 0, all, position, count);

            buf.clear();
            position = position + count;
        }

        String string = new String(all, StandardCharsets.UTF_8);
        System.out.print(string);
        aFile.close();

    }

}
