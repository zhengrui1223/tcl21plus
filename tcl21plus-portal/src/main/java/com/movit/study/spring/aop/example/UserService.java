package com.movit.study.spring.aop.example;

import com.movit.study.model.User;

public class UserService {

    public User getUserInfo(String userName, String passWord) {
        User user = new User();
        user.setName(userName);
        user.setPassWord(passWord);
        user.setPerson(null);

        return user;
    }

    public User getUserInfoException() {
        throw new RuntimeException("get user info cause exception");
    }

}
