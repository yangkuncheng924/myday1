package priv.yangkuncheng.jdk;

import priv.yangkuncheng.proxy.User;
import priv.yangkuncheng.proxy.UserService;
import priv.yangkuncheng.proxy.UserServicelmpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDKProxy {
    public static void main(String[] args) {
        /*
            1. 借用类加载器 TestJDKProxy
                          UserServicelmpl
            2. JDK8.x前
            final UserService userService = new UserServicelmpl();
         */
        //创建原始对象
        UserService userService = new UserServicelmpl();

        //jdk动态代理
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("-------proxy log ----------");
                Object ret = method.invoke(userService, args);
                return ret;
            }
        };
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(TestJDKProxy.class.getClassLoader(), userService.getClass().getInterfaces(), handler);
        userServiceProxy.login("yang", "123456");
        userServiceProxy.register(new User());

    }
}
