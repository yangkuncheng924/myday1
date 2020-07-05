package priv.yangkunchen.reflect;

public class Reflection02 {
}

class A{
    static {
        System.out.println("m");
        m=200;
    }
    static int m=100;
    static {

    }
}
