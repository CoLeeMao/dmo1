package JDBCtest;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCutils2 {
    private static DataSource dataSource;

    static {
        try {
        Properties properties = new Properties();
            properties.load(JDBCutils2.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource= DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close(ResultSet resultSet,Statement statement,Connection connection){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(Statement statement,Connection connection){
        close(null,statement,connection);
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
}
