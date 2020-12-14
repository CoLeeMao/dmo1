package JDBCtest;

import java.sql.Date;

public class User {
    private Integer id;
    private String password;
    private String name;
    private String gender;
    private Date birthday;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User(Integer id, String password, String name, String gender, Date birthday) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    public User() {
    }
}
