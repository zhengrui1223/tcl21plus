package com.movit.study.base_of_java.collections;

/**
 * Created by Administrator on 2017/2/17.
 */
public class Apple implements Fruit {
    private String name;

    public Apple(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
