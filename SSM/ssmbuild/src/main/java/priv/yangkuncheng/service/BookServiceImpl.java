package priv.yangkuncheng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.yangkuncheng.dao.BookMapper;
import priv.yangkuncheng.pojo.Books;

import java.util.List;
//@Service("BookServiceImpl")
public class BookServiceImpl implements BookService {

    //service调dao层  组合dao
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookId(int id) {
        return bookMapper.deleteBookId(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books selectBookId(int id) {
        return bookMapper.selectBookId(id);
    }


    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }
}
