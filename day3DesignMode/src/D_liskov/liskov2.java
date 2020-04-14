package D_liskov;

/**
 * @City
 *
 * 在方法1的改进
 * @City
 */
public class liskov2 {
        public static void main(String[] args) {
            AA a = new AA();
            System.out.println("20-30=" + a.fun1(20, 30));
            System.out.println("50-30=" + a.fun1(50, 30));
            System.out.println("-------------------------");

            BB b = new BB();
            //因为B类不在继承A类，因此调用者，不会func1是求减法
            //调用完成的功能就会很明确
            System.out.println("20+30=" + b.fun1(20, 30));
            System.out.println("120+3=" + b.fun1(120, 30));
            System.out.println("50+50=" + b.fun2(50, 50));

            System.out.println("11-3="+b.fun3(11, 3));
        }
}
class AA extends Base{
    public  int fun1(int nber,int nuber){
        //功能是返回两个数减
        return nber-nuber;
    }
}
class BB extends Base{
    private AA a=new AA();
    public int fun1(int nber1,int nuber2){
        //重写了此方法 变成两数相加
        return nber1+nuber2;
    }
    public int fun2(int nber1,int nuber2){
        //返回值是两数相加并且加9
        return fun1(nber1,nuber2)+9;
    }
    //我们任然想使用A的方法
    public int fun3(int nber1,int nuber2){
        return  this.a.fun1(nber1, nuber2);
    }
}

//创建一个基础的类
class Base{
    //把更加基础的方法写到Base类中
}