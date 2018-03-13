package com.movit.study.base_of_java.array;

import com.movit.study.base_of_java.bean_utils.Student;

import java.util.Arrays;

/************************************************************
 * @Description:
 * @Author: jerry.zheng
 * @Date Created in 17:24 2018\3\13 0013        
 ************************************************************/

/**
 * 测试System.arraycopy到底是深拷贝还是浅拷贝
 * 通过测试可以得出结论，
 *      基本数据类型的数组，System.arraycopy是深拷贝
 *      引用数据类型的数组，System.arraycopy是浅拷贝，即只是将对象的引用拷贝给了新数组
 */
public class SystemArrayCopyDemo {

    public static void main(String[] args) {
        test1();
        test2();
    }


    /**
     * 基本数据类型
     */
    public static void test1 () {
        int [] src = new int[10];

        for (int i=0; i<10; i++) {
            src[i] = i;
        }

        int [] dest = new int[10];

        System.arraycopy(src, 0, dest, 0, 10);

        src[7] = 10000;

        System.out.println(Arrays.toString(src));
        System.out.println(Arrays.toString(dest));
    }

    /**
     * 引用数据类型
     */
    public static void test2 () {
        Student[] src = new Student[10];

        for (int i=0; i<10; i++) {
            Student student = new Student();
            student.setAge(i);
            src[i] = student;
        }

        Student [] dest = new Student[10];

        System.arraycopy(src, 0, dest, 0, 10);

        Student student = src[7];
        student.setAge(20);

        System.out.println(src[7].getAge());
        System.out.println(dest[7].getAge());
    }

}


