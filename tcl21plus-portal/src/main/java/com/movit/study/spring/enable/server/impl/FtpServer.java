package com.movit.study.spring.enable.server.impl;

import org.springframework.stereotype.Component;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-12-26 14:03
 ************************************************************/

@Component
public class FtpServer implements Server {
    @Override
    public void start() {
        System.out.println("Ftp server starting-------");
    }

    @Override
    public void stop() {
        System.out.println("Ftp server stop-------");
    }
}
