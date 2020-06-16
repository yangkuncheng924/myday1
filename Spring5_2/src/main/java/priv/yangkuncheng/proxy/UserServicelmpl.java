package priv.yangkuncheng.proxy;

public class UserServicelmpl implements UserService {
    public void register(User user) {
        System.out.println("UserServicelmpl.register");
    }

    public boolean login(String name, String password) {
        System.out.println("UserServicelmpl.login");
        return true;
    }
}
