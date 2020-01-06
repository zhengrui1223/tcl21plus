package com.movit.study.spring.enable.server.impl;

public interface Server {

    void start();

    void stop();

    enum Type {
        FTP,
        HTTP
    }

}
