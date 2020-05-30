package N_visitor;

/**
 * @City
 * 说明
 * 1.这里我们使用到了爽分派，即首先在客户端程序中，将具体状态作为参数传递Woman中第一次分派
 * 2.然后Woman类调用作为参数的“具体方法”中方法getWomanResult，同时将自己this作为参数
 *    传入，完成第二次的分派
 * @City
 */
public class Woman extends Person{

    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
