package com.movit.study.spring.ioc.bean_post_processor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassPathXmlApplicationContextTest {

    public static void main(String []args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/study/spring/bean_post_processor.xml");

        PostProcessorUserBean userBean =(PostProcessorUserBean)context.getBean("postProcessorUserBean");
        System.out.println("-----------userBean username:"+userBean.getUsername());
        System.out.println("-----------userBean password:"+userBean.getPassword());

        PostProcessorPersonBean personBean =(PostProcessorPersonBean)context.getBean("postProcessorPersonBean");
        System.out.println("-----------personBean username:"+personBean.getUsername());
        System.out.println("-----------personBean password:"+personBean.getPassword());

    }
}
