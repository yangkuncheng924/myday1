package priv.yangkuncheng;

import javassist.ClassPath;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import priv.yangkuncheng.bean.User;
import priv.yangkuncheng.injection.UserServiceImpl;
import priv.yangkuncheng.scope.Customer;

public class TestAnnotation {
    /*
    用于测试 @Component注解
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        User user = (User) ctx.getBean("u");
        System.out.println("user = " + user);
    }

    /*
    用于测试 @Scope注解
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Customer customer = (Customer) ctx.getBean("customer");
        Customer customer1 = (Customer) ctx.getBean("customer");
        System.out.println("customer1 = " + customer1);
        System.out.println("customer1 = " + customer);
    }

    /*
    用于测试 @lazy注解
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
    }

    /*
    用于测试 生命周期相关注释
    */
    @Test
    public void test4() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        ctx.close();
    }

    /*
    用于测试 @Autowired注解
     */
    @Test
    public void test6() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserServiceImpl userServicelmp = (UserServiceImpl) ctx.getBean("userServiceImpl");

        userServicelmp.register();
    }
}
