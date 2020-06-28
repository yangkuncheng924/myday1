package priv.yangkuncheng.proxy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import priv.yangkuncheng.Log;

public class UserServicelmpl implements UserService, ApplicationContextAware {
    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }


    @Log
    public void register(User user) {
        System.out.println("UserServicelmpl.register");
    }

    public boolean login(String name, String password) {
        System.out.println("UserServicelmpl.login");
        return true;
    }

}
