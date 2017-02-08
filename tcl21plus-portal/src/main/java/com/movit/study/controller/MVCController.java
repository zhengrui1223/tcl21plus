package com.movit.study.controller;

import com.movit.study.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 2016/12/30.
 */
@Controller()
public class MVCController {

    @RequestMapping("/MVCController")
    public String test1(){
        return "/index";
    }

    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.GET, produces = "application/json")
    public User findUser(){
        User user = new User();
        user.setId(111);
        user.setName("test");
        user.setPassWord("123456");
        return user;
    }
}
