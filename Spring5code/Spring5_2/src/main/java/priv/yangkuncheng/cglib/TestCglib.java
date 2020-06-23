package priv.yangkuncheng.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import priv.yangkuncheng.proxy.User;

import java.lang.reflect.Method;

public class TestCglib {
    public static void main(String[] args) {
        // 创建原始对象
        UserService userService = new UserService();

        Enhancer enhancer = new Enhancer();

        enhancer.setClassLoader(TestCglib.class.getClassLoader());
        enhancer.setSuperclass(userService.getClass());

        MethodInterceptor interceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("--- cglib log ----");
                Object invoke = method.invoke(userService, objects);
                return invoke;
            }
        };
        enhancer.setCallback(interceptor);

        UserService userService1 = (UserService) enhancer.create();

        userService1.login("yang","1234");
        userService1.register(new User());

    }


}
