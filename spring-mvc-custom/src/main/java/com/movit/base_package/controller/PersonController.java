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
public class PersonController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(path = "/person/getAll", method = "GET")
    public List<User> getUserList(Param param) {
        List<User> users = userService.getUserList(null);
        return users;
    }

    @RequestMapping(path = "/person/home", method = "GET")
    public View home(Param param) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("test", param.getParamMap().get("test"));
        return new View("home", model);
    }

}
