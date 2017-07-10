package com.movit.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

public class WebServiceSSLClient2 {
    public static CloseableHttpClient createSSLClientDefault() {
        CloseableHttpClient httpClient = null;
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                // 信任所有
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslFactory = new SSLConnectionSocketFactory(
                    sslContext);
            httpClient = HttpClients.custom().setSSLSocketFactory(sslFactory).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpClient;
    }


    //重载添加超时设置
    public static Map<String, String> webServiceRequest(String url, String xml, String timeOutSecond) {
        Map<String, String> resultMap = new HashMap<String, String>();
        // 返回字符串
        String responseXml = null;
        // 返回状态
        String responseStatusCode = "";
        // 创建参数队列
        CloseableHttpClient httpClient = null;
        //返回异常信息：
        String exceptionType = null;
        try {
            if ("https".equalsIgnoreCase(url.substring(0, 5))) {
                httpClient = createSSLClientDefault();
            } else {
                httpClient = HttpClients.createDefault();
            }
            // 创建HttpPost
            HttpPost httpPost = new HttpPost(url);
            HttpEntity re = new StringEntity(xml, "UTF-8");
            httpPost.setHeader("Content-Type", "application/soap+xml; charset=utf-8");
            httpPost.setEntity(re);
            //添加超时：
            Integer timeOut;
            try {
                timeOut = Float.valueOf(new Float(timeOutSecond) * 1000).intValue();
            } catch (Exception e) {
                timeOut = 2 * 60 * 1000;
            }
            if (timeOut > 0) {
                RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeOut).setConnectTimeout(timeOut).build();//设置请求和传输超时时间
                httpPost.setConfig(requestConfig);
            }
            CloseableHttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                responseStatusCode = response.getStatusLine() != null ? String.valueOf(response.getStatusLine().getStatusCode()) : "";
                try {
                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        responseXml = EntityUtils.toString(entity, "UTF-8");
                    }
                } finally {
                    response.close();
                    httpPost.abort();
                }
            }
        } catch (ConnectTimeoutException e1) {
            e1.printStackTrace();
            exceptionType = "TimeoutException";
        } catch (Exception e) {
            e.printStackTrace();
            exceptionType = "Exception";
        } finally {
            // 关闭连接,释放资源
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                exceptionType = "Exception";
            }
        }
        resultMap.put("statusCode", responseStatusCode);
        resultMap.put("responseBody", responseXml);
        resultMap.put("exception", exceptionType);
        return resultMap;
    }

    public static void main(String[] args) {
//        String  timeOutSecond = "0.001";
//        System.out.println(Float.valueOf(new Float(timeOutSecond) * 1000).intValue());
//        String url = "https://pms-dev.cn.schneider-electric.com:3839/webservice/ESPABillService?wsdl";
//        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webservice.software.com/\"><soapenv:Header/><soapenv:Body><web:createESPABillPrebiding><ESPABillPrebidingRequest><accountName>深圳市剑业机电设备有限公司</accountName><accountNum>201</accountNum><awardedDate>2015-12-28</awardedDate><biddate>2015-12-24</biddate><CWT>Y</CWT><channelType>N</channelType><country>中国</country><countryCode>0</countryCode><countyLevelCity>东辽县</countyLevelCity><countyLevelCityCode>613</countyLevelCityCode><CWTCreateDate>2015-12-23 14:25:32</CWTCreateDate><CWTID>1850</CWTID><CWTTeamMember><BUSpecialFlag>N</BUSpecialFlag><CWTRole>主导</CWTRole><leaderFlag>Y</leaderFlag><mainRole>Cross Function</mainRole><pdRate>100</pdRate><pipe>SGS</pipe><sesaID>SESA176177</sesaID><userName>王雪</userName></CWTTeamMember><CWTTeamMember><BUSpecialFlag>N</BUSpecialFlag><CWTRole>N+1</CWTRole><leaderFlag>N</leaderFlag><mainRole>SGS_Segment Sales</mainRole><pdRate>0</pdRate><pipe>SGS</pipe><sesaID>SESA22431</sesaID><userName>刘晓光</userName></CWTTeamMember><CWTTeamMember><BUSpecialFlag>N</BUSpecialFlag><CWTRole>配合</CWTRole><leaderFlag>N</leaderFlag><mainRole></mainRole><pdRate>0</pdRate><pipe>ECOBB</pipe><sesaID>SESA100009</sesaID><userName>孟杭军</userName></CWTTeamMember><CWTTeamMember><BUSpecialFlag>N</BUSpecialFlag><CWTRole>配合</CWTRole><leaderFlag>N</leaderFlag><mainRole></mainRole><pdRate>0</pdRate><pipe>ECOBB</pipe><sesaID>SESA100033</sesaID><userName>傅志男</userName></CWTTeamMember><productLines><family1code>EVS</family1code><family1Id>655</family1Id><forecastAmt>3333.00</forecastAmt><forecastQuantity>3333</forecastQuantity><l2Id>EVS</l2Id><lineItemId>5085</lineItemId><productLine>PTACB</productLine><productLineId>650</productLineId></productLines><valueChainPlayers><VCPAccoutnName>东莞市华开电气设备有限公司</VCPAccoutnName><VCPAccountNum>100-0011200001CocQjAAJ</VCPAccountNum><VCPAccoutnRole>Vendor</VCPAccoutnRole></valueChainPlayers><forecastAamt>1110000.00</forecastAamt><offerPackageId>43</offerPackageId><offerPackageName>PTACB</offerPackageName><oppId>2778</oppId><opportunityName>SGS-2015-Cross Function-SESA176177-SPA测试-CWT何时锁定-PTACB</opportunityName><pipeStage>05</pipeStage><prefectureLevelCity>辽源</prefectureLevelCity><prefectureLevelCityCode>609</prefectureLevelCityCode><province>吉林</province><provinceCode>580</provinceCode><requestId>C251289</requestId><projectName>SPA测试</projectName><secSegLv1>住宅</secSegLv1><secSegLv1Code>A0000</secSegLv1Code><secSegLv2>别墅/联排 </secSegLv2><secSegLv2Code>A0100</secSegLv2Code><sesaID>SESA176177</sesaID><stage>Pre-bidding</stage></ESPABillPrebidingRequest></web:createESPABillPrebiding></soapenv:Body></soapenv:Envelope>";
//        System.out.println(webServiceRequest(url, xml, "0.01"));
    }
}

