package priv.yangkuncheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestFulController {
    @RequestMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a,@PathVariable String b, Model model){
        String res = a+b;
        model.addAttribute("msg","结果为"+res);
        return "hello";
    }

}
