package com.movit.study.enums; /**
 * Created by admin on 2017/1/15.
 */

/**
 (1)  ordinal()方法: 返回枚举值在枚举类种的顺序。这个顺序根据枚举值声明的顺序而定。
     Color.RED.ordinal();  //返回结果：0
     Color.BLUE.ordinal();  //返回结果：1
 (2)  compareTo()方法: Enum实现了java.lang.Comparable接口，因此可以比较象与指定对象的顺序。
     Enum中的compareTo返回的是两个枚举值的顺序之差。当然，前提是两个枚举值必须属于同一个枚举类，
     否则会抛出ClassCastException()异常。(具体可见源代码)
     Color.RED.compareTo(Color.BLUE);  //返回结果 -1
 (3)  values()方法： 静态方法，返回一个包含全部枚举值的数组。
     Color[] colors=Color.values();
     for(Color c:colors){
     System.out.print(c+",");
    }//返回结果：RED,BLUE,BLACK YELLOW,GREEN,
 (4)  toString()方法： 返回枚举常量的名称。
     Color c=Color.RED;
     System.out.println(c);//返回结果: RED
 (5)  valueOf()方法： 这个方法和toString方法是相对应的，返回带指定名称的指定枚举类型的枚举常量。
     Color.valueOf("BLUE");   //返回结果: Color.BLUE


 (6)  equals()方法： 比较两个枚举类对象的引用。
 */
public enum WeekDay {
    Mon("Monday"), Tue("Tuesday"), Wed("Wednesday"), Thu("Thursday"), Fri( "Friday"), Sat("Saturday"), Sun("Sunday");

    private final String day;
    private WeekDay(String day) {
        this.day = day;
    }

    private String getValue(){
        return day;
    }

    public static String getDay(String day) {
        return valueOf(day).getValue();
    }

}
