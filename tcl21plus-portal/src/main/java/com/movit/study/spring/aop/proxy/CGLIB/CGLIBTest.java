package com.movit.study.spring.aop.proxy.CGLIB;

import org.springframework.cglib.proxy.Enhancer;

/**
 * 利用cglib 动态字节码生成技术, 业务代码无需实现任何接口
 * 其原理是: 对目标对象进行集成扩展,为其生成相应的子类, 而子类可以通过复写来扩展父类的行为,只要将横切逻辑的实现
 * 放到子类中, 然后让系统用扩展后的目标对象的子类,就可以达到与代理模式相同的效果了.
 */
public class CGLIBTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Requestable.class);
        enhancer.setCallback(new RequestCtrlCallback());

        Requestable requestable = (Requestable) enhancer.create();
        requestable.request();
    }

}
