package reflect;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Random;

public class ReflectTest2 {

    @Test
    public void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        Person songziming = constructor.newInstance("songziming", 22);
        System.out.println(songziming);

        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(songziming,"songyida");
        System.out.println(songziming);

        Method say = personClass.getMethod("say");
        say.invoke(songziming);

        Method say1 = personClass.getMethod("say", String.class);
        say1.invoke(songziming,"hello world");

    }

    @Test
    public void test2() throws ClassNotFoundException {
        Class<Person> personClass = Person.class;

        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();

        Class<?> aClass1 = Class.forName("reflect.Person");

        System.out.println(personClass==aClass);
        System.out.println(personClass==aClass1);
        System.out.println(aClass==aClass1);

        ClassLoader classLoader = ReflectTest2.class.getClassLoader();
        Class<?> aClass2 = classLoader.loadClass("reflect.Person");
        System.out.println(aClass==aClass2);
    }


    @Test
    public void test3() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("a.properties"));
//        properties.load(new FileInputStream("src\\b.properties"));
        String name = properties.getProperty("name");
        String age = properties.getProperty("age");
        System.out.println("name = " + name + " age = " + age);

        ClassLoader classLoader = ReflectTest2.class.getClassLoader();
        properties.load(classLoader.getResourceAsStream("b.properties"));
        String name2 = properties.getProperty("name");
        String age2 = properties.getProperty("age");
        System.out.println("name = " + name2 + " age = " + age2);

    }

    public static Object getClassPath(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName(classPath);
        return aClass.newInstance();
    }

    @Test
    public void test4() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(3)+1){
                case 1:
                    System.out.println(getClassPath("java.util.Date"));
                    break;
                case 2:
                    System.out.println(getClassPath("java.lang.Object"));
                    break;
                case 3:
                    System.out.println(getClassPath("reflect.Person"));
                    break;
            }
        }
    }
}
