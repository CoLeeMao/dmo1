package reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

    @Test
    public void test1() throws Exception {
        Class<Person> personClass = Person.class;

        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println();

        Field a = personClass.getField("a");
        Person songziming = new Person("songziming", 22);
        Object o = a.get(songziming);
        System.out.println(o);
        System.out.println();

        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println();

        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        Object o1 = name.get(songziming);
        System.out.println(o1);
    }

    @Test
    public void test2() throws Exception {
        Class<Person> personClass = Person.class;

        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        Person songziming = constructor.newInstance("songziming", 22);
        System.out.println(songziming);
    }

    @Test
    public void test3() throws Exception {
        Class<Person> personClass = Person.class;

        Method say = personClass.getMethod("say");
        Person person = new Person();
        Object invoke = say.invoke(person);

        Method say1 = personClass.getMethod("say", String.class);
        Object invoke1 = say1.invoke(person,"qwe");

        System.out.println();
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();
        String name = personClass.getName();
        System.out.println(name);
    }
}
