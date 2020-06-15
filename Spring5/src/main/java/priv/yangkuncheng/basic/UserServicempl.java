package priv.yangkuncheng.basic;

public class UserServicempl implements UserService{
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void register(User user) {
        userDAO.save(user);
    }
    @Override
    public void login(String name, String password) {
        userDAO.queryUserByNameAndPassword(name,password);
    }


}
