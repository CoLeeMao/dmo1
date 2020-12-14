package digui;

import java.io.File;

public class FileDigui {
    public static void main(String[] args) {
        printDir(new File("D:\\1\\2"));
    }

    public static void printDir(File file){
        File[] files = file.listFiles();

        for (File file1 : files) {
            if (file1.isFile()){
                if (file1.getName().endsWith(".java")){
                    System.out.println(file1.getAbsolutePath());
                }
            }else {
                printDir(file1);
            }
        }
    }
}
