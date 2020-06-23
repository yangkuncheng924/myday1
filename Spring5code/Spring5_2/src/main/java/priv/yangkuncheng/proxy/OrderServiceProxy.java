package priv.yangkuncheng.proxy;

public class OrderServiceProxy implements OrderService {
    private OrderServiceimpl orderServiceimpl = new OrderServiceimpl();
    public void showOrder() {
        System.out.println("---log---");
        orderServiceimpl.showOrder();
    }
}
