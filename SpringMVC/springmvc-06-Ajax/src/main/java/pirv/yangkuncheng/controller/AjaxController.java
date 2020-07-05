package pirv.yangkuncheng.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {
    @RequestMapping("/t1")
    public String test1(){
        return "hello";
    }
}
