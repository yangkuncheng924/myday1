package priv.yangkuncheng.dynamic;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Arround implements MethodInterceptor {
    /*
        invoke方法的作用:额外功能书写在invoke
                       额外功能 原始方法之前
                               原始方法之后
                               原始方法执行之前 之后
       确定:原始方法怎么运行

       参数:MethodInvocation (Method): 额外功能所增加给的那个原始方法
        login
        register
        invocation.proceed() --> login运行
                                 register运行
        返回值:Object:原始方法的返回值
        Date covert(String name)
     */
//    @Override
//    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
//        System.out.println("--- log---");
//        Object ret = methodInvocation.proceed();
//        return  false;
//    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }
}
