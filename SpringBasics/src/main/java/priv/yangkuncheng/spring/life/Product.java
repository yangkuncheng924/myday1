package priv.yangkuncheng.spring.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Product implements InitializingBean, DisposableBean {

    public Product() {
        System.out.println("Product.Product");
    }

    public void myInit() {
        System.out.println("Product.myInit");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Product.afterPropertiesSet");
    }

    //销毁方法
    @Override
    public void destroy() throws Exception {
        System.out.println("Product.destroy");
    }

    public void mydestroy()throws Exception {
        System.out.println("Product.destroy");
    }
}
