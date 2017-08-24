package com.movit.study.spring.transaction.demo_my;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionStatus;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MyTransactionManager implements PlatformTransactionManager{

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public TransactionStatus getTransaction(TransactionDefinition transactionDefinition) throws TransactionException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            MyTransactionResourceManager.bindResource(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new DefaultTransactionStatus(connection, true, true, false, true, null);
    }

    public void commit(TransactionStatus transactionStatus) throws TransactionException {
        DefaultTransactionStatus defStatus = (DefaultTransactionStatus)transactionStatus;
        Connection connection = null;
        if (defStatus.isLocalRollbackOnly()) {
            rollback(transactionStatus);
        }else {
            System.out.println("-------------------commit");
            connection = (Connection)MyTransactionResourceManager.unbindResource();
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void rollback(TransactionStatus transactionStatus) throws TransactionException {
        System.out.println("-------------------rollback");
        Connection connection = (Connection)MyTransactionResourceManager.unbindResource();
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
