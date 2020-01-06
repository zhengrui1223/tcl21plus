package com.movit.study.spring.enable.server.impl;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-12-26 14:07
 ************************************************************/

public class ServerImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(EnableServer.class.getTypeName());
        Server.Type type = (Server.Type) attributes.get("type");

        String[] arr;
        switch (type) {
            case FTP:
                arr = new String[]{FtpServer.class.getName()};
                break;
            case HTTP:
                arr = new String[]{HttpServer.class.getName()};
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }

        return arr;
    }

}
