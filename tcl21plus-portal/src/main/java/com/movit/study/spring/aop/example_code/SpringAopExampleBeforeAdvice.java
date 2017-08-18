package com.movit.study.spring.aop.example_code;


import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SpringAopExampleBeforeAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] objects, Object object) throws Throwable {
        System.out.println("before advice running...");
    }
}
