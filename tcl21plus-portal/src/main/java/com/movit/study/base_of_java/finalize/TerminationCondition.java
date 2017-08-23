package com.movit.study.base_of_java.finalize;

/**
 * Created by admin on 2017/1/15.
 */
class Book {
    boolean checkedOut = false;
    Book(boolean checkOut){
        checkedOut = checkOut;
    }

    void checkIn(){
        checkedOut = false;
    }

    @Override
    protected void finalize() throws Throwable {
        if(checkedOut){
            System.out.println("Error: check out");
        }
    }
}

public class TerminationCondition{

    public static void main(String [] args){
        Book novel = new Book(true);
        novel.checkIn();

        new Book(true);
        System.gc();
    }
}
