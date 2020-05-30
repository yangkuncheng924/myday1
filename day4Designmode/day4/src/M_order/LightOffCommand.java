package M_order;

/**
 * @City
 * @City
 */
public class LightOffCommand implements Command{
    public LightOffCommand(LightReceiver light) {
        this.light = light;
    }

    //聚合LightReceiver
    LightReceiver light;
    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
