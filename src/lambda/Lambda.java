package lambda;

import demo1.Person;

import java.util.Arrays;

public class Lambda {
    public static void main(String[] args) {
        Person[] array = {new Person("songziming1", 2213),
                new Person("songziming2", 2222),
                new Person("songziming3", 2231)};

        Arrays.sort(array, (Person a, Person b) -> {
            return a.getAge() - b.getAge();
        });

        for (Person person : array) {
            System.out.println(person);
        }
    }
}
