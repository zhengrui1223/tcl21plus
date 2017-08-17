package com.movit.study.spring.ioc.bean_factory_aware;

import com.movit.study.model.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * Created by Administrator on 2017/4/11.
 */
public class UserBeanFactoryAware implements BeanFactoryAware {
    private BeanFactory beanFactory;

    public User getUser(){
        return beanFactory.getBean(User.class);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
