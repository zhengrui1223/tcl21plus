package com.movit.study.collections;

/**
 * Created by Administrator on 2017/2/17.
 */
public class Orange implements Fruit {
    private String name;

    public Orange(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
