package JDBCtest;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTemplateTest {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCutils2.getDataSource());

    @Test
    public void test1() {
        String sql = "update tb_user set password=? where id=?";
        int update = jdbcTemplate.update(sql, "123123123", 2);
        System.out.println(update);
    }

    @Test
    public void test2() {
        String sql="insert into tb_user values(null,?,?,?,?)";
        int update = jdbcTemplate.update(sql, "qweasdzxc", "songziming111", "M", Date.valueOf("2020-11-11"));
        System.out.println(update);
    }

    @Test
    public void test3() {
        String sql="delete from tb_user where id=?";
        int update = jdbcTemplate.update(sql, 5);
        System.out.println(update);
    }

    @Test
    public void test4() {
        String sql="select * from tb_user where id=?";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, 2);
        System.out.println(stringObjectMap);
    }

    @Test
    public void test5() {
        String sql="select * from tb_user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    @Test
    public void test6() {
        String sql="select * from tb_user";
        List<User> query = jdbcTemplate.query(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                return new User(resultSet.getInt("id"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("gender"),
                        resultSet.getDate("birthday"));
            }
        });

        for (User user : query) {
            System.out.println(user);
        }
    }

    @Test
    public void test7() {
        String sql="select * from tb_user";
        List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        for (User user : query) {
            System.out.println(user);
        }
    }

    @Test
    public void test8() {
        String sql="select count(id) from tb_user";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(integer);
    }
}
