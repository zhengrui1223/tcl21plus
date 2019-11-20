package com.movit.study.socket.netty.DelimiterBasedFrameDecoder.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-11-17 18:28
 ************************************************************/

@SuppressWarnings("Duplicates")
public class TimeServerHandler3 extends ChannelHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String body = (String) msg;

        System.out.println(" The time server receive order : " + body);
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body.trim()) ? new Date(System.currentTimeMillis()).toString() : "Bad order";
        currentTime = currentTime + "$_";
        ByteBuf byteBuf = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(byteBuf);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getMessage());
        ctx.close();
    }
}
