package com.movit.util;

import com.movit.controller.UserController;
import com.movit.model.User;

import java.util.List;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-19 18:44
 ************************************************************/
public class ControllerTest {

    public static void main(String[] args) {

        Class<?>[] classes = new Class<?>[]{BeanIocHelper.class, BeanDIHelper.class, ClassHelper.class};
        for (Class<?> clazz: classes) {
            ClassUtil.loadClass(clazz.getName(), true);
        }

        UserController userController = BeanIocHelper.getBean(UserController.class);
        List<User> userList = userController.getUserList();
        System.out.println(userList);
    }

}
