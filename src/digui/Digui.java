package digui;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

public class Digui {
    @Test
    public void test1() {
        System.out.println(sum(10));

        int sum = 0;
        for (int i = 0; i <= 10; i++) {
            sum += i;
        }
        System.out.println(sum);

        System.out.println(sum2(4));

        int sum2 = 1;
        for (int i = 1; i < 5; i++) {
            sum2 *= i;
        }
        System.out.println(sum2);
    }

    public static int sum(int n) {
        if (n > 1) {
            return n + sum(n - 1);
        } else {
            return 1;
        }
    }

    public static int sum2(int n) {
        if (n > 1) {
            return n * sum2(n - 1);
        } else {
            return 1;
        }
    }

    @Test
    public void fileDigui() {
        printDir(new File("D:\\1\\2"));
    }

    public static void printDir(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile()) {
                System.out.println(file1.getAbsolutePath());
            } else {
                System.out.println(file1.getAbsolutePath());
                printDir(file1);
            }
        }
    }

    @Test
    public void test6() {
        printDir2(new File("D:\\1\\2"));
    }

    public static void printDir2(File file) {
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java") || pathname.isDirectory();
            }
        });

        for (File file1 : files) {
            if (file1.isFile()) {
                System.out.println("filename: " + file1.getAbsolutePath());
            } else {
                printDir2(file1);
            }
        }
    }

    @Test
    public void test7() {
        printDir3(new File("D:\\1\\2"));
    }

    public static void printDir3(File file) {
        File[] files = file.listFiles(f -> {
            return f.getName().endsWith(".java") || f.isDirectory();
        });

        for (File file1 : files) {
            if (file1.isFile()) {
                System.out.println("filename: " + file1.getAbsolutePath());
            } else {
                printDir2(file1);
            }
        }
    }
}
