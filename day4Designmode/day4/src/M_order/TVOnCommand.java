package M_order;

/**
 * @City
 * @City
 */
public class TVOnCommand implements Command{
    //聚合LightReceiver
    TVReceiver tv;
    public TVOnCommand(TVReceiver tv) {
        this.tv = tv;
    }
    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    }
}
