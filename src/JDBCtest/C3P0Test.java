package JDBCtest;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Test {
    @Test
    public void test1() throws SQLException {
        DataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
