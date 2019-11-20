package com.movit.study.socket.netty.LineBasedFrameDecoder.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.atomic.AtomicInteger;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-11-17 20:14
 ************************************************************/

@SuppressWarnings("Duplicates")
public class TimeClientHandler2 extends ChannelHandlerAdapter {

    private byte[] req;
    private AtomicInteger counter = new AtomicInteger(1);

    public TimeClientHandler2() {
        req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf message = null;
        for (int i = 0; i < 100; i++) {
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
            System.out.println("send" + i);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        int count = counter.getAndIncrement();
        System.out.println("Now is : " + body + "; counter: " + count);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getMessage());
        ctx.close();
    }
}
