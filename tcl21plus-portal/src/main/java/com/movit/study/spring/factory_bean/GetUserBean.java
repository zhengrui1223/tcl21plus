package com.movit.study.spring.factory_bean;

import com.movit.study.model.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * Created by Administrator on 2017/4/11.
 */
public class GetUserBean{
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
