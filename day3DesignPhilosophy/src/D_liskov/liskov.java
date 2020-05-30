package D_liskov;

/*
 * @City
 * @City
 */
public class liskov {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("20-30="+a.fun1(20, 30));
        System.out.println("50-30="+a.fun1(50, 30));
        System.out.println("-------------------------");

        B b = new B();
        System.out.println("20-30="+b.fun1(20, 30));
        System.out.println("120-30="+b.fun1(120, 30));
        System.out.println("50-50="+b.fun2(50,50 ));
        /* 1.我们发现原来正常运行的减法出现了一个错误。原因是B类无意中重写了父类方法 造成原油功能出现错误。
         *         在实际的编程中，我们经常通过重写父类的方法来完成新的功能，写起来虽然简单，但是整个继承系统的可重用性很差。
        * 2.一般的方法是:原来的父类和子类继承一个比较通俗的基类，原来的继承去掉，采用相依性、聚集性、组合性等关系替代
        *
        * */
    }
}
class A{
    public  int fun1(int nber,int nuber){
        //功能是返回两个数减
        return nber-nuber;
    }
}
class B extends A{
    public int fun1(int nber1,int nuber2){
        //重写了此方法 变成两数相加
        return nber1+nuber2;
    }
    public int fun2(int nber1,int nuber2){
        //返回值是两数相加并且加9
        return fun1(nber1,nuber2)+9;
    }
}
