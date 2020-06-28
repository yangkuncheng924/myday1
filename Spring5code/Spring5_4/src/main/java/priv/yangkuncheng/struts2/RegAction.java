package priv.yangkuncheng.struts2;


import com.opensymphony.xwork2.Action;
import priv.yangkuncheng.struts2.userService;

public class RegAction implements Action {
    private userService userService;

    public priv.yangkuncheng.struts2.userService getUserService() {
        return userService;
    }

    public void setUserService(priv.yangkuncheng.struts2.userService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception {
        userService.register();

        return Action.SUCCESS;
    }


}
