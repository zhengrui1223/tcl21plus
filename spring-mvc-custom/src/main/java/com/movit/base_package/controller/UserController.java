package com.movit.base_package.controller;

import com.movit.annotation.Autowired;
import com.movit.annotation.Controller;
import com.movit.annotation.RequestMapping;
import com.movit.annotation.ResponseBody;
import com.movit.base_package.model.User;
import com.movit.base_package.service.UserService;
import com.movit.util.Param;
import com.movit.util.View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(path = "/user/getAll", method = "GET")
    public List<User> getUserList() {
        List<User> users = userService.getUserList();
        return users;
    }

    @RequestMapping(path = "/user/home", method = "GET")
    public View home(Param param) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("test", param.getParamMap().get("test"));
        return new View("home", model);
    }

    @RequestMapping(path = "/user/redirect", method = "GET")
    public View redirect() {
        return new View("redirect:/user/getAll");
    }

}
