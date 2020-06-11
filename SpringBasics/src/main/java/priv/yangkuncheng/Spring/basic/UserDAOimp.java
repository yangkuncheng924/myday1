package priv.yangkuncheng.Spring.basic;

public class UserDAOimp implements UserDAO{
    @Override
    public void save(User user) {
        System.out.println("insert into user ="+ user);
    }


    @Override
    public void queryUserByNameAndPassword(String name, String password) {
        System.out.println("query User name = " + name + " password " + password);
    }
}
