package com.movit.study.spring.enable.helloworld;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/************************************************************
 * @Description: TODO
 * @Author: zhengrui
 * @Date 2019-12-25 21:27
 ************************************************************/

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloWorldConfiguration.class)
public @interface EnableHelloWorld {
}
