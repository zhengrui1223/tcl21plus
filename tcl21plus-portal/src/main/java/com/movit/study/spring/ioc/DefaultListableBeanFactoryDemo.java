package com.movit.study.spring.ioc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movit.study.model.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

/**
 * Created by Administrator on 2017/4/1.
 */
public class DefaultListableBeanFactoryDemo {
    public static void main(String []args) throws JsonProcessingException {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();

        //编码方式setter方式注入
        //BeanFactory container = bindViaCodeWay1(beanRegistry);

        //编码方式constructor方式注入
        //BeanFactory container = bindViaCodeWay2(beanRegistry);

        //读取xml中的bean
        BeanFactory container = bindViaCodeWay3(beanRegistry);

        User user = container.getBean(User.class);
        System.out.println(new ObjectMapper().writeValueAsString(user));

    }

    /**
     * 读取xml中的bean
     * @param beanRegistry
     * @return
     */
    private static BeanFactory bindViaCodeWay3(BeanDefinitionRegistry beanRegistry) {
        ClassPathResource classPathResource = new ClassPathResource("/study/spring/beans_demo1.xml");
        FileSystemResource fileSystemResource = new FileSystemResource("F:\\workspaces\\idea_workspace\\tcl21plus\\tcl21plus-portal\\src\\main\\resources\\study\\spring\\beans_demo1.xml");

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanRegistry);

        //reader.loadBeanDefinitions(classPathResource);
        //reader.loadBeanDefinitions(fileSystemResource);
        reader.loadBeanDefinitions("/study/spring/beans_demo1.xml");

        return (BeanFactory) beanRegistry;
        //return new XmlBeanFactory(classPathResource);
    }

    /**
     * setter方式注入
     * @param beanRegistry
     * @return
     */
    private static BeanFactory bindViaCodeWay1(BeanDefinitionRegistry beanRegistry) {

        RootBeanDefinition userBean = new RootBeanDefinition(User.class);

        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id", "1111");
        propertyValues.add("name", "test");
        propertyValues.add("passWord", "123456");
        userBean.setPropertyValues(propertyValues);

        beanRegistry.registerBeanDefinition("user", userBean);

        return (BeanFactory) beanRegistry;
    }

    /**
     * constructor方式注入
     * @param beanRegistry
     * @return
     */
    private static BeanFactory bindViaCodeWay2(BeanDefinitionRegistry beanRegistry) {

        RootBeanDefinition userBean = new RootBeanDefinition(User.class);

        ConstructorArgumentValues constructorArgumentValues = new ConstructorArgumentValues();
        constructorArgumentValues.addIndexedArgumentValue(0, "22222");
        constructorArgumentValues.addIndexedArgumentValue(1, "zhang_san");
        constructorArgumentValues.addIndexedArgumentValue(2, "123456");
        userBean.setConstructorArgumentValues(constructorArgumentValues);

        beanRegistry.registerBeanDefinition("user", userBean);

        return (BeanFactory) beanRegistry;
    }
}
