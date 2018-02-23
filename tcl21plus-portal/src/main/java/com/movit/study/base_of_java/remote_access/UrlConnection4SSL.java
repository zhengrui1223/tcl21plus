package com.movit.study.base_of_java.remote_access;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-12-12 15:30
 ************************************************************/

public class UrlConnection4SSL {

    public static void main(String[] args) {
        try {
            /*//创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = {new MyX509TrustManager ()};
            SSLContext sslContext = SSLContext.getInstance("SSL","SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());

            //从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();*/

            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                // 信任所有
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            //创建HttpsURLConnection对象，并设置其SSLSocketFactory对象
            URL url = new URL("https://www.baoli.com/uploadFileList");
            HttpsURLConnection httpsConn = (HttpsURLConnection)url.openConnection();
            httpsConn.setRequestMethod("GET");
            httpsConn.setSSLSocketFactory(ssf);

            InputStream inputStream = httpsConn.getInputStream();
            Reader reader = new InputStreamReader(inputStream);
            PrintWriter writer = new PrintWriter(System.out);

            char[] c = new char[1024];
            int length;
            while ((length = reader.read(c)) != -1) {
                writer.write(c, 0, length);
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
