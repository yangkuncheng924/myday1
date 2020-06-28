package priv.yangkuncheng.basic;

public class User {
    private String name;
    private String password;

    public User() {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
