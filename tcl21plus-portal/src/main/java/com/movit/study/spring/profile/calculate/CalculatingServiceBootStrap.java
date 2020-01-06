package com.movit.study.spring.profile.calculate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;

/************************************************************
 * @Description: TODO
 * @Author: zhengrui
 * @Date 2020-01-02 13:48
 ************************************************************/

@Configuration
@ComponentScan(basePackageClasses = CalculatingServiceBootStrap.class)
public class CalculatingServiceBootStrap {

    static {
        System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "Java8");
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "Java7");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(CalculatingServiceBootStrap.class);
        context.refresh();

        CalculatingService calculatingService = context.getBean(CalculatingService.class);
        calculatingService.sum(1, 2, 3);
    }

}
