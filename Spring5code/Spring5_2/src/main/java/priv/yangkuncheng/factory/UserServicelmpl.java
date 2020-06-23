package priv.yangkuncheng.factory;

import priv.yangkuncheng.proxy.User;

public class UserServicelmpl implements UserService {
    @Override
    public void login(String name, String password) {
        System.out.println("UserServicelmpl.login");
    }

    @Override
    public void register(User user) {
        System.out.println("UserServicelmpl.register");
    }
}
