package B_Segregation;

/**
 * @City
 * 对1类进行改进的改进，优化
 * 使用接口隔离原则
 * @City
 */
public class Segregation2 {
    public static void main(String[] args) {
        AA aa = new AA();
        aa.depend1(new BB()); //A类通过接口依赖BB
        aa.depend2(new BB());
        aa.depend3(new BB());

        CC cc = new CC();
        cc.depend1(new DD());
        cc.depend4(new DD());
        cc.depend5(new DD());


    }
}
//接口
interface  Interfacel11{
    void operation1();
}
//接口2
interface Intefacel22{
    void operation2();
    void operation3();
}
//接口3
interface Intefacel33{
    void operation4();
    void operation5();
}
/************************************************************/
class AA{       //A类通过interface1接口 使用b类的方法 但只会用到1，2,3
    public  void depend1(Interfacel11 i){
        i.operation1();
    }
    public  void depend2(Intefacel22 i){
        i.operation2();
    }
    public  void depend3(Intefacel22 i){
        i.operation3();
    }
}

class CC{       //C类通过interface1接口 使用b类的方法 但只会用到1，2,3
    public  void depend1(Interfacel11 i){
        i.operation1();
    }
    public  void depend4(Intefacel33 i){
        i.operation4();
    }
    public  void depend5(Intefacel33 i){
        i.operation5();
    }

}

class BB implements Interfacel11,Intefacel22{

    public void operation1() {
        System.out.println("B实现了operaton1");
    }


    public void operation2() {
        System.out.println("B实现了operaton2");
    }


    public void operation3() {
        System.out.println("B实现了operaton3");
    }
}

//D调用了接口
class DD implements Interfacel11,Intefacel33{
    @Override
    public void operation1() {
        System.out.println("D实现了operaton1");
    }

    public void operation4() {
        System.out.println("D实现了operaton4");
    }

    public void operation5() {
        System.out.println("D实现了operaton5");
    }
}
