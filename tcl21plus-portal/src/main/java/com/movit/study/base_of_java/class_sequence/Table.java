package com.movit.study.base_of_java.class_sequence;

public class Table {

    static Bowl bow1 = new Bowl(1);

    Table() {
        System.out.println("Table()");
        bow2.f1(1);
    }

    void f2(int marker){
        System.out.println("f2(" + marker + ")");
    }

    static Bowl bow2 = new Bowl(2);
}
