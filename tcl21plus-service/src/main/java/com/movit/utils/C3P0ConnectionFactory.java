package com.movit.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class C3P0ConnectionFactory {
    private static Log log = LogFactory.getLog(C3P0ConnectionFactory.class);
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    private static final String DRIVER_CLASS = "db.driver";
    private static final String JDBC_URL = "db.url";
    private static final String JDBC_USERNAME = "db.username";
    private static final String JDBC_PASSWORD = "db.password";
    private static final String C3P0_PREFIX = "c3p0.";
    private static final String MIN_POOL_SIZE = "minPoolSize";
    private static final String MAX_POOL_SIZE = "maxPoolSize";
    private static final String MAX_IDLE_TIME = "maxIdleTime";
    private static final String ACQUIRE_INCREMENT = "acquireIncrement";

    static {
        initDBSource();
    }

    public static synchronized Connection getConnection() {
        try {
            final Connection connection = dataSource.getConnection();
            //指定在读取数据时控制共享锁以避免脏读
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            return connection;
        } catch (SQLException e) {
            log.error(String.format("[%s] DB Connection Failed! Exception is: {%s}", DateTime.now().toString(DateTimeFormat.forPattern("yyyy:MM:dd:HH:mm:ss:SSS")), e.toString()));
        }
        return null;
    }

    public static final void initDBSource() {
        try {

            //从config-common.properties获取jdbc及c3p0配置
            InputStream inputStream = C3P0ConnectionFactory.class.getClassLoader().getResourceAsStream("config-common.properties");
            Properties properties = new Properties();
            properties.load(inputStream);

            //数据库连接配置
            dataSource.setJdbcUrl(properties.getProperty(JDBC_URL));
            dataSource.setUser(properties.getProperty(JDBC_USERNAME));
            dataSource.setPassword(properties.getProperty(JDBC_PASSWORD));

            //c3p0配置
            dataSource.setMinPoolSize(Integer.parseInt(properties.getProperty(C3P0_PREFIX + MIN_POOL_SIZE)));
            dataSource.setMaxPoolSize(Integer.parseInt(properties.getProperty(C3P0_PREFIX + MAX_POOL_SIZE)));
            dataSource.setMaxIdleTime(Integer.parseInt(properties.getProperty(C3P0_PREFIX + MAX_IDLE_TIME)));
            dataSource.setAcquireIncrement(Integer.parseInt(properties.getProperty(C3P0_PREFIX + ACQUIRE_INCREMENT)));

            //加载驱动
            dataSource.setDriverClass(properties.getProperty(DRIVER_CLASS));
        } catch (Exception e) {
            log.error(String.format("[%s] DB Connection Failed! Exception is: {%s}", DateTime.now().toString(DateTimeFormat.forPattern("yyyy:MM:dd:HH:mm:ss:SSS")), e.toString()));
        }
    }

    public static void main(String[] args) throws SQLException {
        for (int i = 0; i < 15; i++) {
            Connection con = dataSource.getConnection();
            //这里是输出连接的地址。
            System.out.println(con.toString());
            //con.close();
        }
    }
}
