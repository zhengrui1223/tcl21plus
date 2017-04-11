package com.movit.study.factory.method_factory;

import com.movit.study.factory.method_factory.impl.AddFactory;
import com.movit.study.factory.operation.Operation;

/**
 * Created by Administrator on 2017/4/9.
 */
public class OperationTest {
    public static void main(String []args){
        IFactory factory = new AddFactory();
        Operation operation = factory.createOperation();
        operation.setNumberA(123D);
        operation.setNumberB(234D);

        System.out.println(operation.getResult());
    }
}
