package M_order;

/**
 * @City
 * @City
 */
public interface Command {

    //执行动作
    public  void execute();
    //撤销动作
    public  void  undo();
}
