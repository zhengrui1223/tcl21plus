package com.movit.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/************************************************************
 * @author jerry.zheng
 * @Description IOC 控制反转
 * @date 2017-09-19 18:04
 ************************************************************/

public class BeanIocHelper {

    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        Set<Class<?>> classes = ClassHelper.getClasses();
        if (classes != null && classes.size() > 0) {
            for (Class<?> clazz : classes) {
                if (!clazz.isInterface() && !clazz.isAnnotation()) {
                    BEAN_MAP.put(clazz, ReflectionUtil.newInstance(clazz));
                }
            }
        }
    }

    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    public static <T> T getBean(Class<T> clazz) {
        if (BEAN_MAP != null && !BEAN_MAP.isEmpty()) {
            if (!BEAN_MAP.containsKey(clazz)) {
                throw new RuntimeException("can not get bean by class :" + clazz);
            }
        }
        return (T) BEAN_MAP.get(clazz);
    }

}
