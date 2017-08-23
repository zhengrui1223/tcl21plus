package com.movit.study.base_of_java.factory.method_factory.impl;

import com.movit.study.base_of_java.factory.method_factory.IFactory;
import com.movit.study.base_of_java.factory.operation.Operation;
import com.movit.study.base_of_java.factory.operation.OperationAdd;

/**
 * Created by Administrator on 2017/4/9.
 */
public class AddFactory implements IFactory {
    public Operation createOperation() {
        return new OperationAdd();
    }
}
