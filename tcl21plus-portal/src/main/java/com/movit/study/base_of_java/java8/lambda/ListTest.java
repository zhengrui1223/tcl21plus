package com.movit.study.base_of_java.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/************************************************************
 * @Description: TODO
 * @Author: jerry.zheng
 * @Date 2018-04-15 16:27
 ************************************************************/

public class ListTest {
    public static void main(String[] args) {
        // Java 8之前：
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            //System.out.println(feature);
        }

        List<String> features2 = new ArrayList<>();

        //遍历方式1，有局部变量型
        //features.forEach(item -> System.out.println(item));

        //遍历方式2，无局部变量型
        //features.forEach(System.out::println);

        //遍历集合并复制
        //features.forEach(item -> features2.add(item));

        //复合操作，遍历打印并复制
        /*features.forEach(item -> {
            System.out.println(item);
            features2.add(item + "2");

            features2.forEach(item2 -> System.out.println(item2));
        });*/

        //过滤以L开头的字符串
        //filter(features, (str) -> str.startsWith("L"));
    }

    public static void filter(List<String> names, Predicate condition) {
        for(String name: names)  {
            if(condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }
}
