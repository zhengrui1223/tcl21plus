package com.movit.study.socket.bio;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.PrintWriter;
        import java.net.Socket;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-10-26 16:03
 ************************************************************/

public class TimeClient {

    public static void main(String[] args) {
        int port = 8088;

        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {

            socket = new Socket("127.0.0.1", port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println("Query Time order");
            System.out.println("Send order to server succeed");
            String resp = reader.readLine();
            System.out.println("Now is :" + resp);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

}
