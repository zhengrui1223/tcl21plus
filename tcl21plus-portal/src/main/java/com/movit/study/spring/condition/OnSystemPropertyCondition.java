package com.movit.study.spring.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.Objects;

/************************************************************
 * @Description: TODO
 * @Author: zhengrui
 * @Date 2020-01-02 14:39
 ************************************************************/

public class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        MultiValueMap<String, Object> attributes = metadata.getAllAnnotationAttributes(ConditionOnSystemProperty.class.getName());
        String propertyName = (String) attributes.getFirst("name");
        String propertyValue = (String) attributes.getFirst("value");

        String systemPropertyValue = System.getProperty(propertyName);

        if (Objects.equals(systemPropertyValue, propertyValue)) {
            System.out.printf("系统属性 [%s] 找到匹配值: [%s]", propertyName, propertyValue);
            return true;
        }
        return false;
    }
}
