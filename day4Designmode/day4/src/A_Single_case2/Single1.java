package A_Single_case2;
/**
 * @City
 * //懒汉式 线程不安全 开发不推荐使用
 * @City
 */
 class Single111{
    public static void main(String[] args) {
        Single single=Single.getSingle();
        Single single1=Single.getSingle();
        System.out.println(single==single1);
        System.out.println(single);
        System.out.println(single1);
        System.out.println("hashCole"+single.hashCode());
        System.out.println("hashCole1"+single1.hashCode());
    }
}
//************************ 懒汉式 线程不安全
class Single{
    private  static  Single single;
    private Single(){

    }
    //创建一个公有的静态方法 使用时创建single 既懒汉
    public  static Single getSingle() {
        if (single == null) {
            single = new Single();
        }
            return  single;
    }
}
