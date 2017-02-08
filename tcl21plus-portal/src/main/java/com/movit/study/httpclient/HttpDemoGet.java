package com.movit.study.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;


/**
 * Created by Administrator on 2017/2/8.
 */
public class HttpDemoGet {
    public static void main(String [] args) throws UnsupportedEncodingException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //HttpGet httpGet = new HttpGet("http://localhost:8080/testUser");

        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("localhost:8080")
                .setPath("/testUser/1")
                //.setParameter("id", "1")
                .build();

        HttpGet httpGet = new HttpGet(uri);

        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                int len;
                byte[] tmp = new byte[2048];
                while ((len = instream.read(tmp)) != -1) {
                    System.out.println(new String(tmp, 0, len));
                }
            }
        }catch (Exception e){
            e.fillInStackTrace();
        }

    }
}
