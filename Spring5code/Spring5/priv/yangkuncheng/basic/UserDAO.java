package priv.yangkuncheng.basic;

public interface UserDAO {
    void save(priv.yangkuncheng.basic.User user);

    void queryUserByNameAndPassword(String name, String password);
}
