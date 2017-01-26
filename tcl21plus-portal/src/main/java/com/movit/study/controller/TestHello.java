package com.movit.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2016/11/27.
 */
@RestController()
public class TestHello {

    @RequestMapping("/helloTest")
    public String test(){

        return "<h1>hello world!!!</h1>";
    }
}
