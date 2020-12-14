package datetest;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class DateTest {
    @Test
    public void test1(){
        Date date = new Date();
        System.out.println(date);
    }

    @Test
    public void test2() {
        Calendar instance = Calendar.getInstance();
//        System.out.println(instance);
        Date time = instance.getTime();
        int i = instance.get(Calendar.DAY_OF_YEAR);
        System.out.println(i);
    }
}
