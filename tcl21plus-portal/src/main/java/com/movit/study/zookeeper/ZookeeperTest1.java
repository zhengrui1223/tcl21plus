package com.movit.study.zookeeper;


import java.util.List;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-12-12 15:46
 ************************************************************/

public class ZookeeperTest1 {

    public static void main(String[] args) throws Exception {

        BaseZookeeper zookeeper = new BaseZookeeper();
        zookeeper.connectZookeeper("47.98.147.110:2181");

        List<String> children = zookeeper.getChildren("/");
        System.out.println(children);

    }

}