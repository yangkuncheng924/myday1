package P_observer1;

/**
 * @City
 * @City
 */
public class CurrentConditions implements Observer{
    private float temperature;//温度
    private float pressure;    //气压
    private float humidity;   //湿度

    public  void display(){
        System.out.println("***Today mTemperature:"+temperature+"***");
        System.out.println("***Today mTemperature:"+pressure+"***");
        System.out.println("***Today mTemperature:"+humidity+"***");
    }


    @Override
    public void ubdate(float temperature, float pressure, float humidity) {
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        display();
    }
}
