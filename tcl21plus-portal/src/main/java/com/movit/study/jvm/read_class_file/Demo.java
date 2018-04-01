package com.movit.study.jvm.read_class_file;

/************************************************************
 * @Description: TODO
 * @Author: jerry.zheng
 * @Date 2018-04-01 0:20
 ************************************************************/

public class Demo {
    public static void main(String[] args) {

    }

    /**

     先javac编译类
     然后命令行输入
     javap -c >cp.txt

     以下即为生成的反编译字节码文件

     #################################################################################
     Compiled from "Demo.java"
     public class Demo {
     public Demo();
     Code:
     0: aload_0
     1: invokespecial #1                  // Method java/lang/Object."<init>":()V
     4: return

     public static void main(java.lang.String[]);
     Code:
     0: return

     public void methodOne(int);
     Code:
     0: iconst_0        //将int类型常量0压入栈
     1: istore_2        //将int类型值存入局部变量2
     2: iload_1         //从局部变量1中装载int类型值
     3: iload_2         //从局部变量2中装载int类型值
     4: iadd            //执行int类型的加法
     5: istore_3        //将int类型值存入局部变量3
     6: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;   //从类中获取静态字段
     9: iload_3         //从局部变量3中装载int类型值
     10: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V           //调度对象的实例方法
     13: return
     }
     #################################################################################



     */
    public void methodOne(int i) {
        int j = 0;
        int sum = i+j;
        System.out.println(sum);
    }

}
