package A_Sing;

/**
 * @City
 * @City
 */
public class SingletonTest02 {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getSingleton1();
        Singleton1 singleton11 = Singleton1.getSingleton1();
        System.out.println(singleton1 == singleton11); //true
        System.out.println("singleton.hashCode=" + singleton1.hashCode());
        System.out.println("singleton.hashCode=" + singleton11.hashCode());
    }
}
//恶汉式(静态代码块）
class Singleton1{
    //1.构造器私有化
    private  Singleton1(){

    }
    //2.本类内部创建对象实例
    private   static  Singleton1 singleton1;

    //3.在静态代码块创建单例
    static {
        singleton1=new Singleton1();
    }

    //提供一个公有的静态方法 返回对象
    public  static Singleton1 getSingleton1(){
        return  singleton1;
    }


}

