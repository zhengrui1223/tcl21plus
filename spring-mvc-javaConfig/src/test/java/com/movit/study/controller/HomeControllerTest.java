package com.movit.study.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-18 11:01
 ************************************************************/
public class HomeControllerTest {

    @Test
    public void testIndexPage() throws Exception {
        HomeController indexController = new HomeController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("home"));
    }

}
