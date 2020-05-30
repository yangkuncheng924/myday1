package G_decorator;

/**
 * @City
 * @City
 */
public class Decorator extends Drink {
    private Drink obj;

    public Decorator(Drink obj) {
        //组合
        this.obj = obj;
    }

    @Override
    public float cose() {
        //价格
        return super.getPrice()+obj.cose();
    }

    @Override
    public String getDes() {
        return des+" "+getPrice()+"&&"+obj.getDes();
    }
}
