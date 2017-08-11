package com.movit.study.spring.annotation_bean;

import com.movit.study.spring.bean_post_processor.PostProcessorPersonBean;
import com.movit.study.spring.bean_post_processor.PostProcessorUserBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassPathXmlApplicationContextTest {

    public static void main(String []args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/study/spring/annotation_bean.xml");

        AnnotationBeanUser annotationBeanUser = (AnnotationBeanUser) context.getBean("annotationBeanUser");
        System.out.println(annotationBeanUser);

    }
}
