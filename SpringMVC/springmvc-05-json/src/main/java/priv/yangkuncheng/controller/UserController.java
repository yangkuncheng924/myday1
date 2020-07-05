package priv.yangkuncheng.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import priv.yangkuncheng.pojo.User;
import priv.yangkuncheng.utils.JsonUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
@RestController
public class UserController {
    @RequestMapping("tiyi")
    @ResponseBody   //它就不会走视图解析器
    public String json1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User("yangyi",3,"男");
        String str = mapper.writeValueAsString(user);
        return user.toString();
    }

    @RequestMapping("js")
    public String json2() {
        ObjectMapper mapper = new ObjectMapper();
        List<User> list = new ArrayList<User>();

        User user = new User("yangyi",3,"男");
        User user1 = new User("yanger",4,"男");
        User user2 = new User("yangsan",5,"男");
        User user3 = new User("yangsi",6,"男");

        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);

        String str = null;
        try {
            str = mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return str;
    }
    @RequestMapping("js1")
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();

        //自定义日期的格式 转换时间
        SimpleDateFormat std = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return mapper.writeValueAsString( std.format(date));
    }

    @RequestMapping("js2")
    public String json4() {
        Date date = new Date();
//        return JsonUtils.getJson(date,"yyyy-MM-dd HH:mm:ss");
        return JsonUtils.getJson(date);
    }

    @RequestMapping("js3")
    public String json5() {
        ObjectMapper mapper = new ObjectMapper();
        List<User> list = new ArrayList<User>();

        User user = new User("yangyi",3,"男");
        User user1 = new User("yanger",4,"男");
        User user2 = new User("yangsan",5,"男");
        User user3 = new User("yangsi",6,"男");

        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        String string = JSON.toJSONString(list);

        return string;
    }
}
