package priv.yangkuncheng.Spring.basic;

public interface UserDAO {
    void save(User user);

    void queryUserByNameAndPassword(String name, String password);
}
