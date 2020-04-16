package E_adapter;

/**
 * @City
 * 适配器类
 * @City
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5V() {
        int srcV=output220V();
        int dstV=srcV/44;
        System.out.println("转换后"+dstV);
        return dstV;
    }
}
