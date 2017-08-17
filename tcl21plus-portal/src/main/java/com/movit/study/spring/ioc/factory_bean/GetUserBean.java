package com.movit.study.spring.ioc.factory_bean;

import com.movit.study.model.User;

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
