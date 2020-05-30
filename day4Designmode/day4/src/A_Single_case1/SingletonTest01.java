package A_Sing;

/**
 * @City
 * 恶汉 （静态常量）
 * 优点：这种写法比较简单 就是在类装载时候就完成实例化 避免了线程同步问题
 *
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果 如果从始至终未使用过这个实例 这会内存浪费
 *
 * 
 * @City
 */
public class SingletonTest01 {
    public static void main(String[] args) {
       Singleton singleton=Singleton.getSingleton();
        Singleton singleton1=Singleton.getSingleton();
        System.out.println(singleton==singleton1); //true
        System.out.println("singleton.hashCode="+singleton.hashCode());
        System.out.println("singleton.hashCode="+singleton1.hashCode());
    }
}
//恶汉式
class Singleton{
    //1.构造器私有化
    private  Singleton(){

    }
    //2.本类内部创建对象实例
     private  final static  Singleton singleton=new Singleton();

    //提供一个公有的静态方法 返回对象
    public  static  Singleton getSingleton(){
        return  singleton;
    }


}