package com.movit.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movit.base_package.controller.UserController;
import com.movit.base_package.model.User;

import java.util.List;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-19 18:44
 ************************************************************/

public class ControllerTest {

    public static void main(String[] args) throws JsonProcessingException {

        Class<?>[] classes = new Class<?>[]{ClassHelper.class, BeanIocHelper.class, BeanDIHelper.class, };
        for (Class<?> clazz: classes) {
            ClassUtil.loadClass(clazz.getName(), true);
        }

        UserController userController = BeanIocHelper.getBean(UserController.class);
        List<User> userList = userController.getUserList();
        System.out.println(new ObjectMapper().writeValueAsString(userList));
    }

}
