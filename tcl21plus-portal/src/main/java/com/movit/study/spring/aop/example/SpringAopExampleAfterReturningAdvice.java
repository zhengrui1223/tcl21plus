package com.movit.study.spring.aop.example;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * you can't change the returnValue
 * if you want , use Around Advice
 */
public class SpringAopExampleAfterReturningAdvice implements AfterReturningAdvice {

    public void afterReturning(Object returnValue, Method method, Object[] objects, Object target) throws Throwable {
        System.out.println("after return " + new ObjectMapper().writeValueAsString(returnValue));
    }
}
