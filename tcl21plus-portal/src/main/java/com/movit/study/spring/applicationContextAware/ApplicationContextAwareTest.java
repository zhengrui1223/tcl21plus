package com.movit.study.spring.applicationContextAware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * 容器启动的时候，就会自动将当前ApplicationContext容器本身
    注入到ApplicationContextAwareTest中，因为ApplicationContext类型容器可以自动识别Aware接口
    同样的ResourceLoaderAware也是如此
    此处被ApplicationContextAwareTestController调用
 */
@Component
public class ApplicationContextAwareTest implements ApplicationContextAware {
    private ResourceLoader resourceLoader;

    public ApplicationContextAwareTest() {
    }

    public Resource getResourceByPath(String path) {
        return getResourceLoader().getResource(path);
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.resourceLoader = applicationContext;
    }
}
