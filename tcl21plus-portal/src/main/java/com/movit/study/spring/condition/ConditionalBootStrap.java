package com.movit.study.spring.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2020-01-02 14:52
 ************************************************************/

@Configuration
@ComponentScan(basePackageClasses = ConditionalBootStrap.class)
public class ConditionalBootStrap {

    public static void main(String[] args) {
        System.setProperty("language", "en");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(ConditionalBootStrap.class);
        context.refresh();

        String message = context.getBean("message", String.class);
        System.out.println(message);
    }

}
