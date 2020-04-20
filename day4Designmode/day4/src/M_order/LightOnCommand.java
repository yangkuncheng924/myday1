package M_order;

/**
 * @City
 * @City
 */
public class LightOnCommand implements Command {

    public LightOnCommand(LightReceiver light) {
        this.light = light;
    }

    //聚合LightReceiver
   LightReceiver light;
    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
