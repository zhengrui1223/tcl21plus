package com.movit.study.spring.enable.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-12-25 21:27
 ************************************************************/

@EnableHelloWorld
public class EnableTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(EnableTest.class);
        applicationContext.start();

        String helloWorld = applicationContext.getBean("helloWorld", String.class);
        System.out.println(helloWorld);
    }

}
