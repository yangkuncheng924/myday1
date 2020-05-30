package M_order;

/**
 * @City
 * @City
 */
public class TVOffCommand implements Command{
    //聚合LightReceiver
    TVReceiver tv;
    public TVOffCommand(TVReceiver tv) {
        this.tv = tv;
    }
    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }
}
