package priv.yangkuncheng.service;

import org.springframework.transaction.annotation.Transactional;
import priv.yangkuncheng.entity.User;
import priv.yangkuncheng.mybatis.UserDAO;

@Transactional
public class UserServiceimpl implements UserService {
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void register(User user) {
       // userDAO.save(user);
    }
}
