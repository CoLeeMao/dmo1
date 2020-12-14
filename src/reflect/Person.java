package reflect;

public class Person {
    private String name;
    private int age;

    public int a;
    protected int b;
    int c;
    private int d;

    public void say(){
        System.out.println("say nothing");
    }

    public void say(String s){
        System.out.println("say: "+s);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
