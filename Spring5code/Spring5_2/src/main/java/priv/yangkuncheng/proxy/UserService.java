package priv.yangkuncheng.proxy;

public interface UserService {
    public void register(User user);

    public boolean login(String name, String password);


}
