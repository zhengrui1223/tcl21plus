package com.movit.study.spring.ioc.static_method_factory;

import java.sql.Connection;

/**
 * Created by Administrator on 2017/4/11.
 */
public class DruidConnection {
    private Connection connection;

    public DruidConnection(Connection connection){
        this.connection = connection;
    }

    public void printAddress(){
        System.out.println(this.connection);
    }
}
