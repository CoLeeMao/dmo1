package test2;

import org.junit.Test;

public class Test2 {
    @Test
    public void test1(){
        Integer i1=100;
        Integer i2=100;
        Integer i3=200;
        Integer i4=200;

        System.out.println(i1==i2);
        System.out.println(i3==i4);
    }

    @Test
    public void test2() {
//        String s="123";
//        char c='a';
//        Integer integer=1;
//        int a=integer.intValue();
//        Integer integer1 = Integer.valueOf(s);
//        Character character = Character.valueOf(c);
//        System.out.println(character);
//        System.out.println(integer1);
//        float f1= (float) 3.4;
//        double f2=3.4;
////        System.out.println(a);
//
//        char d = 1;
//        System.out.println(d);
        System.out.println(5%2);
    }

    @Test
    public void test3() {
        System.out.println(getSum(1,2));
        getSum2(1,2);
    }

    public static int getSum(int a,int b){
        return a+b;
    }

    public static void getSum2(int a,int b){
        System.out.println(a+b);
    }

    public static void change(int a,int b){
        int temp;
        temp=a;
        a=b;
        b=temp;
    }

    public static void change2(Integer a,Integer b){
        Integer temp;
        temp=a;
        a=b;
        b=temp;
    }

    @Test
    public void test4() {
//        int a=3,b=4;
//        change(a,b);

        Integer a=3,b=4;
        change(a,b);
        System.out.println(a+"   "+b);
    }


}
