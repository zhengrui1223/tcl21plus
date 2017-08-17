package com.movit.study.spring.ioc.bean_factory_aware;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Administrator on 2017/4/11.
 */
public class UserBeanFactoryAwareTest {
    public static void main(String[]args){
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("/study/spring/bean_factory_aware.xml"));
        UserBeanFactoryAware userBeanFactoryAware = beanFactory.getBean(UserBeanFactoryAware.class);
        userBeanFactoryAware.setBeanFactory(beanFactory);

        for (int i=0; i<3; i++) {
            System.out.println(userBeanFactoryAware.getUser());
        }
    }
}
