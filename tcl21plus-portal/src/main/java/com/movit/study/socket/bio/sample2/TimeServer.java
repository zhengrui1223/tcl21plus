package com.movit.study.socket.bio.sample2;

import com.movit.study.socket.bio.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-10-26 16:03
 ************************************************************/

public class TimeServer {

    public static void main(String[] args) {
        int port = 8088;
        Socket socket = null;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);

            TimeServerHandlerExecutePool pool = new TimeServerHandlerExecutePool(50, 1000);
            while (true) {
                socket = serverSocket.accept();
                pool.execute(new TimeServerHandler(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
