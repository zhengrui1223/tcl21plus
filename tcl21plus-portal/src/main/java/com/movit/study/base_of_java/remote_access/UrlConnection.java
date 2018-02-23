package com.movit.study.base_of_java.remote_access;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-12-12 15:30
 ************************************************************/

public class UrlConnection {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://172.19.50.196:8080/oem/oem/api/common/forAdmin/fullDownload/8018");
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            Reader reader = new InputStreamReader(inputStream);
            PrintWriter writer = new PrintWriter(System.out);

            char[] c = new char[1024];
            int length;
            while ((length = reader.read(c)) != -1) {
                writer.write(c, 0, length);
            }

            writer.flush();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
