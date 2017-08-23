package com.movit.study.base_of_java.callback;

/**
 * Created by Administrator on 2017/2/7.
 */
public class CalculateTool {
    public static void caculate(int a, int b, XiaoMing xiaoMing) {
        int sum = a + b;
        xiaoMing.caculate(a, b, sum);
    }
}
