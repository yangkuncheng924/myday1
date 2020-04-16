package A_Single_case3;

/**
 * @City
 *双重检查  推荐使用
 * @City
 */
public class DuplicationCheck {
    public static void main(String[] args){
        Single1 single=Single1.getSingle1();
        Single1 single1=Single1.getSingle1();
        System.out.println(single==single1);
        System.out.println(single);
        System.out.println(single1);
        System.out.println("hashCole"+single.hashCode());
        System.out.println("hashCole1"+single1.hashCode());
    }
}
//************************ 双重检查 线程  安全
class Single1{
    private  static volatile Single1 single1;
    private Single1(){

    }
    //创建一个公有的静态方法 使用时创建single
    //加入了双重检查的代码 解决了线程安全问题 同时解决懒加载问题
    //保证了效率
    public  static synchronized Single1 getSingle1() {
        if (single1 == null) {
            synchronized(Single1.class){
                if(single1==null){
                    single1 = new Single1();
                }
            }
        }
        return  single1;
    }
}
