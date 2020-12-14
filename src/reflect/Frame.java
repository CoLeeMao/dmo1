package reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Frame {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Properties properties = new Properties();

        ClassLoader classLoader = Frame.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("pro.properties");
        properties.load(resourceAsStream);

        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        Class aClass = Class.forName(className);
        Object o = aClass.newInstance();
        Method method = aClass.getMethod(methodName);

        method.invoke(o);
    }
}
