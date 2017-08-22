package com.movit.study.spring.transaction.demo_xml;

import com.movit.study.model.Person;
import com.movit.study.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class UserServiceImpl implements IUserService {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User getUserById(Integer id) {
        final String sql = "select id, name, passWord from user where 1=1 and id =" + id;
        List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setPassWord(resultSet.getString(3));
                return user;
            }
        });

        if (userList != null && !userList.isEmpty()) {
            return userList.get(0);
        }

        return null;
    }

    public boolean delete(Integer id) {
        final String sql = "delete from user where id = ?";
        int update = jdbcTemplate.update(sql, new Object[]{id}, new int[]{Types.INTEGER});

        if (update > 0) {
            return true;
        }

        return false;
    }

    public User insert(final User user) {
        String sql = " insert into user (name, passWord) values(?,?)";
        int update = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getPassWord());
            }
        });

        if (update > 0) {
            String insertPerson = " insert into person (age, name) values(?,?)";
            final Person person = user.getPerson();
            update = jdbcTemplate.update(insertPerson, new PreparedStatementSetter() {
                public void setValues(PreparedStatement preparedStatement) throws SQLException {
                    preparedStatement.setInt(1, person.getAge());
                    preparedStatement.setString(2, person.getName());
                }
            });
            return update > 0 ? user : null;
        }

        return null;
    }

    public User update(final User user) {
        String sql = " update user set name=?, passWord = ? where id = ?";
        int update = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getPassWord());
                preparedStatement.setInt(3, user.getId());
            }
        });

        if (update > 0) {
            return user;
        }

        return null;
    }
}
