package com.movit.study.factory.method_factory.impl;

import com.movit.study.factory.method_factory.IFactory;
import com.movit.study.factory.operation.Operation;
import com.movit.study.factory.operation.OperationSub;

/**
 * Created by Administrator on 2017/4/9.
 */
public class SubFactory implements IFactory {
    public Operation createOperation() {
        return new OperationSub();
    }
}
