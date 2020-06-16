package priv.yangkuncheng.proxy;

public class UserServiceProxy implements UserService {
    private UserServicelmpl userServicelmpl = new UserServicelmpl();

    public void register(User user) {
        System.out.println("---log----");
        userServicelmpl.register(user);

    }

    public boolean login(String name, String password) {
        System.out.println("---log---");
        return userServicelmpl.login(name, password);
    }
}
