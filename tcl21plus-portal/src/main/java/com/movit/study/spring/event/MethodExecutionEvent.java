package com.movit.study.spring.event;

import java.util.EventObject;

/**
 * 给出自定义事件类型（ define your own event object）
 */
public class MethodExecutionEvent extends EventObject {
    private String methodName;

    public MethodExecutionEvent(Object source) {
        super(source);
    }

    public MethodExecutionEvent(Object source, String methodName) {
        super(source);
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
