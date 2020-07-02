package priv.yangkuncheng.southwind.text;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import priv.yangkuncheng.entity.Account;

import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        System.out.println("inputStream = " + inputStream);

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        String statement = "priv.yangkuncheng.mapper.AccountMapper.save";

        Account account = new Account(1, "杨坤城", "123", 22);

        sqlSession.insert(statement,account);

        sqlSession.commit();

        System.out.println("hello");
    }
}
