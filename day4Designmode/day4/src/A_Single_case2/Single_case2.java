package A_Single_case2;

/**
 * @City
 * 虽然解决了线程安全问题 但是效率太低 开发不推荐使用
 * @City
 */
public class Single_case2 {
    public static void main(String[] args){
        Single single=Single.getSingle();
        Single single1=Single.getSingle();
        System.out.println(single==single1);
        System.out.println(single);
        System.out.println(single1);
        System.out.println("hashCole"+single.hashCode());
        System.out.println("hashCole1"+single1.hashCode());
    }
}
//************************ 懒汉式 线程  安全
class Single1{
    private  static  Single1 single1;
    private Single1(){

    }
    //创建一个公有的静态方法 使用时创建single 既懒汉
    //加入了同步处理的代码 解决了线程安全问题
    public  static synchronized Single1 getSingle() {
        if (single1 == null) {
            single1 = new Single1();

        }
        return  single1;
    }
}

