package com.movit.study.controller;

import com.movit.study.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2016/11/27.
 */
@RestController()
public class RestedController {

    @RequestMapping(method = RequestMethod.GET, value = "/RestController", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public User test(){
        User user = new User();
        user.setId(1);
        user.setName("test");
        user.setPassWord("123456");
        return user;
    }
}
