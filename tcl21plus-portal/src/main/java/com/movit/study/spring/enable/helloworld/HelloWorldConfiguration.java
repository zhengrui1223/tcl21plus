package com.movit.study.spring.enable.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-12-25 21:26
 ************************************************************/

@Configuration
public class HelloWorldConfiguration  {

    @Bean
    public String helloWorld() {
        return "hello world!!!";
    }

}
