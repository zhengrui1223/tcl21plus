package com.movit.study.spring.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2020-01-02 14:37
 ************************************************************/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionOnSystemProperty {
    String name();

    String value();
}
