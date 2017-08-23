package com.movit.study.base_of_java.GC;


/**
    要真正宣告一个对象死亡，至少要经历两次标记过程：
        1,   如果对象在进行可达性分析后发现没有与GC Roots相连接的引用链，那它将会被第一次标记并且进行一次筛选，
             筛选的条件是此对象是否有必要执行finalize（）方法。 当对象没有覆盖finalize（）方法，或
             者finalize（）方法已经被虚拟机调用过，虚拟机将这两种情况都视为“没有必要执行”。

        2,   如果这个对象被判定为有必要执行finalize（）方法，那么这个对象将会放置在一个叫做
             F-Queue的队列之中，并在稍后由一个由虚拟机自动建立的、 低优先级的Finalizer线程去执行
             它。 这里所谓的“执行”是指虚拟机会触发这个方法，但并不承诺会等待它运行结束，这样做
             的原因是，如果一个对象在finalize（）方法中执行缓慢，或者发生了死循环（更极端的情
             况），将很可能会导致F-Queue队列中其他对象永久处于等待，甚至导致整个内存回收系统
             崩溃。 finalize（）方法是对象逃脱死亡命运的最后一次机会，稍后GC将对F-Queue中的对象
             进行第二次小规模的标记，如果对象要在finalize（）中成功拯救自己——只要重新与引用链
             上的任何一个对象建立关联即可，譬如把自己（this关键字）赋值给某个类变量或者对象的
             成员变量，那在第二次标记时它将被移除出“即将回收”的集合；如果对象这时候还没有逃
             脱，那基本上它就真的被回收了。
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC test = null;

    public static void main(String []args) throws InterruptedException {
        test = new FinalizeEscapeGC();
        test = null;
        System.gc();
        Thread.sleep(500);
        isActive();
        test.doSomething();

        test = new FinalizeEscapeGC();
        System.gc();
        Thread.sleep(500);
        test = null;
        isActive();
        test.doSomething();//此时对象已经死亡,无法继续执行doSomething()方法
    }

    private static void isActive() {
        if (test != null) {
            System.out.println("对象没有死亡,自救成功");
        }else {
            System.out.println("对象已经死亡, 自救失败");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("调用finalize方法...");
        FinalizeEscapeGC.test = this; //自救
    }

    private void doSomething(){
        for (int i=0; i<10; i++) {
            System.out.println("执行到第 " + i + "个");
        }
    }
}
