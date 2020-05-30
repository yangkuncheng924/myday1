package E_ObjectAdapter1;

/**
 * @City
 * 对象适配器模式
 * @City
 */
public class Client {
    public static void main(String[] args) {
        Phone phone=new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));


    }
}
