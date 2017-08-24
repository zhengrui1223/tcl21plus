package com.movit.study.spring.transaction.demo_my;

import com.movit.study.model.Person;
import com.movit.study.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.*;
import java.util.List;

public class UserService {

    private TransactionTemplate transactionTemplate;

    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    public void setTransactionTemplate(PlatformTransactionManager transactionManager) {
        transactionTemplate = new TransactionTemplate(transactionManager);

    }

    public User insert(final User user) {
        Connection connection = (Connection) MyTransactionResourceManager.getResource();

        String sql = " insert into user (name, passWord) values(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassWord());
            int execute = preparedStatement.executeUpdate();
            if (execute>0) {
                String insertPerson = " insert into person (age, name) values(?,?)";
                final Person person = user.getPerson();
                preparedStatement = connection.prepareStatement(insertPerson);
                preparedStatement.setInt(1, person.getAge());
                preparedStatement.setString(2, person.getName());
                execute = preparedStatement.executeUpdate();
                if (execute>0) {
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
