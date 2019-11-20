package com.movit.study.socket.netty.serializable.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/************************************************************
 * @Description: TODO
 * @Author: zhengrui
 * @Date 2019-11-19 21:28
 ************************************************************/

public class SubRespClient {

    public void connect(int port) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(bossGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast(new ObjectDecoder(1024 * 1024,
                                    ClassResolvers.weakCachingConcurrentResolver(this.getClass().getClassLoader())));

                            pipeline.addLast(new ObjectEncoder());
                            pipeline.addLast(new SubRespClientHandler());
                        }
                    });

            ChannelFuture future = bootstrap.connect("127.0.0.1", port).sync();
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new SubRespClient().connect(8088);
    }

}
