package com.movit.study.spring.autowire;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/4/13.
 */
public class BeansTest {
    public static void main(String []args){
        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("/study/autowire/autowire.xml");
        Bean2 bean = beanFactory.getBean(Bean2.class);
        System.out.println(bean);
        System.out.println(bean.getBean());
    }
}
