package priv.yangkuncheng;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import priv.yangkuncheng.proxy.*;

public class TextProxy {
    /*
        测试静态代理代码
     */
    @Test
    public void test1() {
        UserService userService = new UserServiceProxy();
        userService.login("suns", "123456");
        userService.register(new User());

        System.out.println("-------------------");
        OrderService orderService = new OrderServiceProxy();
        orderService.showOrder();
    }

    //测试动态代理
    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("xiaoyang", "123456");
        userService.register(new User());

    }

    //测试orderservice动态代理
    @Test
    public void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        OrderService orderService = (OrderService) ctx.getBean("orderService");

        orderService.showOrder();
    }
}
