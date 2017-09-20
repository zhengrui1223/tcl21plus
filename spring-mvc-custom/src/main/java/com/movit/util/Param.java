package com.movit.util;

import java.util.Map;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-20 13:45
 ************************************************************/
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }
}
