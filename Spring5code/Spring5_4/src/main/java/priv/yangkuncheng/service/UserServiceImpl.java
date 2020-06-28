package priv.yangkuncheng.service;

import org.springframework.transaction.annotation.Transactional;

import priv.yangkuncheng.dao.UserDAO;
import priv.yangkuncheng.entity.User;

@Transactional
public class UserServiceImpl implements UserService {
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
}
