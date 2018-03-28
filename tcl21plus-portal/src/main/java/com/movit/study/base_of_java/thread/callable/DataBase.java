package com.movit.study.base_of_java.thread.callable;

import java.util.*;

/************************************************************
 * @Description: TODO
 * @Author: jerry.zheng
 * @Date Created in 15:50 2018\3\28 0028        
 ************************************************************/

public class DataBase {
    private static final HashMap<String, String> DATA = new HashMap<String, String>();
    private static final Integer TOTAL_COUNTS = 10000;
    private static final String KEY_PREFIX = "key_";

    static {
        for (int i = 0; i < TOTAL_COUNTS; i++) {
            DATA.put(KEY_PREFIX + i, String.valueOf(i));
        }
    }

    public static List<String> getData(Integer pageSize, Integer pageNum) {

        if (pageSize == null || pageSize == 0) {
            return null;
        }

        int a = TOTAL_COUNTS / pageSize;
        if (TOTAL_COUNTS % pageSize != 0) {
            a++;
        }

        if (a < pageNum) {
            return null;
        }

        List<String> values = new ArrayList<String>();
        for (int i = pageSize*(pageNum-1); i < pageSize*pageNum; i++) {
            values.add(DATA.get(KEY_PREFIX + i));
        }

        return values;
    }
}
