package com.movit.study.bean_utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperTest {
    public static void main(String [] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Student1 student1 = new Student1();
        student1.setNAME("zhangsan");
        student1.setPASSWORD("123456");

        String asString = objectMapper.writeValueAsString(student1);
        System.out.println(asString);

    }
}
