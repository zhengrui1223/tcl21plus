package com.movit.study.spring.ioc.no_static_method_factory;

import java.sql.Connection;

/**
 * Created by Administrator on 2017/4/11.
 */
public class DruidConnectionNew {
    private Connection connection;

    public DruidConnectionNew(Connection connection){
        this.connection = connection;
    }

    public void printAddress(){
        System.out.println(this.connection);
    }
}
