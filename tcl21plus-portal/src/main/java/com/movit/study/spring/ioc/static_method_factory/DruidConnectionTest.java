package com.movit.study.spring.ioc.static_method_factory;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Administrator on 2017/4/11.
 */
public class DruidConnectionTest {
    public static void main(String []args){
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("\\study\\spring\\static_method_factory.xml"));
        DruidConnection druidConnection = beanFactory.getBean(DruidConnection.class);
        druidConnection.printAddress();
    }
}
