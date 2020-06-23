package priv.yangkuncheng.basic;

public class UserServicempl implements priv.yangkuncheng.basic.UserService {
    private priv.yangkuncheng.basic.UserDAO userDAO;

    public priv.yangkuncheng.basic.UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(priv.yangkuncheng.basic.UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void register(priv.yangkuncheng.basic.User user) {
        userDAO.save(user);
    }
    @Override
    public void login(String name, String password) {
        userDAO.queryUserByNameAndPassword(name,password);
    }


}
