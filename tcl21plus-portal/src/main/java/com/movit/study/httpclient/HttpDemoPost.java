package com.movit.study.httpclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movit.study.model.User;
import com.movit.utils.JSONUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.InputStream;

/**
 * Created by Administrator on 2017/2/8.
 */
public class HttpDemoPost {
    public static void main(String [] args){
        try {

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://localhost:8080/testUser");

            User user = new User();
            user.setId(111);
            user.setName("fdsfd");
            user.setPassWord("12343");
            ObjectMapper objectMapper = JSONUtil.defaultObjectMapper();
            String json = objectMapper.writeValueAsString(user);

            httpPost.setEntity(new StringEntity(json));
            httpPost.addHeader("Content-type", "application/json");

            HttpResponse response = httpClient.execute(httpPost);
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
