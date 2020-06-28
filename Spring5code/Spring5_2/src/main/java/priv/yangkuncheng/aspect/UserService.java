package priv.yangkuncheng.aspect;

import priv.yangkuncheng.proxy.User;

public interface UserService {
    void register(User user);

    boolean login(String name, String password);

}
