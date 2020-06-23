package priv.yangkuncheng.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import priv.yangkuncheng.proxy.User;

public class Test {
    public static void main(String[] args){
      ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext1.xml");
      UserService userService = (UserService) ctx.getBean("userService");
      userService.login("yang","1234");
      userService.register(new User());
    }
}
