package com.movit.study.factory.operation;

/**
 * Created by Administrator on 2017/4/9.
 */
public abstract class Operation {
    private Double numberA;
    private Double numberB;

    public Double getNumberA() {
        return numberA;
    }

    public void setNumberA(Double numberA) {
        this.numberA = numberA;
    }

    public Double getNumberB() {
        return numberB;
    }

    public void setNumberB(Double numberB) {
        this.numberB = numberB;
    }

    public abstract Double getResult();
}
