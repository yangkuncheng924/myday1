package G_decorator;

/**
 * @City
 * @City
 */
public class CoffeeBar {
    public static void main(String[] args) {
        //点一份 LongBlack
        Drink order=new LongBlack();
        System.out.println("费用="+order.cose());
        System.out.println(order.getDes());

        System.out.println("加入一份牛奶");
        //加入一份牛奶
        order=new Milk(order);
        System.out.println("费用="+order.cose());
        System.out.println(order.getDes());

        System.out.println("再加入一份巧克力");
        //加入一份巧克力
        order=new Chocolate(order);
        System.out.println("费用="+order.cose());
        System.out.println(order.getDes());
    }}

