package com.movit.study.socket.netty.serializable.netty;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/************************************************************
 * @Description: TODO
 * @Author: zhengrui
 * @Date 2019-11-19 21:28
 ************************************************************/

public class SubRespClientHandler extends ChannelHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SubsribeReq req = new SubsribeReq();
        req.setId(1);
        req.setUserName("张三");
        req.setPhoneNumber("137116461348");
        req.setProductName("电脑");
        req.setAddress("苏州市相城区蠡口");

        ctx.writeAndFlush(req);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SubsribeResp resp = (SubsribeResp) msg;

        System.out.println("Client accept resp : " + resp.toString());
    }
}
