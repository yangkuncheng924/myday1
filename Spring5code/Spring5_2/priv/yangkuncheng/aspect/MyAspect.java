package priv.yangkuncheng.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

@org.aspectj.lang.annotation.Aspect
public class MyAspect {
    @Pointcut("execution(* login(..))")
    public void myPointuct() {

    }

    @Around(value = "myPointuct()")
    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("----log ----");

        Object ret = joinPoint.proceed();
        return ret;
    }
}

