package com.movit.study.spring.profile.calculate;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/************************************************************
 * @Description: TODO
 * @Author: zhengrui
 * @Date 2020-01-02 13:44
 ************************************************************/

@Service
@Profile("Java8")
public class LambdaCalculatingService implements CalculatingService {
    @Override
    public Integer sum(Integer... values) {
        Integer sum = Stream.of(values).reduce(0, Integer::sum);
        System.out.println("Java 8 累加结果: " + sum);
        return sum;
    }
}
