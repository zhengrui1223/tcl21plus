package com.movit.study.spring.no_static_method_factory;

import com.movit.study.spring.static_method_factory.DruidConnection;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

/**
 * Created by Administrator on 2017/4/11.
 */
public class DruidConnectionTest {
    public static void main(String []args){
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("\\study\\spring\\static_method_factory.xml"));
        DruidConnectionNew druidConnectionNew = beanFactory.getBean(DruidConnectionNew.class);
        druidConnectionNew.printAddress();
    }
}
