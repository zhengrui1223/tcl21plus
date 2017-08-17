package com.movit.study.spring.ioc.bean_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor不能修改BEAN的配置信息
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //如果是PostProcessorBean则username信息
        if (bean instanceof PostProcessorUserBean) {
            System.out.println("PostProcessorUserBean Bean initialized");
            PostProcessorUserBean pb = (PostProcessorUserBean) bean;
            System.out.println("username:" + pb.getUsername());
        }

        if (bean instanceof PostProcessorPersonBean) {
            System.out.println("PostProcessorPersonBean Bean initialized");
            PostProcessorPersonBean pb = (PostProcessorPersonBean) bean;
            System.out.println("username:" + pb.getUsername());
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PostProcessorUserBean) {
            System.out.println("PostProcessorUserBean Bean initializing");
            PostProcessorUserBean pb = (PostProcessorUserBean) bean;

            System.out.println("username:" + pb.getUsername());
        }

        if (bean instanceof PostProcessorPersonBean) {
            System.out.println("PostProcessorPersonBean Bean initialized");
            PostProcessorPersonBean pb = (PostProcessorPersonBean) bean;
            System.out.println("username:" + pb.getUsername());
        }
        return bean;
    }
}
