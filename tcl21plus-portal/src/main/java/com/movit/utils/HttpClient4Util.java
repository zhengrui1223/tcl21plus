package com.movit.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/2/8.
 */
public class HttpClient4Util {
    private static Logger log = LoggerFactory.getLogger(HttpClient4Util.class);

    public static String callByGet(HttpGet httpGet) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

            HttpEntity entity = httpResponse.getEntity();
            String result = parseResponse(entity);
            httpResponse.close();

            return result;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static String callByPost(Object obj, HttpPost httpPost) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {

            ObjectMapper objectMapper = JSONUtil.defaultObjectMapper();
            String json = objectMapper.writeValueAsString(obj);
            StringEntity stringEntity = new StringEntity(json);
            stringEntity.setContentType("application/json");

            httpPost.setEntity(stringEntity);
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

            HttpEntity entity = httpResponse.getEntity();
            String result = parseResponse(entity);
            httpResponse.close();
            return result;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    private static String parseResponse(HttpEntity entity) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            InputStream inputStream = entity.getContent();
            int len;
            byte[] tmp = new byte[2048];

            while ((len = inputStream.read(tmp)) != -1) {
                stringBuffer.append(new String(tmp, 0, len));
            }
            inputStream.close();
            return stringBuffer.toString();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
