package demo1;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Demo1 {

    @Test
    public void test1() {
        Scanner scanner = new Scanner(System.in);
        /*String next = scanner.next();
        System.out.println(next);*/
        System.out.println(scanner.next());
    }

    @Test
    public void test2() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextInt(10) + 10);
        }
    }

    @Test
    public void test3() {
        int i = new Random().nextInt(10);
        while (true) {
            int i1 = new Scanner(System.in).nextInt();
            if (i1 == i) {
                System.out.println("succeed");
                break;
            } else if (i1 > i) {
                System.out.println("bigger");
            } else if (i1 < i) {
                System.out.println("smaller");
            }
        }
    }

    @Test
    public void test4() {
        int a = (int) 1.5;

    }

    @Test
    public void test5() {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Hel" + "lo";
        String s4 = "Hel" + new String("lo");
        String s5 = new String("Hello");
        String s6 = s5.intern();
        String s7 = "H";
        String s8 = "ello";
        String s9 = s7 + s8;

        System.out.println(s1 == s2);  // true
        System.out.println(s1 == s3);  // true
        System.out.println(s1 == s4);  // false
        System.out.println(s1 == s9);  // false
        System.out.println(s4 == s5);  // false
        System.out.println(s1 == s6);  // true
    }

    @Test
    public void t6() {
         final String a = "123";
         final String b = "456";

        String c = "123456";
        String d = a + b;
        System.out.println(c == d);
    }

    @Test
    public void t7() throws ParseException {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat sdate = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println(sdate.format(date));
        System.out.println(sdate.parse(sdate.format(date)));
    }

    @Test
    public void t8() throws ParseException {
        System.out.println("请输入生日（格式）：yyyy-MM-dd");
        Scanner scanner = new Scanner(System.in);
        String birthday=scanner.next();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date bir=simpleDateFormat.parse(birthday);
        long birday=bir.getTime();
        long nowday=new Date().getTime();
        long day=nowday-birday;
        if (day<0){
            System.out.println("没出生");
        }else {
            System.out.println("已出生"+day/1000/60/60/24+"天");
            System.out.println("已出生"+day/1000/60/60/24/365+"年");
        }
    }

    @Test
    public void calendar() {
        Calendar instance = Calendar.getInstance();
//        System.out.println(instance.get(Calendar.YEAR)+"年"+(instance.get(Calendar.MONTH)+1)+"月"+instance.get(Calendar.DAY_OF_MONTH)+"日");
//        System.out.println(instance.getTime());
//        System.out.println(System.currentTimeMillis());
//        Date date = new Date(System.currentTimeMillis());
        System.out.println(new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(new Date(System.currentTimeMillis())));
    }

    @Test
    public void stringBulider() {
        String s="Hellow";
        System.out.println(s.hashCode());
        s+="World";
        System.out.println(s.hashCode());
//        -2137068027
//1628190861
    }

    @Test
    public void 包装类() {
//        System.out.println(123+"");
        int a=Integer.parseInt("123");
    }

    @Test
    public void 增强for() {
        /*int[] arr={1,2,3,4};
        for (int i : arr) {
            System.out.println(i);
        }*/

        ArrayList<String> strings = new ArrayList<>();
        strings.add("123");
        strings.add("qwe");
        strings.add("asd");

        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void 泛型() {
        Collection<Integer> list1 = new ArrayList<Integer>();
        Collection<String> list2 = new ArrayList<String>();
        Collection<Number> list3 = new ArrayList<Number>();
        Collection<Object> list4 = new ArrayList<Object>();

        getElement(list1);
//        getElement(list2);//报错
        getElement(list3);
//        getElement(list4);//报错

//        getElement2(list1);//报错
//        getElement2(list2);//报错
        getElement2(list3);
        getElement2(list4);
    }
    // 泛型的上限：此时的泛型?，必须是Number类型或者Number类型的子类
    public static void getElement(Collection<? extends Number> coll){}
    // 泛型的下限：此时的泛型?，必须是Number类型或者Number类型的父类
    public static void getElement2(Collection<? super Number> coll){}

    @Test
    public void comparator() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("adsa");
        strings.add("hgfj");
        strings.add("vcbcv");
        strings.add("erw");

        Collections.sort(strings);
        System.out.println(strings);

        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                return o1.charAt(0)-o2.charAt(0);
                return o2.charAt(0)-o1.charAt(0);
            }
        });
        System.out.println(strings);
    }

    @Test
    public void personsComparator() {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("songziming",22));
        people.add(new Person("songziming1",123));
        people.add(new Person("songziming2",444));
        people.add(new Person("songziming3",2));

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });

        for (Person person : people) {
            System.out.println(person);
        }
    }

    @Test
    public void map() {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("songziming",22);
        stringIntegerHashMap.put("songziming1",221);
        stringIntegerHashMap.put("songziming2",222);
        stringIntegerHashMap.put("songziming3",223);

        /*Set<String> strings = stringIntegerHashMap.keySet();
        for (String string : strings) {
            System.out.println(string+"--"+stringIntegerHashMap.get(string));
        }*/

        Set<Map.Entry<String, Integer>> entries = stringIntegerHashMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }
    }

    @Test
    public void linkedHashMap() {
        LinkedHashMap<String, Integer> lin = new LinkedHashMap<>();
        lin.put("songziming",22);
        lin.put("songziming1",221);
        lin.put("songziming2",222);
        lin.put("songziming3",223);

        Set<Map.Entry<String, Integer>> entries = lin.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }

        System.out.println(lin);
    }

    @Test
    public void getCharNums() {
        System.out.println("请输入字符串：");
        getNums(new Scanner(System.in).next());
    }

    public static void getNums(String string){
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char c=string.charAt(i);
            if (!characterIntegerHashMap.containsKey(c)){
                characterIntegerHashMap.put(c,1);
            }else {
                Integer integer = characterIntegerHashMap.get(c);
                characterIntegerHashMap.put(c,++integer);
            }
        }
        System.out.println(characterIntegerHashMap);
    }

    @Test
    public void test21() {
        int a=4,b=5;
        change(a,b);
        System.out.println("a: "+a);
        System.out.println("b: "+b);
    }

    public static void change(int a,int b){
        int temp;
        temp=a;
        a=b;
        b=temp;
    }

    @Test
    public void test22() {
        String s1="qwe",s2="asd";
        change2(s1,s2);
        System.out.println("s1: "+s1);
        System.out.println("s2: "+s2);
    }

    public static void change2(String s1,String s2){
        String temp;
        temp=s1;
        s1=s2;
        s2=temp;
    }

    @Test
    public void test23() {
        Person p1 = new Person("songziming1", 22);
        Person p2 = new Person("songziming2", 23);
//        change3(p1,p2);
        change4(p1,p2);
        System.out.println("p1: "+p1);
        System.out.println("p2: "+p2);
    }

    public static void change3(Person p1,Person p2){
        Person temp;
        temp=p1;
        p1=p2;
        p2=temp;
    }

    /**
     *
     * @param p1
     * @param p2
     */
    public static void change4(Person p1,Person p2){
        p1.setAge(p2.getAge());
        p2.setName(p1.getName());
    }

    @Test
    public void test24() {
        int a=333,b=55,c=8;
        a=a>b?a:b;
        c=a>c?a:c;
        System.out.println(c);
    }
}
