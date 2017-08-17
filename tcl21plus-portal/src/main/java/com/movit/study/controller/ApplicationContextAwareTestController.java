package com.movit.study.controller;

import com.movit.study.spring.ioc.applicationContextAware.ApplicationContextAwareTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by MOVITECH-5-e450 on 2017/8/8.
 */

@RequestMapping("/applicationContextAwareTest")
@Controller
public class ApplicationContextAwareTestController {

    @Autowired
    private ApplicationContextAwareTest applicationContextAwareTest;

    @RequestMapping(method = RequestMethod.GET)
    public void test(HttpServletResponse response) {
        Resource resource = applicationContextAwareTest.getResourceByPath("spring/spring-dao.xml");
        try {
            response.getWriter().write(resource.getFile().getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
