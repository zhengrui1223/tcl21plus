package com.movit.study.spring.aop.example_code;


import org.springframework.aop.ThrowsAdvice;

public class SpringAopExampleThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(RuntimeException e) {
        System.out.println("throws run time exception " + e.getMessage());
    }

}
