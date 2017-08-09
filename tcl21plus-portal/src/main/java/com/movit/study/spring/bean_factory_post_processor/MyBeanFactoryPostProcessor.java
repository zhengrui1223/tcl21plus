package com.movit.study.spring.bean_factory_post_processor;

import com.movit.study.spring.bean_post_processor.MyBeanPostProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * BeanFactoryPostProcessor可以修改BEAN的配置信息
 * BeanFactoryPostProcessor的回调比BeanPostProcessor要早
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        System.out.println("-------------------------BeanFactoryPostProcessor start");


        //beanFactory.addBeanPostProcessor(new MyBeanPostProcessor());

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("postProcessorUserBean");
        MutablePropertyValues pv = beanDefinition.getPropertyValues();
        if (pv.contains("username")) {
            pv.addPropertyValue("username", "jerry");
        }

        System.out.println("-------------------------BeanFactoryPostProcessor end");
    }
}
