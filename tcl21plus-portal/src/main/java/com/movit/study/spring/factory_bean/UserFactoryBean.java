package com.movit.study.spring.factory_bean;

import com.movit.study.model.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Administrator on 2017/4/11.
 */
public class UserFactoryBean implements FactoryBean {
    public Object getObject() throws Exception {
        return new User();
    }

    public Class<?> getObjectType() {
        return User.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
