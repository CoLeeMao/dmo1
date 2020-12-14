package file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileTest {
    @Test
    public void test1() {
        File f = new File("D:/1/2/3.txt");
        System.out.println("文件绝对路径:" + f.getAbsolutePath());
        System.out.println("文件构造路径:" + f.getPath());
        System.out.println("文件名称:" + f.getName());
        System.out.println("文件长度:" + f.length() + "字节");
        System.out.println();

        File f2 = new File("D:/1/2");
        System.out.println("目录绝对路径:" + f2.getAbsolutePath());
        System.out.println("目录构造路径:" + f2.getPath());
        System.out.println("目录名称:" + f2.getName());
        System.out.println("目录长度:" + f2.length());
        System.out.println();

        File f3 = new File("D:\\1\\2\\3.txt");
        System.out.println("目录绝对路径:" + f3.getAbsolutePath());
        System.out.println("目录构造路径:" + f3.getPath());
        System.out.println("目录名称:" + f3.getName());
        System.out.println("目录长度:" + f3.length());
    }

    @Test
    public void test2() {
        File file = new File("a.txt");
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void test3() throws IOException {
        File file = new File("D:\\1\\2\\qwe.txt");
        System.out.println(file.exists());
        System.out.println(file.createNewFile());
        System.out.println(file.isFile());
        System.out.println();

        File file2 = new File("D:\\1\\2\\5.txt");
        System.out.println(file2.exists());
        System.out.println(file2.createNewFile());
        System.out.println(file2.isFile());
        System.out.println();

        File file1 = new File("D:\\1\\2");
        System.out.println(file1.isDirectory());
    }

    @Test
    public void test4() {
//        File file = new File("D:\\1\\2\\8\\9");
//        file.mkdir();

        File file1 = new File("D:\\1\\2\\6\\7");
        file1.mkdirs();
    }

    @Test
    public void test5() {
        File file = new File("D:\\1\\2");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println();

        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1);
        }
    }
}
