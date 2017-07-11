package com.movit.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class HttpClientUtil {
    protected Log log = LogFactory.getLog(getClass());

    /**
     *
     * @param url
     * @param object
     * @param accessToken
     * @return
     */
    private JSONObject create(String url, JSONObject object, String accessToken) {
        JSONObject jsonResp = new JSONObject();
        CloseableHttpClient httpClient = SSLUtil.createSSLInsecureClient();
        HttpPost post = new HttpPost(url);
        try {
            post.setHeader("Authorization", "Bearer " + accessToken);
            post.setEntity(new StringEntity(object.toString(), ContentType.APPLICATION_JSON));
            HttpResponse response = httpClient.execute(post);
            log.info("POST call returned a status code: " + response.getStatusLine().getStatusCode());
            jsonResp = handleResponse(response);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            try {
                post.releaseConnection();
                httpClient.close();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return jsonResp;
    }

    /**
     *
     * @param patchUrl
     * @param object
     * @param userToken
     * @return
     */
    private JSONObject update(String patchUrl, JSONObject object, String userToken) {
        JSONObject jsonResp = new JSONObject();
        CloseableHttpClient httpClient = SSLUtil.createSSLInsecureClient();
        HttpPatch patch = new HttpPatch(patchUrl);
        try {
            patch.setHeader("Authorization", "Bearer " + userToken);
            patch.setEntity(new StringEntity(object.toString(), ContentType.APPLICATION_JSON));
            HttpResponse response = httpClient.execute(patch);
            log.info("PATCH call returned a status code: " + response.getStatusLine().getStatusCode());
            jsonResp = handleResponse(response);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            try {
                patch.releaseConnection();
                httpClient.close();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

        return jsonResp;
    }

    /**
     *
     * @param deleteUrl
     * @param accessToken
     * @return
     */
    private JSONObject delete(String deleteUrl, String accessToken) {
        JSONObject jsonResp = new JSONObject();
        CloseableHttpClient httpClient = SSLUtil.createSSLInsecureClient();
        HttpDelete delete = new HttpDelete(deleteUrl);
        try {
            delete.setHeader("Authorization", "Bearer " + accessToken);
            HttpResponse response = httpClient.execute(delete);
            log.info("Delete call returned a status code: " + response.getStatusLine().getStatusCode());
            jsonResp = handleResponse(response);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            try {
                delete.releaseConnection();
                httpClient.close();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

        return jsonResp;
    }

    /**
     *
     * @param url
     * @param queryParams
     * @param accessToken
     * @return
     */
    private JSONObject query(String url, Map<String, String> paramsMap, String accessToken) {
        JSONObject jsonResp = new JSONObject();
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        //拼接get方式URL, url?a=11&b=22
        if (!paramsMap.isEmpty()) {
            for (String key: paramsMap.keySet()) {
                params.add(new BasicNameValuePair(key, paramsMap.get(key)));
            }
        }
        url += StringPool.QUESTION + URLEncodedUtils.format(params, StringPool.UTF8);

        CloseableHttpClient httpClient = SSLUtil.createSSLInsecureClient();
        HttpGet get = new HttpGet(url);
        try {
            get.setHeader("Authorization", "Bearer " + accessToken);
            HttpResponse response = httpClient.execute(get);
            jsonResp = handleResponse(response);

        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            try {
                get.releaseConnection();
                httpClient.close();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

        return jsonResp;
    }

    /**
     * Handle response
     *
     * @param response
     * @return TODO: need to explicit the return type
     * @throws IOException
     */
    private JSONObject handleResponse(HttpResponse response)
            throws IOException {
        JSONObject jsonResp = new JSONObject();
        HttpEntity entity = response.getEntity();
        if (HttpStatus.SC_UNAUTHORIZED == response.getStatusLine().getStatusCode()) {
            String result = EntityUtils.toString(entity);
            JSONObject obj = new JSONArray(result).getJSONObject(0);
            if (StringUtils.equals("INVALID_SESSION_ID", obj.getString("errorCode"))) {
                jsonResp.put("tokenExpired", true);
            }
        } else if (HttpStatus.SC_CREATED == response.getStatusLine().getStatusCode()) {
            String result = EntityUtils.toString(entity);
            jsonResp = new JSONObject(result);
        } else if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
            String result = EntityUtils.toString(entity);
            if (StringUtils.isNotBlank(result) && result.contains("{")) {
                jsonResp = new JSONObject(result);
            } else {
                jsonResp.put("return", result);
            }
        } else if (HttpStatus.SC_NO_CONTENT == response.getStatusLine().getStatusCode()) {
            jsonResp = new JSONObject();
        } else if (HttpStatus.SC_BAD_REQUEST == response.getStatusLine().getStatusCode()) {
            String result = EntityUtils.toString(entity);
            jsonResp.put("error", result);
        } else {
            String result = EntityUtils.toString(entity);
            jsonResp.put("error", result);
        }
        return jsonResp;
    }
}
