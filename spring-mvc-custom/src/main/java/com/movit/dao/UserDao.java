package com.movit.dao;

import com.movit.annotation.Repository;
import com.movit.model.User;

import java.util.List;

@Repository
public interface UserDao {

    List<User> getUserList();
}
