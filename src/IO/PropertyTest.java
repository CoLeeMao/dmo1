package IO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertyTest {
    @Test
    public void test1(){
        Properties properties = new Properties();
        properties.setProperty("songziming1","221");
        properties.setProperty("songziming2","222");
        properties.setProperty("songziming3","223");
        properties.setProperty("songziming4","224");

        System.out.println(properties);

        System.out.println(properties.getProperty("songziming2"));

        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey()+"---"+entry.getValue());
        }
    }

    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\1\\zxc.txt"));
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey()+"---"+entry.getValue());
        }
    }
}
