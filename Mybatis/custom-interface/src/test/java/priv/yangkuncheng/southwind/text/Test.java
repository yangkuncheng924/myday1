package priv.yangkuncheng.southwind.text;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import priv.yangkuncheng.entity.Account;
import priv.yangkuncheng.repository.AccountRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) {

    }
    @org.junit.Test
    public void test1() throws IOException {
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        System.out.println("inputStream = " + inputStream);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取实现接口的代理对象
        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);

        //添加对象
        Account account = new Account(2, "杨大", "1234", 23);
        accountRepository.save(account);


        //修改对象
        Account account3 = accountRepository.findById(10);
        account3.setUsername("猴哥");
        account3.setPassword("666");
        account3.setAge(25);
        account3.setId(9);


        //删除对象
        int result1 = accountRepository.deleteById(11);
        int result2 = accountRepository.update(account3);



        //更新事务
        System.out.println(result2);
        sqlSession.commit();               //提交事务


        //查询对象
        List<Account> list = accountRepository.findAll();
        for (Account account1 : list) {
            System.out.println("account1= " + account1);
        }

        System.out.println("-----log---------");

        //通过id查询
        Account account2 = accountRepository.findById(3);
        System.out.println(account2);

        System.out.println(accountRepository.findByNameAndAge("小猴子",222));
        System.out.println(accountRepository.count());
        System.out.println(accountRepository.count2());
        System.out.println(accountRepository.findNameById(1));

        //关闭
        inputStream.close();
        sqlSession.close();
    }
}

