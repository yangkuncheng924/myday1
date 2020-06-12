package priv.yangkuncheng.TestSpring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import priv.yangkuncheng.Spring.basic.Person;
import priv.yangkuncheng.Spring.basic.User;
import priv.yangkuncheng.Spring.basic.UserService;
import priv.yangkuncheng.Spring.basic.constructer.Customer;

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
    public void test4(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println(customer);
    }

}
