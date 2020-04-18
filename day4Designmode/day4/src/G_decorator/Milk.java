package G_decorator;

/**
 * @City
 * @City
 */
public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        setDes("牛奶");
        setPrice(5.0f);
    }
}
