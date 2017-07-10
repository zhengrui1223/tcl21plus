package com.movit.study.string;

public class StringTestDemo {
    public static void main(String []args) {
        /**
         * 以 String a="hello world ";形式赋值在java中叫直接量,它是在常量池中而不是象new 一样放在压缩堆中.
         这种形式的字符串,在JVM内部发生字符串拘留,即当声明这样的一个字符串后,JVM会在常量池中先查找有有没有一个值为"hello world "的对象,如果有,就
         会把它赋给当前引用.即原来那个引用和现在这个引用指点向了同一对象,如果没有,则在常量池中新创建一个"hello world ",下一次如果有String
         String a = "hello world !";又会将s1指向"hello world !"这个对象,即以这形式声明的字符串,只要值相等,任何多个引用都指向同一对象.
         */
        String a = "hello world !"; //它是java中唯一不需要new 就可以产生对象的途径.
        String b = "hello world !";
        System.out.println(a.equals(b));
        System.out.println(a == b);

        System.out.println("---------------------------------------------------");
        /**
         * 使用new 关键字,会重新创建对象,而不是从字符串常量池中取
         */
        String c = new String("hello world !");
        String d = new String("hello world !");
        System.out.println(c.equals(d));
        System.out.println(c == d);

        System.out.println("---------------------------------------------------");
        /**
         * String.intern()
         * 当调用 intern 方法时，如果常量池中已经包含一个等于此 String 对象的字符串，
         * 则返回池中的字符串。否则，将此 String 对象添加到池中，并且返回此 String 对象的引用。
         */
        String m = "hello";
        String e = m.intern();
        System.out.println(e == m);
        System.out.println(e.equals(m));

        String n = new String("world");
        String f = n.intern();          //此时常量池中并没有n的字符串,故会在常量池中添加n对象,将引用返回给f
        String h = "world";             //由于n.intern()已经在常量池中放置了n对象,故h会从常量池中取
        System.out.println(f == n);
        System.out.println(f.equals(n));
        System.out.println(h.equals(f));


    }
}
