package com.movit.study.httpclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movit.study.model.User;
import com.movit.utils.JSONUtil;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/8.
 */
public class ConvertToJson {
    public static void main(String[] args) throws JsonProcessingException {
        /*User user = new User();
        user.setId(111);
        user.setName("fdsfd");
        user.setPassWord("12343");

        ObjectMapper objectMapper = JSONUtil.defaultObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);*/

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("id", "1111"));
        ObjectMapper objectMapper = JSONUtil.defaultObjectMapper();
        String json = objectMapper.writeValueAsString(pairs);
        System.out.println(json);
    }
}
