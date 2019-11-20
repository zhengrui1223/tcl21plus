package com.movit.study.socket.nio.timesample;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-10-26 16:03
 ************************************************************/

public class TimeServer {

    public static void main(String[] args) {
        int port = 8088;
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }

}
