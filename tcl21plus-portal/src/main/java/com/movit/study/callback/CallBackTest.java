package com.movit.study.callback;

/**
 * Created by Administrator on 2017/2/7.
 */
public class CallBackTest {
    public static void main(String[] args) {
        XiaoMing xiaoMing = new XiaoMing();
        xiaoMing.setName("xiaoming ");
        CalculateTool.caculate(1, 2, xiaoMing);
    }
}
