package com.movit.study.spring.propertysource;

import com.alibaba.fastjson.JSON;
import com.movit.study.spring.ioc.annotation_bean.AnnotationBeanUser;
import com.movit.study.spring.ioc.annotation_bean.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import java.util.Properties;

public class AnnotationConfigApplicationContextTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SourceConfig.class);
        context.start();

        SourceConfig bean = context.getBean(SourceConfig.class);
        System.out.println(bean.getTest());

        ConfigurableEnvironment environment = context.getEnvironment();
        String hello = environment.getProperty("hello");
        /*MutablePropertySources propertySources = environment.getPropertySources();
        propertySources.forEach(propertySource -> {
            Object source = propertySource.getSource();
            System.out.println(JSON.toJSONString(source));
        });*/
        //System.out.println(JSON.toJSONString(System.getenv()));
    }
}
