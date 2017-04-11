package com.movit.study.spring.factory_bean;

import com.movit.study.model.User;
import com.movit.study.spring.no_static_method_factory.DruidConnectionNew;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * Created by Administrator on 2017/4/11.
 */
public class UserFactoryBeanTest {
    public static void main(String []args){
        XmlBeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("E:\\git_down\\tcl21plus\\tcl21plus-portal\\src\\main\\resources\\study\\spring\\factory_bean.xml"));

        //UserFactoryBean虽然是prototype的,但以下连续获取三个对象的实例却还是一样的
        //该问题是由于第一个实例注入GetUserBean后,GetUserBean再也没有重新向容器申请新的实例
        //在UserFactoryBeanTest4Prototype中给出解决方案
        for (int i=0; i<3; i++) {
            GetUserBean getUserBean = beanFactory.getBean(GetUserBean.class);
            System.out.println(getUserBean.getUser());
        }

        //获取的是user的bean,而不是UserFactoryBean的bean
        System.out.println(beanFactory.getBean("userFactoryBean"));

        //加 "&" 获取的是UserFactoryBean的bean
        System.out.println(beanFactory.getBean("&userFactoryBean"));

    }
}
