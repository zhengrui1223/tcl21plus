package com.movit.study.socket.netty.NoDecoder.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-11-17 18:28
 ************************************************************/

@SuppressWarnings("Duplicates")
public class TimeServerHandler extends ChannelHandlerAdapter {

    private AtomicInteger counter = new AtomicInteger(1);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf buf = (ByteBuf) msg;

        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);

        String body = new String(req, StandardCharsets.UTF_8);
        int count = counter.getAndIncrement();
        System.out.println( "counter: " + count + " The time server receive order : " + body);
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body.trim()) ? new Date(System.currentTimeMillis()).toString() : "Bad order";
        ByteBuf byteBuf = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(byteBuf);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
