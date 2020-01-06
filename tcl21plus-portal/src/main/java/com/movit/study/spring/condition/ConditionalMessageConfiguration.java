package com.movit.study.spring.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/************************************************************
 * @Description: TODO
 * @Author: zhengrui
 * @Date 2020-01-02 14:48
 ************************************************************/

@Configuration
public class ConditionalMessageConfiguration {

    @Bean(name = "message")
    @ConditionOnSystemProperty(name = "language", value = "cn")
    public String chineseMessage() {
        return "你好, 世界";
    }

    @Bean(name = "message")
    @ConditionOnSystemProperty(name = "language", value = "en")
    public String englishMessage() {
        return "hello, world";
    }
}
