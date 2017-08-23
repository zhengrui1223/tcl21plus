package com.movit.study.base_of_java.callback;

/**
 * Created by Administrator on 2017/2/7.
 */
public class XiaoMing {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void caculate(int a, int b, int result){
        System.out.println(this.name + a + "+" + b + " 的计算结果为" + result);
    }
}
