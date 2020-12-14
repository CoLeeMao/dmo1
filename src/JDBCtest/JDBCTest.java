package JDBCtest;

import org.junit.Test;

import java.sql.*;
import java.util.Scanner;

public class JDBCTest {

    @Test
    public void test1() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "123456");
        String sql = "insert into tb_person(id,name,age) values(null,\"songziming\",22)";
        Statement statement = root.createStatement();
        int i = statement.executeUpdate(sql);
        System.out.println(i);

        statement.close();
        root.close();
    }

    @Test
    public void test2() {
        Statement statement = null;
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String sql = "insert into tb_person(name,age,gender) values(\"songziming\",22,\'M\')";

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "123456");

            statement = connection.createStatement();

            int i = statement.executeUpdate(sql);

            if (i > 0) {
                System.out.println("insert success");
            } else {
                System.out.println("insert fail");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3() {
        Statement statement = null;
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String sql = "update tb_person set age=123 where id=149";

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "123456");

            statement = connection.createStatement();

            int i = statement.executeUpdate(sql);

            if (i > 0) {
                System.out.println("update success");
            } else {
                System.out.println("update fail");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test4() {
        Statement statement = null;
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String sql = "delete from tb_person where id=149";

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "123456");

            statement = connection.createStatement();

            int i = statement.executeUpdate(sql);

            if (i > 0) {
                System.out.println("delete success");
            } else {
                System.out.println("delete fail");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test5() {
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String sql = "select * from tb_person";

            connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "123456");

            statement = connection.createStatement();

            resultSet = statement.executeQuery(sql);

            resultSet.next();

            int anInt = resultSet.getInt(1);
            String string = resultSet.getString(2);
            int anInt1 = resultSet.getInt(3);
            String string1 = resultSet.getString(4);
            System.out.println(anInt + "----" + string + "----" + anInt1 + "----" + string1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test6() {
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String sql = "select * from tb_person";

            connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "123456");

            statement = connection.createStatement();

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int anInt = resultSet.getInt(1);
                String string = resultSet.getString(2);
                int anInt1 = resultSet.getInt(3);
                String string1 = resultSet.getString(4);
                System.out.println(anInt + " ---- " + string + " ---- " + anInt1 + " ---- " + string1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test7() {
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCutils.getConnection();
            String sql="select * from tb_user";
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                Date birthday = resultSet.getDate("birthday");
                System.out.println(id+"--- "+password+"--- "+name+"--- "+gender+"--- "+birthday);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCutils.close(resultSet,statement,connection);
        }
    }

    @Test
    public void test8() {
        System.out.println("请输入id: ");
        int i = new Scanner(System.in).nextInt();
        boolean byID = getByID(i);
        if (byID){
            System.out.println("id存在");
        }else {
            System.out.println("id不存在");
        }
    }

    public static boolean getByID(int id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        try {
            connection=JDBCutils.getConnection();
            String sql="select * from tb_user where id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            boolean next = resultSet.next();
            System.out.println(resultSet.getInt("id")+"-- "+ resultSet.getString("password")+"-- "+
                    resultSet.getString("name")+"-- "+resultSet.getString("gender")+"-- "+
                    resultSet.getDate("birthday"));
            return next;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCutils.close(resultSet,preparedStatement,connection);
        }
        return false;
    }

    @Test
    public void test9() {
        Connection connection=null;
        PreparedStatement preparedStatement=null;

        try {
            connection= JDBCutils2.getConnection();
            String sql="insert into tb_user values(null,?,?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,"qwer1234");
            preparedStatement.setString(2,"songziming22");
            preparedStatement.setString(3,"M");
            preparedStatement.setDate(4, Date.valueOf("2020-11-17"));

            int i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCutils2.close(preparedStatement,connection);
        }
    }
}
