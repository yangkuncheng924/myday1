package priv.yangkuncheng.action;

import com.opensymphony.xwork2.Action;
import priv.yangkuncheng.entity.User;
import priv.yangkuncheng.service.UserService;

public class RegAction implements Action {
    private UserService userService;

    private User user;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {
        userService.register(user);
        return Action.SUCCESS;
    }

}
