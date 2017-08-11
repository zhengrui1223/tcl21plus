package com.movit.study.spring.event;


import java.util.EventListener;

/**
 * 实现针对自定义事件类的事件监听器接口（ define custom event listener）
 */
public interface MethodExecutionEventListener extends EventListener {
    /**
     * 处理方法开始执行的时候发布的MethodExecutionEvent事件
     */
    void onMethodBegin(MethodExecutionEvent evt);

    /**
     * 处理方法执行将结束时候发布的MethodExecutionEvent事件
     */
    void onMethodEnd(MethodExecutionEvent evt);
}
