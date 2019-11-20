package com.movit.study.socket.netty.serializable.netty;

import java.io.Serializable;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-11-19 21:25
 ************************************************************/

public class SubsribeResp implements Serializable {

    private Integer id;

    private String respCode;

    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "SubsribeResp{" +
                "id=" + id +
                ", respCode='" + respCode + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
