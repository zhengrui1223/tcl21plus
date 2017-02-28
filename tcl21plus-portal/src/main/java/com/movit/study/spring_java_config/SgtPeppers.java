package com.movit.study.spring_java_config;

import org.springframework.stereotype.Component;

/**
 * Created by admin on 2017/2/28.
 */
@Component
public class SgtPeppers implements CompactDisc {
    public void play() {
        System.out.println("test for spring java config");
    }

}
