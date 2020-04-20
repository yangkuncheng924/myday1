package P_observer;

/**
 * @City
 * 普通模式
 * 显示当前天气情况（可以理解成是气象站自己的网站）
 * @City
 */
public class CurrentConditions {
    private float temperature;//温度
    private float pressure;    //气压
    private float humidity;   //湿度

    //更新 天气情况 石油WeatherData来调用 我使用推送模式
    public void update(float temperature,float pressure,float humidity){
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        display();
    }
    public  void display(){
        System.out.println("***Today mTemperature:"+temperature+"***");
        System.out.println("***Today mTemperature:"+pressure+"***");
        System.out.println("***Today mTemperature:"+humidity+"***");
    }
}
