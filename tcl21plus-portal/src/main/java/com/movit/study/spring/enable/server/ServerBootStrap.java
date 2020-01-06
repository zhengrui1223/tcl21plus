package com.movit.study.spring.enable.server;

import com.movit.study.spring.enable.server.impl.EnableServer;
import com.movit.study.spring.enable.server.impl.Server;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-12-26 14:08
 ************************************************************/

@EnableServer(type = Server.Type.FTP)
@Configuration
public class ServerBootStrap {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ServerBootStrap.class);
        context.refresh();

        Server server = context.getBean(Server.class);
        server.start();
        server.stop();

    }
}
