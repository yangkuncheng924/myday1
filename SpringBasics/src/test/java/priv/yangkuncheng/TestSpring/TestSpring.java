package priv.yangkuncheng.TestSpring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import priv.yangkuncheng.spring.basic.Person;
import priv.yangkuncheng.spring.basic.User;
import priv.yangkuncheng.spring.basic.UserService;
import priv.yangkuncheng.spring.basic.constructer.Customer;
import priv.yangkuncheng.spring.factorybean.ConnectionFactoryBean;
import priv.yangkuncheng.spring.life.Product;
import priv.yangkuncheng.spring.scope.Account;

import java.sql.Connection;
import java.util.List;

public class TestSpring {
    //给用户自定义类型成员变量赋值
    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");

        userService.register(new User("suns", "123456"));
        userService.login("xiaohei", "9999999999");
    }

    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
        List<String> list = person.getList();
        System.out.println(list);
    }

    //用于测试Spring文件注入
    @Test
    public void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) ctx.getBean("persona");

        System.out.println("person=" + person);
    }

    //用于测试构造
    @Test
    public void test4() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println(customer);
    }

    //用于测试Factorybean接口
    @Test
    public void test5() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection coon = (Connection) ctx.getBean("coon");
        Connection coon2 = (Connection) ctx.getBean("coon");

        System.out.println(coon);
        System.out.println(coon2);
    }

    //用于测试Factorybean接口
    @Test
    public void test6() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        ConnectionFactoryBean coon = (ConnectionFactoryBean) ctx.getBean("&coon1");
        System.out.println(coon);
    }

    //用于测试实例工厂
    @Test
    public void test7() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection coon = (Connection) ctx.getBean("coon");
        System.out.println(coon);
    }

    //用于测试简单对象的创建次数
    @Test
    public void test8() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Account account = (Account) ctx.getBean("account");
        Account account2 = (Account) ctx.getBean("account");
        System.out.println("account = " + account);
        System.out.println("account2 = " + account2);
    }

    //测试生命周期
    @Test
    public void test9() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Product product = (Product) ctx.getBean("product");
        ctx.close();
    }

    //测试配置文件参数化
    @Test
    public void test10() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext1.xml");
        Connection coon = (Connection) ctx.getBean("coon");
        System.out.println("coon = " + coon);

    }
}
