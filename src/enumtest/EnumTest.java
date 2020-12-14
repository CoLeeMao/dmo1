package enumtest;

import org.junit.Test;

public class EnumTest {
    @Test
    public void test1(){
        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value.toString());
        }

        Season spring = Season.valueOf("SPRING");
        System.out.println(spring.toString());
    }
}
