package com.movit.study.spring.ioc.no_static_method_factory;

import com.movit.utils.DruidConnectionFactory;

import java.sql.Connection;

/**
 * Created by Administrator on 2017/4/11.
 */
public class DruidConnectionFactoryNew {
    public Connection getConnection(){
        return DruidConnectionFactory.getConnection();
    }
}
