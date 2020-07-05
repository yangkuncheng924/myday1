package priv.yangkuncheng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.yangkuncheng.pojo.Books;
import priv.yangkuncheng.service.BookService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
//    controller调用 service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

//    查询全部的书籍 并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books>booksList = bookService.queryAllBook();
        model.addAttribute("list",booksList);
        return "allBook";

    }
}
