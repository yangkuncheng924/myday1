package N_visitor;

/**
 * @City
 * @City
 */
public class Success extends  Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("男人评价是成功！");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女人评价是成功！");
    }
}
