package IO;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class IOTest {

    @Test
    public void test1() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\1\\2\\3\\5.txt");
        fileOutputStream.write(65);
        fileOutputStream.write(66);
        fileOutputStream.write(67);
        fileOutputStream.write(68);
        fileOutputStream.write(69);
        fileOutputStream.close();
    }

    @Test
    public void test2() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\1\\qwe.txt");
        fileOutputStream.write("我是你大爷".getBytes());
        fileOutputStream.close();
    }

    @Test
    public void test3() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\1\\qwe.txt");
        fileOutputStream.write("abcde".getBytes(),2,2);
        fileOutputStream.close();
    }

    @Test
    public void test4() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\1\\qwe.txt",true);
        fileOutputStream.write("abcde\r\n".getBytes());
        fileOutputStream.close();
    }

    @Test
    public void test5() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\1\\qwe.txt");
        int b;
        while((b= fileInputStream.read())!=-1){
            System.out.println((char)b);
        }
        fileInputStream.close();
    }

    @Test
    public void test6() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\1\\qwe.txt");
        int len;
        byte[] bytes=new byte[2];
        while ((len= fileInputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        fileInputStream.close();
    }

    @Test
    public void test7() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\pictures\\e\\1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\1\\1_copy.jpg");

        byte[] bytes=new byte[1024];
        int len;
        while ((len=fileInputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,len);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    @Test
    public void test8() throws IOException {
        FileReader fileReader = new FileReader("D:\\1\\asd.txt");
        int b;
        while ((b= fileReader.read())!=-1){
            System.out.println((char)b);
        }
        fileReader.close();
    }

    @Test
    public void test9() throws IOException {
        FileReader fileReader = new FileReader("D:\\1\\asd.txt");
        int len;
        char[] chars=new char[2];
        while ((len= fileReader.read(chars))!=-1){
            System.out.println(new String(chars,0,len));
        }
        fileReader.close();
    }

    @Test
    public void test10() throws IOException {
        FileWriter fileWriter = new FileWriter("D:\\1\\asd.txt");
        fileWriter.write(65);
        fileWriter.write(97);
        fileWriter.write('b');
        fileWriter.write('C');
        fileWriter.write(30000);
        fileWriter.close();
    }

    @Test
    public void test11() throws IOException {
        FileWriter fileWriter = new FileWriter("D:\\1\\asd.txt");
        String s = new String("松果弹抖闪电鞭");
        for (int i = 0; i < s.length(); i++) {
            fileWriter.write(s.charAt(i));
            fileWriter.flush();
        }
        fileWriter.close();
    }

    @Test
    public void test12() throws IOException {
        FileWriter fileWriter = new FileWriter("D:\\1\\asd.txt",true);
        char[] chars = "松果弹抖闪电鞭\r\n".toCharArray();
        fileWriter.write(chars);
        fileWriter.write(chars,2,2);
        fileWriter.close();
    }

    @Test
    public void test13() throws IOException {
        FileWriter fileWriter = new FileWriter("D:\\1\\asd.txt",true);
        String s="\r\n松果弹抖闪电鞭";
        fileWriter.write(s);
        fileWriter.write(s,4,3);
        fileWriter.close();
    }

    @Test
    public void test14() throws IOException {
        FileReader fileReader = new FileReader("D:\\1\\asd.txt");
        FileWriter fileWriter = new FileWriter("D:\\1\\qwe.txt");
        try(fileReader;fileWriter){
            int b;
            while ((b=fileReader.read())!=-1){
                fileWriter.write(b);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void test15() throws IOException {
        HashMap<String, String> stringStringHashMap = new HashMap<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\1\\出师表.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\1\\qwe.txt"));

        String line=null;

        while ((line=bufferedReader.readLine())!=null){
            String[] split = line.split("\\.");
            stringStringHashMap.put(split[0],split[1]);
        }

        bufferedReader.close();

        for (int i = 1; i <= stringStringHashMap.size(); i++) {
            String key = String.valueOf(i);
            String value = stringStringHashMap.get(key);
            bufferedWriter.write(key+"."+value);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }

    @Test
    public void test16() throws FileNotFoundException {
        try {
            InputStreamReader inputStreamReader =
//                    new InputStreamReader(new FileInputStream("D:\\1\\qwe.txt"),"GBK");
                    new InputStreamReader(new FileInputStream("D:\\1\\qwe.txt"));
            int read;
            while ((read=inputStreamReader.read())!=-1){
                System.out.println((char)read);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test17() throws IOException {
        OutputStreamWriter outputStreamWriter =
//                new OutputStreamWriter(new FileOutputStream("D:\\1\\qwe.txt"));
                new OutputStreamWriter(new FileOutputStream("D:\\1\\qwe.txt"),"UTF-8");
        outputStreamWriter.write("松果弹抖闪电鞭");
        outputStreamWriter.close();
    }

    @Test
    public void test18() throws IOException {
        InputStreamReader inputStreamReader = new
                InputStreamReader(new FileInputStream("D:\\1\\asd.txt"),"GBK");
        OutputStreamWriter outputStreamWriter =
                new OutputStreamWriter(new FileOutputStream("D:\\1\\qwe.txt"));

        char[] chars = new char[1024];
        int len;
        while ((len= inputStreamReader.read(chars))!=-1){
            outputStreamWriter.write(chars,0,len);
        }

        inputStreamReader.close();
        outputStreamWriter.close();
    }

    @Test
    public void test19() throws IOException {
        Person songziming = new Person("songziming", 21, (float) 170.0);
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream("D:\\1\\qwe.txt"));
        objectOutputStream.writeObject(songziming);
        objectOutputStream.close();
    }

    @Test
    public void test20() throws IOException, ClassNotFoundException {
        ArrayList<Student> students = new ArrayList<>();
        Student songziming1 = new Student("songziming1", 221);
        Student songziming2 = new Student("songziming2", 222);
        Student songziming3 = new Student("songziming3", 223);
        students.add(songziming1);
        students.add(songziming2);
        students.add(songziming3);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\1\\qwe.txt"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\1\\qwe.txt"));
        objectOutputStream.writeObject(students);

        ArrayList<Student> students1=(ArrayList<Student>) objectInputStream.readObject();
        for (Student student : students1) {
            System.out.println(student.getName()+"---"+student.getAge());
        }

        objectInputStream.close();
        objectOutputStream.close();
    }
}
