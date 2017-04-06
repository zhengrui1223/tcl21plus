package com.movit.study.spring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movit.study.model.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Administrator on 2017/4/1.
 */
public class DefaultListableBeanFactoryDemo {
    public static void main(String []args) throws JsonProcessingException {
        ClassPathResource resource = new ClassPathResource("study/spring/beans_demo1.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);

        User user = factory.getBean(User.class);
        System.out.println(new ObjectMapper().writeValueAsString(user));
    }
}
