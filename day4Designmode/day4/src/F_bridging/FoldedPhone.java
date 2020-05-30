package F_bridging;

/**
 * @City
 * 折叠式手机 继承了抽象类
 * @City
 */
public class FoldedPhone extends Phone {
    public FoldedPhone(brand brand1) {
        super(brand1);
    }
    public  void open(){
        super.open();
        System.out.println("折叠手机");
    }
    public  void close(){
        super.close();
        System.out.println("折叠样式手机");
    }
    public  void call(){
        super.call();
        System.out.println("折叠手机");
    }
}
