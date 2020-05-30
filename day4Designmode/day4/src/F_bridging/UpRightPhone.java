package F_bridging;

/**
 * @City
 * @City
 */
public class UpRightPhone extends  Phone {
    public UpRightPhone(brand brand1) {
        super(brand1);
    }
    public  void open(){
        super.open();
        System.out.println("直立手机");
    }
    public  void close(){
        super.close();
        System.out.println("直立样式手机");
    }
    public  void call(){
        super.call();
        System.out.println("直立手机");
    }
}
