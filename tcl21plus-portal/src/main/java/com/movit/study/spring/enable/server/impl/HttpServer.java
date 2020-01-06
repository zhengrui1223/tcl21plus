package com.movit.study.spring.enable.server.impl;

import org.springframework.stereotype.Component;

/************************************************************
 * @Description: TODO
 * @Author: zhengrui
 * @Date 2019-12-26 14:03
 ************************************************************/

@Component
public class HttpServer implements Server {
    @Override
    public void start() {
        System.out.println("Http server starting-------");
    }

    @Override
    public void stop() {
        System.out.println("Http server stop-------");
    }
}
