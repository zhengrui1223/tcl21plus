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
        GetUserBean getUserBean = beanFactory.getBean(GetUserBean.class);
        System.out.println(getUserBean);

        //获取的是user的bean
        System.out.println(beanFactory.getBean("userFactoryBean"));


    }
}
