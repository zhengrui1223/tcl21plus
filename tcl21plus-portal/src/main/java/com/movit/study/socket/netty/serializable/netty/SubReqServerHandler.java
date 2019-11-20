package com.movit.study.socket.netty.serializable.netty;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/************************************************************
 * @Description: TODO
 * @Author: zhengrui
 * @Date 2019-11-19 21:28
 ************************************************************/

public class SubReqServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SubsribeReq req = (SubsribeReq) msg;

        System.out.println("Server accept req: " + req.toString());

        SubsribeResp resp = new SubsribeResp();
        resp.setId(1);
        resp.setDesc("success");
        resp.setRespCode("200");
        ctx.writeAndFlush(resp);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        ctx.close();
    }
}
