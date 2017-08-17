package com.movit.study.spring.ioc.factory_bean;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Administrator on 2017/4/11.
 */
public class UserFactoryBeanTest {
    public static void main(String []args){
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("\\study\\spring\\factory_bean.xml"));

        //UserFactoryBean虽然是prototype的,但以下连续获取三个对象的实例却还是一样的
        //该问题是由于第一个实例注入GetUserBean后,GetUserBean再也没有重新向容器申请新的实例
        //在UserFactoryBeanTest4Prototype中给出
        //解决方案1 通过 <lookup-method name="getUser" bean="userFactoryBean"/>注入依赖
        //解决方案2 通过实现BeanFactoryAware,让GetUserBean拥有BeanFactory引用,
        // 这样每次获取UserFactoryBean时,可以通过BeanFactory的getBean()方法
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
