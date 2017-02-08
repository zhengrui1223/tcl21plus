package com.movit.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by admin on 2016/12/30.
 */
@Controller()
public class MVCController {

    @RequestMapping("/MVCController")
    public String test1(){
        return "/index";
    }
}
