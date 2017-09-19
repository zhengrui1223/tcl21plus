package com.movit.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-19 17:56
 ************************************************************/

public class ReflectionUtil {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 创建实例
     */
    public static Object newInstance(Class<?> clazz) {
        Object instance;
        try {
            instance = clazz.newInstance();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     * 调用方法
     */
    public static Object invokeMethod(Object obj, Method method, Object... args) {
        Object result;
        try {
            method.setAccessible(true);
            result = method.invoke(obj, args);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 设置成员变量的值
     */
    public static void setField(Object obj, Field field, Object value) {
        field.setAccessible(true);
        try {
            field.set(obj, value);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
