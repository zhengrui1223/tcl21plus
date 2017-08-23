package com.movit.study.base_of_java.class_sequence;

public class Cupboard {

    Bowl bow2 = new Bowl(3);

    static Bowl bow4 = new Bowl(4);

    Cupboard() {
        System.out.println("Cupboard()");
        bow4.f1(2);
    }

    void f3(int marker){
        System.out.println("f3(" + marker + ")");
    }

    static Bowl bow5 = new Bowl(5);
}
