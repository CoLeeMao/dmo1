package IO;

import java.io.Serializable;

public class Person implements Serializable {
    public String name;
    public int age;
    public transient float heigh;

    public float getHeigh() {
        return heigh;
    }

    public void setHeigh(float heigh) {
        this.heigh = heigh;
    }

    public Person(String name, int age, float heigh) {
        this.name = name;
        this.age = age;
        this.heigh = heigh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
