package IO.szm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImgsDeleteTest {

    public static void main(String[] args) {
        File file = new File("D:\\pictures\\e");
        File[] files = file.listFiles();
        for (File file1 : files) {
//            System.out.println(file1.getName());
//            if (file1)
            String name = file1.getName();
            if (name.contains("gif")) {
//                System.out.println(name.substring(name.length() - 7, name.length() - 4));
                if ("(1)".equals(name.substring(name.length() - 7, name.length() - 4))){
                    file1.delete();
                }
            }
        }

    }
}
