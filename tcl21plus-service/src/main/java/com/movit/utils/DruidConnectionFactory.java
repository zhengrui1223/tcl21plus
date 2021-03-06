package com.movit.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class DruidConnectionFactory {

    private static DruidDataSource dataSource = new DruidDataSource();

    static {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("becom@123");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");

        dataSource.setInitialSize(5);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(5);
        try {
            dataSource.setFilters("stat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // for mysql  dataSource.setPoolPreparedStatements(false);
        //dataSource.setPoolPreparedStatements(false);
    }

    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection getConnection(String testName) {
        System.out.println(testName);
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        for (int i = 0; i < 15; i++) {
            Connection con = dataSource.getConnection();
            //这里是输出连接的地址
            System.out.println(con.toString());
            con.close();
        }
    }
}
