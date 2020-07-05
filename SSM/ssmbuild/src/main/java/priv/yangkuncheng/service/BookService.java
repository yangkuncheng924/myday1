package priv.yangkuncheng.service;

import org.apache.ibatis.annotations.Param;
import priv.yangkuncheng.pojo.Books;

import java.util.List;

public interface BookService {
    //增加
    int addBook(Books books);
    //删除
    int deleteBookId(int id);
    //更新
    int updateBook(Books books);
    //查询
    Books selectBookId(int id);
    //查询全部
    List<Books> queryAllBook();
}
