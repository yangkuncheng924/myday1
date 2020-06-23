package priv.yangkuncheng.aspect;

import priv.yangkuncheng.Log;
import priv.yangkuncheng.proxy.User;
import priv.yangkuncheng.proxy.UserService;

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
