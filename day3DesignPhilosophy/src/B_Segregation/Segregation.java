package B_Segregation;

/**
 * @City
 * 接口的简化
 * @City
 */
public class Segregation {
    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());

        C c = new C();
        c.depend1(new D());
        c.depend4(new D());
        c.depend4(new D());
    }
}
//接口
interface  Interfacel1{
    void operation1();
    void operation2();
    void operation3();
    void operation4();
    void operation5();
}

class A{       //A类通过interface1接口 使用b类的方法 但只会用到1，2,3
    public  void depend1(Interfacel1 i){
        i.operation1();
    }
    public  void depend2(Interfacel1 i){
        i.operation2();
    }
    public  void depend3(Interfacel1 i){
        i.operation3();
    }
}

class C{       //C类通过interface1接口 使用b类的方法 但只会用到1，2,3
    public  void depend1(Interfacel1 i){
        i.operation1();
    }
    public  void depend4(Interfacel1 i){
        i.operation4();
    }
    public  void depend5(Interfacel1 i){
        i.operation5();
    }

}

class B implements Interfacel1{
    @Override
    public void operation1() {
        System.out.println("B实现了operaton1");
    }

    @Override
    public void operation2() {
        System.out.println("B实现了operaton2");
    }

    @Override
    public void operation3() {
        System.out.println("B实现了operaton3");
    }

    @Override
    public void operation4() {
        System.out.println("B实现了operaton4");
    }

    @Override
    public void operation5() {
        System.out.println("B实现了operaton5");
    }
}

//D调用了接口
class D implements Interfacel1{
    @Override
    public void operation1() {
        System.out.println("D实现了operaton1");
    }

    @Override
    public void operation2() {
        System.out.println("D实现了operaton2");
    }

    @Override
    public void operation3() {
        System.out.println("D实现了operaton3");
    }

    @Override
    public void operation4() {
        System.out.println("D实现了operaton4");
    }

    @Override
    public void operation5() {
        System.out.println("D实现了operaton5");
    }
}
