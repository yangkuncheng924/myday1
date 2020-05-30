package L_templateMethod1;

/**
 * @City
 * @City
 */
public class PureSoyaMilk extends SoyaMilk {
    @Override
    void addCondiments() {
    //空实现
    }

    @Override
    boolean customerWantCondiments() {
        return false;
    }
}
