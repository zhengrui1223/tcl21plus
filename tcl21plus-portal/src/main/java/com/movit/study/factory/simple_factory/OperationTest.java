package com.movit.study.factory.simple_factory;

import com.movit.study.factory.operation.Operation;

/**
 * Created by Administrator on 2017/4/9.
 */
public class OperationTest {
    public static void main(String [] args){
        Operation operation = OperationFactory.createOperate('+');
        operation.setNumberA(12D);
        operation.setNumberB(23D);

        System.out.println(operation.getResult());
    }
}
