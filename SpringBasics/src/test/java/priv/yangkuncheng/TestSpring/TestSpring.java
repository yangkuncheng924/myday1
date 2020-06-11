package priv.yangkuncheng.TestSpring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import priv.yangkuncheng.Spring.basic.User;
import priv.yangkuncheng.Spring.basic.UserService;

public class TestSpring {
    //给用户自定义类型成员变量赋值
    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService)ctx.getBean("userService");

        userService.register(new User("suns","123456"));
        userService.login("xiaohei","9999999999");


    }
}
