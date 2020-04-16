package A_Single_case5;

/**
 * @City
 * @City
 */
public class Enumeration {
    public static void main(String[] args) {


        Singleton instance = Singleton.INSTANCE;
        Singleton instance1 = Singleton.INSTANCE;
        System.out.println(instance==instance1);
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
        instance.sayOK();
        instance1.sayOK();
    }
}
//使用枚举 完成单例设计模式 推荐使用
enum  Singleton{
    INSTANCE;
    public  void sayOK(){
        System.out.println("OK");
    }
}
