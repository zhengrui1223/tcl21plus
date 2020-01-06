package com.movit.study.spring.propertysource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/************************************************************
 * @Description: TODO
 * @Author: zhengrui
 * @Date 2019-12-28 15:11
 ************************************************************/

@Configuration
@PropertySource(value = "classpath:common.properties")
public class SourceConfig {

    @Autowired
    private Environment env;

    public String getTest() {
        return env.getProperty("hello");
    }
}
