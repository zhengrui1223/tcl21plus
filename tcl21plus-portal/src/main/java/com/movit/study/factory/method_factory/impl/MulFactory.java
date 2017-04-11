package com.movit.study.factory.method_factory.impl;

import com.movit.study.factory.method_factory.IFactory;
import com.movit.study.factory.operation.Operation;
import com.movit.study.factory.operation.OperationMul;

/**
 * Created by Administrator on 2017/4/9.
 */
public class MulFactory implements IFactory {
    public Operation createOperation() {
        return new OperationMul();
    }
}
