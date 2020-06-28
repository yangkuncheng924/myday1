package priv.yangkuncheng.aspect;

import priv.yangkuncheng.proxy.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestApsectProxy {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext2.xml");
        UserService userService = (UserService) ctx.getBean("userservice");

        userService.login("sun", "123");
        userService.register(new User());
    }
}
