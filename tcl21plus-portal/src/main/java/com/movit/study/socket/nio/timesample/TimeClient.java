package com.movit.study.socket.nio.timesample;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-10-26 16:03
 ************************************************************/

public class TimeClient {

    public static void main(String[] args) {
        int port = 8088;

        new Thread(new TimeClientHandle("127.0.0.1", port)).start();
    }

}
