package com.movit.study.factory.simple_factory;

import com.movit.study.factory.operation.Operation;
import com.movit.study.factory.operation.OperationAdd;

/**
 * Created by Administrator on 2017/4/9.
 */
public class OperationFactory {

    public static Operation createOperate(char operate) {
        Operation operation = null;

        switch (operate) {
            case '+':
                operation = new OperationAdd();
                break;
            case '-':
                operation = new OperationAdd();
                break;
            case '*':
                operation = new OperationAdd();
                break;
            case '/':
                operation = new OperationAdd();
                break;
        }

        return operation;
    }

}
