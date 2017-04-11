package com.movit.study.factory.operation;

/**
 * Created by Administrator on 2017/4/9.
 */
public class OperationAdd extends Operation {
    public Double getResult() {
        return getNumberA() + getNumberB();
    }
}
