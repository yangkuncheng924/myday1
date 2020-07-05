package priv.yangkunchen.reflect;

import org.testcontainers.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testcontainers.shaded.org.yaml.snakeyaml.scanner.Constant;

public class Reflection01 {
    public static void main(String[] args){
      Class c1 = Object.class;
      Class c2 = Comparable.class;
      Class c3 = void.class;
      Class c4 = JsonTypeInfo.As.class;
      Class c5 = Constant.class;
        System.out.println("c1 = " + c1);
        System.out.println("c1 = " + c2);
        System.out.println("c1 = " + c3);
        System.out.println("c1 = " + c4);
        System.out.println("c1 = " + c5);

    }
}
