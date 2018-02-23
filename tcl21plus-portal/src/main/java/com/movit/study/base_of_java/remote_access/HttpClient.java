package com.movit.study.base_of_java.remote_access;

import com.movit.utils.WebServiceSSLClient2;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-12-12 18:15
 ************************************************************/
public class HttpClient {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient sslClientDefault = WebServiceSSLClient2.createSSLClientDefault();
        HttpGet httpGet = new HttpGet("https://www.baoli.com/uploadFileList");

        CloseableHttpResponse response = sslClientDefault.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String responseStr = EntityUtils.toString(entity);
        System.out.println(responseStr);
    }

}
