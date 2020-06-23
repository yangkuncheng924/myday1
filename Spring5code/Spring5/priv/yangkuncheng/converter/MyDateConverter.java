package priv.yangkuncheng.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateConverter implements Converter<String, Date> {

    private String pattern;


    /*
        convert方法作用:  String--->DAte
                        SimpleDateFormat sdf = new SimpleDateFormat();
                        sdf.parset(String) ---> Date
        param: source代表的是配置文件中 日期字符串<value>2020-06-15</value>

        returun: 当把转换好的Date作为convert方法的返回值后,Spring自动的为birthday属性进行注入(赋值)
     */
    @Override
    public Date convert(String source) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
