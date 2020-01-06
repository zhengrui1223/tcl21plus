package com.movit.study.spring.ioc.annotation_bean;

import org.springframework.context.annotation.Bean;

/************************************************************
 * @Description: TODO
 * @Author: zhengrui
 * @Date 2019-12-28 2:54
 ************************************************************/

public class BeanConfig {
    @Bean(name = "annotationBeanUser")
    public AnnotationBeanUser getInstance() {
        return new AnnotationBeanUser();
    }
}
