package com.movit.study.spring.profile.calculate;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/************************************************************
 * @Description: TODO
 * @Author: zhengrui
 * @Date 2020-01-02 13:44
 ************************************************************/

@Service
@Profile("Java7")
public class IterationCalculatingService implements CalculatingService {
    @Override
    public Integer sum(Integer... values) {
        int sum = 0;
        for (Integer value : values) {
            sum += value;
        }
        System.out.println("Java 7 累加结果: " + sum);
        return sum;
    }
}
