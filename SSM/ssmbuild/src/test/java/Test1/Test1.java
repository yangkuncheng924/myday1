package Test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import priv.yangkuncheng.pojo.Books;
import priv.yangkuncheng.service.BookService;

public class Test1 {

    @org.junit.Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicatyonContext.xml");
        BookService bookServiceImpl = (BookService) ctx.getBean("BookServiceImpl");

        for (Books books : bookServiceImpl.queryAllBook()) {
            System.out.println("books = " + books);
        }

    }
}
