package com.movit.study.factory.method_factory.impl;

import com.movit.study.factory.method_factory.IFactory;
import com.movit.study.factory.operation.Operation;
import com.movit.study.factory.operation.OperationDiv;

/**
 * Created by Administrator on 2017/4/9.
 */
public class DivFactory implements IFactory {

    public Operation createOperation() {
        return new OperationDiv();
    }
}
