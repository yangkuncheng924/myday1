package priv.yangkuncheng.dao;

import org.apache.ibatis.annotations.Param;
import priv.yangkuncheng.pojo.Books;

import java.util.List;
public interface BookMapper {
    //增加
    int addBook(Books books);
    //删除
    int deleteBookId(@Param("bookid") int id);
    //更新
    int updateBook(Books books);
    //查询
    Books selectBookId(@Param("bookid") int id);
    //查询全部
    List<Books> queryAllBook();
}
