package com.movit.study.socket.bio;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-10-26 16:07
 ************************************************************/

public class TimeServerHandler implements Runnable{

    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            writer = new PrintWriter(this.socket.getOutputStream(), true);

            String currentTime;
            String body;
            while (true) {

                body = reader.readLine();
                if (body == null) {
                    break;
                }

                System.out.println("The time server receive order : " + body);
                currentTime = "Query Time order".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "Bad order";
                writer.println(currentTime);
            }

        } catch (IOException e) {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if (writer != null) {
                writer.close();
            }

            if (this.socket != null) {
                try {
                    this.socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                this.socket = null;
            }
        }
    }

}
