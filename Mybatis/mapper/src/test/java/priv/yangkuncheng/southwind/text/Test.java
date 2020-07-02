package priv.yangkuncheng.southwind.text;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import priv.yangkuncheng.repository.StudenRepository;

import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        System.out.println(inputStream);
        SqlSessionFactory   sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudenRepository studenRepository= sqlSession.getMapper(StudenRepository.class);
        System.out.println("studenRepository.findByIdLazy(1L) = " + studenRepository.findByIdLazy(1L));
//        System.out.println("studenRepository.findById(1) = " + studenRepository.findById(1));
        //        StudenRepository studenRepository = sqlSession.getMapper(StudenRepository.class);
//        System.out.println(studenRepository.findById(1L));
        sqlSession.close();
    }
}


