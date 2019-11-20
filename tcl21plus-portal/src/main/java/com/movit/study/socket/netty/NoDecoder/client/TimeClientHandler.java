package com.movit.study.socket.netty.NoDecoder.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-11-17 20:14
 ************************************************************/

@SuppressWarnings("Duplicates")
public class TimeClientHandler extends ChannelHandlerAdapter {

    private byte[] req;
    private AtomicInteger counter = new AtomicInteger(1);

    public TimeClientHandler() {
        req = "QUERY TIME ORDER\r\n".getBytes();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buffer = null;
        for (int i = 0; i < 100; i++) {
            buffer = Unpooled.copiedBuffer(req);
            ctx.writeAndFlush(buffer);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, StandardCharsets.UTF_8);
        int count = counter.getAndIncrement();
        System.out.println("Now is : " + body + "; counter: " + count);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
