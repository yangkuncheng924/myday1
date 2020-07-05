package priv.yangkunchen.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
    使用 @interface来定义注解
 */
//自定义注解
public class test01 {
    //    注解可以显示赋值，如果没有默认值，我们就必须给注解赋值
    @MyAnnotation2(name = "hello")
    public void test1() {
        String name;
    }

    @MyAnnotation3(value = "1")
    public void test2() {


    }

    //            类               方法
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface MyAnnotation2 {
        //注解的参数 ： 参数类型+参数名（）；
        String name() default "";

        int id() default 0;

        String password() default "123";

    }

    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface MyAnnotation3 {

        String value();
    }
}



