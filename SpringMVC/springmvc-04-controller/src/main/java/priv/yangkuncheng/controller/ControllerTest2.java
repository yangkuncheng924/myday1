package priv.yangkuncheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.IntToDoubleFunction;

@Controller
public class ControllerTest2 {

    @RequestMapping("/ttt")
    public String test1(Model model) {
        model.addAttribute("msg", "ControllerTest2");
        return "hello";
    }
}
//@Controller
//public class HelloController {
//    @RequestMapping("hello")
//    public String hello(Model model){
//        model.addAttribute("msg","hello,springmvc");
//        return "hello";
//    }
//}
