package A_Single_case5;

/**
 * @City
 * 静态内部类 完成单例模式
 * @City
 */
public class StaticInner {
    public static void main(String[] args){
        Single1 single= Single1.getSingle1();
        Single1 single1= Single1.getSingle1();
        System.out.println(single==single1);
        System.out.println(single);
        System.out.println(single1);
        System.out.println("hashCole"+single.hashCode());
        System.out.println("hashCole1"+single1.hashCode());
    }
}
//******************静态内部类  推荐使用
class Single1{
    private  static volatile Single1 single1;
   //构造器私有化
    private Single1(){

    }
    //写一个静态内部类 该类中有一个属性 Single1
    private  static  class  StaticSinglel{
        private  static  final  Single1 INSTANCE=new Single1();
    }

    //提供一个静态公有方法 返回静态的对象
    public  static synchronized Single1 getSingle1() {
        return  StaticSinglel.INSTANCE;
    }
}
