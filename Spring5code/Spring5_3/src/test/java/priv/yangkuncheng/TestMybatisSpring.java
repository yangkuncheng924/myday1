package priv.yangkuncheng;

import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import priv.yangkuncheng.mybatis.User;
import priv.yangkuncheng.mybatis.UserDAO;

public class TestMybatisSpring {
    /*
        用于测试：Spring与MyBatis的整合
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");

        User user = new User();
        user.setName("xiaoyang");
        user.getpawword("1233456");

        userDAO.save(user);
    }
}
