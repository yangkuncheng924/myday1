package priv.yangkuncheng.springbook03;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import priv.yangkuncheng.springbook03.bean.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
class Springbook03ApplicationTests {
    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;
    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Test
    void testHelloService(){
        boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }
}
