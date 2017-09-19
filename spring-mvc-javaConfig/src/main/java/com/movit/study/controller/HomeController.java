package com.movit.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-18 9:39
 ************************************************************/
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage() {
        return "home";
    }

}
