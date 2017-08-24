package com.movit.study.spring.transaction.demo_annotation;

import com.movit.study.model.User;

public interface IUserService {
    User getUserById(Integer id);
    boolean delete(Integer id);
    User insert(User user);
    User update(User user);
}
