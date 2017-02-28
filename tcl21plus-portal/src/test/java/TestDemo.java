import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/2/10.
 */
public class TestDemo {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            if (i % 15 == 0) {
                list.add("fizz buzz");
            } else if (i % 3 == 0) {
                list.add("fizz");
            } else if (i % 5 == 0) {
                list.add("buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    @Test
    public void test1() {
        TestDemo testDemo = new TestDemo();
        List<String> list = testDemo.fizzBuzz(20);
        System.out.println(list);
    }
}
