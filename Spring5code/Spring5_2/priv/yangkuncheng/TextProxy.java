package priv.yangkuncheng;

import org.junit.Test;
import org.testng.annotations.AfterTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import priv.yangkuncheng.basic.User;
import priv.yangkuncheng.basic.UserService;


public class TextProxy {
//    /*
//        测试静态代理代码
//     */
//    @Test
//    public void test1() {
//        UserService userService = new priv.yangkuncheng.proxy.UserServiceProxy();
//        userService.login("suns", "123456");
//        userService.register(new User());
//
//        System.out.println("-------------------");
//        priv.yangkuncheng.proxy.OrderService orderService = new priv.yangkuncheng.proxy.OrderServiceProxy();
//        orderService.showOrder();
//    }

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
        priv.yangkuncheng.proxy.OrderService orderService = (priv.yangkuncheng.proxy.OrderService) ctx.getBean("orderService");

        orderService.showOrder();
    }
}
