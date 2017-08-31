package com.movit.service;

import java.util.List;

public interface IBaseService<T> {
    List<T> findAll();

    T getById(Integer id);

    boolean deleteById(Integer id);

    T insert(T obj);

    T update(T obj);
}
