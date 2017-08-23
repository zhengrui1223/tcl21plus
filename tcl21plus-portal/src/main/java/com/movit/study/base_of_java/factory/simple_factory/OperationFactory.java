package com.movit.study.base_of_java.factory.simple_factory;

import com.movit.study.base_of_java.factory.operation.Operation;
import com.movit.study.base_of_java.factory.operation.OperationAdd;

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
