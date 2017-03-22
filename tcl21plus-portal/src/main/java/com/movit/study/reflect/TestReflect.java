package com.movit.study.reflect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

@SuppressWarnings("ALL")
public class TestReflect {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, JsonProcessingException {

        //http://www.cnblogs.com/lzq198754/p/5780331.html
        Class<UserTestVO> userTestVOClass = UserTestVO.class;

        //获取所有构造方法
        Constructor<?>[] constructors = userTestVOClass.getConstructors();

        for (int i = 0; i < constructors.length; i++) {
            Constructor<?> constructor = constructors[i];
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            System.out.print("cons[" + i + "] (");
            for (int j = 0; j < parameterTypes.length; j++) {
                if (j == parameterTypes.length - 1) {
                    System.out.print(parameterTypes[j].getName());
                } else {
                    System.out.print(parameterTypes[j].getName() + ",");
                }
            }
            System.out.println(")");
        }

        System.out.println("############################################");

        //通过构造方法赋值
        UserTestVO userTestVO = (UserTestVO) constructors[1].newInstance("zhangsan", 20);
        System.out.println(new ObjectMapper().writeValueAsString(userTestVO));

        //获取所有成员属性
        Field[] field = userTestVOClass.getDeclaredFields();
        for (int i=0; i<field.length; i++) {
            // 权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field[i].getType();
            System.out.println(priv + " " + type.getName() + " " + field[i].getName() + ";");
        }

        System.out.println("############################################");

        // 取得实现的接口或者父类的属性
        Field[] filed1 = userTestVOClass.getFields();
        for (int j = 0; j < filed1.length; j++) {
            // 权限修饰符
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = filed1[j].getType();
            System.out.println(priv + " " + type.getName() + " " + filed1[j].getName() + ";");
        }
    }
}
