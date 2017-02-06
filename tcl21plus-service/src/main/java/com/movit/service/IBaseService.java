package com.movit.service;

import java.util.List;

/**
 * Created by admin on 2017/2/6.
 */
public interface IBaseService<T> {
    List<T> findAll();

    T getById(Integer id);

    boolean deleteById(Integer id);

    boolean insert(T obj);

    boolean update(T obj);
}
