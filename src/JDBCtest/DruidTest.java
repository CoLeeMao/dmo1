package JDBCtest;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class DruidTest {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(DruidTest.class.getClassLoader().getResourceAsStream("druid.properties"));
        DataSource dataSource= DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
