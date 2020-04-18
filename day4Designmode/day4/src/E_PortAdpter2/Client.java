package E_PortAdpter2;

/**
 * @City
 * @City
 */
public class Client {
    public static void main(String[] args) {
        AbsAdapter absadapter = new AbsAdapter() {
            @Override
            public void m1() {
                System.out.println("使用m1的方法");
            }
        };
        absadapter.m1();
    }
}
