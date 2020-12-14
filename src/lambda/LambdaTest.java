package lambda;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class LambdaTest {
    @Test
    public void test1(){

        String a="aaaa";
        String b="bbbb";
        String c="cccc";

        log(1,()->{
            System.out.println("Lambda 1执行。。。");
            return a+b+c;
        });

        log(2,()->{
            System.out.println("Lambda 2执行。。。");
            return a+b+c;
        });
    }

    public static void log(int level,MessageBuilder messageBuilder){
        if (level==1){
            System.out.println(messageBuilder.buildmessage());
        }
    }

    @Test
    public void test2() {

        int array[]={1,2,3,44,555,666,77,8,9};
        int Max=getMax(()->{
            int max=array[0];
            for (int i : array) {
                if (i>max){
                    max=i;
                }
            }
            return max;
        });
        System.out.println(Max);
    }

    //Lambda作为返回值
    public static int getMax(Supplier<Integer> supplier){
        return supplier.get();
    }

    @Test
    public void test3() {
        consumerString(s-> System.out.println(s));
    }

    public static void consumerString(Consumer<String> consumer){
        consumer.accept("Helloworld");
    }

    @Test
    public void test4() {
        consuerString2(
                s -> System.out.println(s.toUpperCase()),
                s-> System.out.println(s.toLowerCase())
        );
    }

    public static void consuerString2(Consumer<String> consumer1,Consumer<String> consumer2){
        consumer1.andThen(consumer2).accept("Helloworld");
    }

    @Test
    public void test5() {
        String[] array={"songziming1,man,22","songziming2,man,23","songziming3,women,33"};
        printInfo(
                s -> System.out.println("姓名："+s.split(",")[0]),
                s -> System.out.println("性别："+s.split(",")[1]),
                s -> System.out.println("年龄："+s.split(",")[2]),
                array
        );
    }

    public static void printInfo(Consumer<String> c1,Consumer<String> c2,Consumer<String> c3,String[] array){
        for (String s : array) {
            c1.andThen(c2).andThen(c3).accept(s);
        }
    }
}
