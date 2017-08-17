package com.movit.study.spring.ioc.factory_bean;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Administrator on 2017/4/11.
 */
public class UserFactoryBeanTest4Prototype {
    public static void main(String []args){
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("\\study\\spring\\factory_bean4_prototype.xml"));

        //xml中使用<lookup-method name="" bean=""/>注入,解决UserFactoryBeanTest中的重复bean注入问题
        for (int i=0; i<3; i++) {
            GetUserBean getUserBean = beanFactory.getBean(GetUserBean.class);
            System.out.println(getUserBean.getUser());
        }
    }
}
