package com.movit.util;


import com.movit.annotation.Autowired;
import org.apache.commons.lang.ArrayUtils;

import java.lang.reflect.Field;
import java.util.Map;

/************************************************************
 * @author jerry.zheng
 * @Description DI 依赖注入
 * @date 2017-09-19 18:04
 ************************************************************/

public class BeanDIHelper {

    static {
        Map<Class<?>, Object> beanMap = BeanIocHelper.getBeanMap();
        if (beanMap != null && !beanMap.isEmpty()) {
            for (Map.Entry<Class<?>, Object> entry : beanMap.entrySet()) {
                Class<?> beanClass = entry.getKey();
                Object beanInstance = entry.getValue();
                Field[] fields = beanClass.getClass().getDeclaredFields();

                if (ArrayUtils.isNotEmpty(fields)) {
                    for (Field field : fields) {
                        if (field.isAnnotationPresent(Autowired.class)) {
                            Class<?> fieldType = field.getType();
                            Object bean = BeanIocHelper.getBean(fieldType);
                            if (beanInstance != null) {
                                ReflectionUtil.setField(beanInstance, field, bean);
                            }
                        }
                    }
                }
            }
        }
    }
}
