import org.junit.Test;

import java.util.Random;

/**
 * Created by admin on 2017/1/15.
 */
public class TestDemo {

    public static void printArray(Object[] args) {
        for (Object obj : args) {
            System.out.println(obj.toString());
            System.out.println();
        }
    }

    public static void printArray1(Object...args) {
        for (Object obj : args) {
            System.out.println(obj.toString());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //printArray(new String[]{"a", "b", "c", "d"});
        printArray1(new Integer(1),new String("2"),new Double(3.0));
    }

    @Test
    public void test1() {
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            int nextInt = random.nextInt(10);
            System.out.println(nextInt);
        }
    }

    @Test
    public void test2(){
        String tuesday = WeekDay.getDay("Mon");
        System.out.println(tuesday);


    }
}
