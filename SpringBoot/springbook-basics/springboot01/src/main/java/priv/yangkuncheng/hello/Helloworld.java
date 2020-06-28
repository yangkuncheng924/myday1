package priv.yangkuncheng.hello;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication   来标注一个主程序类，说明这是一个Spring boot应用
 */
@SpringBootApplication
public class Helloworld {
    public static void main(String[] args){
      // Spring应用启动run
        SpringApplication.run(Helloworld.class,args);
    }
}
