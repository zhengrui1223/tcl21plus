package com.movit.study.base_of_java.factory.operation;

/**
 * Created by Administrator on 2017/4/9.
 */
public class OperationDiv extends Operation {
    public Double getResult() {
        return getNumberA() / getNumberB();
    }
}
