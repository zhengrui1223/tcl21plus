package com.movit.controller;

import com.movit.study.base_of_java.singleton.Singleton1;
import com.movit.study.base_of_java.singleton.Singleton2;
import com.movit.study.base_of_java.singleton.Singleton3;
import com.movit.study.base_of_java.singleton.Singleton4;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2016/11/27.
 */
@RestController
@RequestMapping("/singleton")
public class SingletonTestController {

    @RequestMapping(method = RequestMethod.GET, value = "singleton1")
    public Object testSingleton1(){
        Singleton1 instance = Singleton1.getInstance();
        return instance.toString();
    }

    @RequestMapping(method = RequestMethod.GET, value = "singleton2")
    public Object testSingleton2(){
        Singleton2 instance = Singleton2.getInstance();
        return instance.toString();
    }

    @RequestMapping(method = RequestMethod.GET, value = "singleton3")
    public Object testSingleton3(){
        Singleton3 instance = Singleton3.getInstance();
        return instance.toString();
    }

    @RequestMapping(method = RequestMethod.GET, value = "singleton4")
    public Object testSingleton4(){
        Singleton4 instance = Singleton4.getInstance();
        return instance.toString();
    }
}
