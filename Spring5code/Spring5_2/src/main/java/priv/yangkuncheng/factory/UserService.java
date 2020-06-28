package priv.yangkuncheng.factory;

import priv.yangkuncheng.proxy.User;

public interface UserService {
    public void login(String name, String password);

    public void register(User user);
}
