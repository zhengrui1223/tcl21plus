package com.movit.utils;

import com.mchange.v2.c3p0.DataSources;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class C3P0ConnectionFactory2 {
    private static Log log = LogFactory.getLog(C3P0ConnectionFactory.class);
    private static DataSource dataSource;
    private static final String C3P0_PREFIX = "c3p0.";
    private static final String JDBC_URL = "db.url";
    private static final String JDBC_USERNAME = "db.username";
    private static final String JDBC_PASSWORD = "db.password";
    private static final String DRIVER_CLASS = "db.driver";

    static {
        initDBSource();
    }

    public static synchronized Connection getConnection() {

        try {
            final Connection connection = dataSource.getConnection();
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

            //连接池配置属性
            Properties c3p0PooledProp = new Properties();
            for (Object key : properties.keySet()) {
                String skey = (String) key;
                if (skey.startsWith(C3P0_PREFIX)) {
                    c3p0PooledProp.put(skey, properties.getProperty(skey));
                }
            }

            //获取数据库连接配置
            String jdbcUrl = properties.getProperty(JDBC_URL);
            String userName = properties.getProperty(JDBC_USERNAME);
            String password = properties.getProperty(JDBC_PASSWORD);

            //加载驱动
            Class.forName(properties.getProperty(DRIVER_CLASS));

            //建立连接池
            DataSource unPooled = DataSources.unpooledDataSource(jdbcUrl, userName, password);
            dataSource = DataSources.pooledDataSource(unPooled, c3p0PooledProp);
        } catch (Exception e) {
            log.error(String.format("[%s] DB Connection Failed! Exception is: {%s}", DateTime.now().toString(DateTimeFormat.forPattern("yyyy:MM:dd:HH:mm:ss:SSS")), e.toString()));
        }
    }

    public static void main(String[] args) throws SQLException {
        for (int i = 0; i < 15; i++) {
            Connection con = dataSource.getConnection();
            //这里是输出连接的地址
            System.out.println(con.toString());
            //con.close();
        }
    }
}
