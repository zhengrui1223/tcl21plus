package com.movit.study.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-18 9:28
 ************************************************************/
@Configuration
@ComponentScan(basePackages = "com.movit.study",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {
}
