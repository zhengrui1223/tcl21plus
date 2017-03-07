package com.movit.study.bean_utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2017/3/7.
 */
public class Student1 {
    @JsonProperty(value = "NAME")
    private String NAME;

    @JsonProperty(value = "PASSWORD")
    private String PASSWORD;

    @JsonIgnore()
    public String getNAME() {
        return NAME;
    }

    @JsonIgnore()
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    @JsonIgnore()
    public String getPASSWORD() {
        return PASSWORD;
    }

    @JsonIgnore()
    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}
