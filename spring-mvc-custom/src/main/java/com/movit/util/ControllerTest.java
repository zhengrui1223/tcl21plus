package com.movit.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movit.base_package.controller.UserController;
import com.movit.base_package.model.User;

import java.util.ArrayList;
import java.util.List;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-19 18:44
 ************************************************************/

public class ControllerTest {

    public static void main(String[] args) {

        List<Thread> list = new ArrayList<Thread>();
        for (int i=0; i<20; i++) {
            ConcurrentTest thread = new ConcurrentTest();
            list.add(thread);
        }

        for (Thread thread : list) {
            thread.start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

    }

}

class ConcurrentTest extends Thread{
    @Override
    public void run() {
        Class<?>[] classes = new Class<?>[]{ClassHelper.class, BeanIocHelper.class, BeanDIHelper.class, };
        for (Class<?> clazz: classes) {
            ClassUtil.loadClass(clazz.getName(), true);
        }

        UserController userController = BeanIocHelper.getBean(UserController.class);
        List<User> userList = userController.getUserList(Thread.currentThread().getName());
        try {
            System.out.println(new ObjectMapper().writeValueAsString(userList));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}