package com.movit.study.socket.netty.FixedLengthFrameDecoder.client;

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
public class TimeClientHandler4 extends ChannelHandlerAdapter {

    public TimeClientHandler4() {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf message = null;
        byte [] send1 = "helloworld".getBytes();
        message = Unpooled.copiedBuffer(send1);
        ctx.writeAndFlush(message);

        byte [] send2 = "hello world".getBytes();
        message = Unpooled.copiedBuffer(send2);
        ctx.writeAndFlush(message);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getMessage());
        ctx.close();
    }
}
