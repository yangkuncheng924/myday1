package E_adapter;

/**
 * @City
 * 类适配器模式
 * @City
 */
public class Client {
    public static void main(String[] args) {
        Phone phone=new Phone();
        phone.charging(new VoltageAdapter());


    }
}
