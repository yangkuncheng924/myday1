package N_visitor;

/**
 * @City
 * @City
 */
public class Man extends Person {

    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
