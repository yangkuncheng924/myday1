package E_adapter;

/**
 * @City
 * @City
 */
public class Phone {
    //充电
    public  void charging(IVoltage5V iVoltage5V){
        if(iVoltage5V.output5V()==5){
            System.out.println("可以充电");
        } else if(iVoltage5V.output5V()>5&&iVoltage5V.output5V()<5){
            System.out.println("转换后不=5V");
        }
    }
}
