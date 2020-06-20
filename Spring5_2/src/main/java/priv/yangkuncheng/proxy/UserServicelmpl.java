package priv.yangkuncheng.proxy;

import priv.yangkuncheng.Log;

public class UserServicelmpl implements UserService {
    @Log
    public void register(User user) {
        System.out.println("UserServicelmpl.register");
    }

    public boolean login(String name, String password) {
        System.out.println("UserServicelmpl.login");
        return true;
    }
}
